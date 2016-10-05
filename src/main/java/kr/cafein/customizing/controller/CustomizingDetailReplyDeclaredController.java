package kr.cafein.customizing.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomizingDetailReplyDeclaredController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private CustomizingDetailService customizingDetailService;
	private CustomizingDetailReplyCommand customizingDetailReplyCommand;
	private CustomizingDetailController customizingDetailController;
	private FranchiseCommand franchiseCommand;

	//�Ű� ���â�� �Ű���/�ǽŰ��� ���� �Ѱ��ֱ�
	@RequestMapping("/cafein_user/customizing/customizing_detailReplyDeclared_ajax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam("creply_num") int creply_num,
			@RequestParam("u_uid") String u_uid_declared,
			@RequestParam("custom_num") int custom_num,
			@RequestParam("franchise_num") int franchise_num,
			HttpSession session) {

		log.debug("�ڡڡ�  ��� �Ű� ��Ʈ�ѷ� ���� *");

		if(log.isDebugEnabled()) {
			log.debug("creply_num : " + creply_num);
			log.debug("u_id : " + u_uid_declared);
			log.debug("custom_num : " + custom_num);
			log.debug("franchise_num : " + franchise_num);
		} 

		Map<String,Object> map = new HashMap<String,Object>();

		try {
			//���� �α����� ������� u_uid
			//String u_uid = (String) session.getAttribute("u_uid");

			/*
			 * �α��� ���� �ȵǾ� �����Ƿ�
			 * 
			 * if(u_uid_declared == null) {
	            map.put("result", "logout");


	         }else {*/

			//�Ű���� ����� �������� ��� ���� ��� select �ؿ���
			CustomizingDetailReplyCommand declaredCustomizingReply = customizingDetailService.selectDeclaredCustomizingReply(creply_num);
			map.put("declaredCustomizingReply", declaredCustomizingReply);

			//�Ű���� ȸ���� �г����� �˱����� select
			if(!u_uid_declared.equals("Guest")) {
				MemberCommand declaredMember = customizingDetailService.selectDeclaredMember(u_uid_declared);
				map.put("declaredMember_u_uid", declaredMember.getU_uid());
				map.put("declaredMember_u_name", declaredMember.getU_name());
			}else {
				map.put("declaredMember_u_uid", "Guest");
				map.put("declaredMember_u_name", "Guest");

			}
			map.put("result","success");
			//System.out.println("12345");

			//}

		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}

		return map;
	}

	//��� �Ű� insert
	@RequestMapping(value="/cafein_user/customizing/customizing_ReplyDeclaredRegister.do", method=RequestMethod.POST)
	//@ResponseBody ���ָ� �����۽��� �ν��ؼ� string ���·� return ��Ŵ
	public String submit(@ModelAttribute UserDeclaredCommand declaredCommand,
			@RequestParam("session_u_uid") String u_uid,
			@RequestParam("franchise_num") int franchise_num,
			HttpSession session ) throws Exception{

		log.debug("�ڡڡ�  customizing_ReplyDeclaredRegister ����");

		if(log.isDebugEnabled()){
			log.debug("declaredCommand : " + declaredCommand);
			log.debug("u_uid : " + u_uid);
			//log.debug("custom_num : " + custom_num);
			log.debug("franchise_num : " + franchise_num);
		}

		//d_state[ó������] = 0.ó�� ��, 1.ó�� ��,2.ó�� �Ϸ�, 3ó�� ����, 4. ó�� ���
		int d_state = 0;
		declaredCommand.setD_state(d_state);
		//����� �޽���
		declaredCommand.setD_comment("Ŀ���Ҹ���¡ ��ۿ��� �Ű� �������� ó�� �� �����Դϴ�.");
		
		//��� �Ű�
		customizingDetailService.insertDeclaredReply(declaredCommand);
		
		System.out.println("declaredCommand : " + declaredCommand.toString());
		
		//Ŀ���Ҹ޴� ��۽Ű� �α�, umenu_name=4, umenu_log_state=3 ����
		//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
		//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(4);
		userMenuLogCommand.setUmenu_log_state(3);
		String u_email = customizingDetailService.selectDeclaredMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] ����ڰ� Ŀ���� �޴����� ����� �Ű� �Ͽ����ϴ�."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[Ŀ���� �α�] userMenuLogCommand : " + userMenuLogCommand);


		//login�� js�� ���� ���� �ִµ�  login���� page_registration.js �����۽��� �Ⱦ��Ƿ� �Ű� map���� return ��Ű�� ����
		return "redirect:/cafein_user/customizing/customizing_detail.do?custom_num="+declaredCommand.getD_target_num()+"&franchise_num="+franchise_num+"&u_uid="+u_uid;
	}

}

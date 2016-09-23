package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.StringUtil;

@Controller
public class PCafeDetailReplyDeclaredController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	//�Ű� ���â�� �Ű���/�ǽŰ��� ���� �Ѱ��ֱ�
	@RequestMapping("/cafein_user/private/private_detailReplyDeclared_ajax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam("preply_num") int preply_num
									  ,@RequestParam("u_uid") String u_uid_declared
									  ,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("�Ű���� ��� preply_num : " + preply_num);
			log.debug("�Ű���� u_id : " + u_uid_declared);
		} 
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			//���� �α����� ������� u_uid
			String u_uid = (String) session.getAttribute("u_uid");
			
			if(u_uid == null) {
				map.put("result", "logout");
				
				
			}else {
				
				//�Ű���� ����� �������� ��� ���� ��� select �ؿ���
				PCafeReplyCommand declaredReply = pcafeService.selectDeclaredReply(preply_num);
				map.put("declaredReply", declaredReply);
				
				//�Ű���� ȸ���� �г����� �˱����� select
				if(!u_uid_declared.equals("Guest")) {
					MemberCommand declaredMember = pcafeService.selectDeclaredMember(u_uid_declared);
					map.put("declaredMember_u_uid", declaredMember.getU_uid());
					map.put("declaredMember_u_name", declaredMember.getU_name());
				}else {
					map.put("declaredMember_u_uid", "Guest");
					map.put("declaredMember_u_name", "Guest");
				}

				map.put("result","success");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}
		
		return map;
	}
	
	//��� �Ű� insert
	@RequestMapping(value="/cafein_user/private/private_detailReplyDeclaredRegister.do", method=RequestMethod.POST)
	//@ResponseBody ���ָ� �����۽��� �ν��ؼ� string ���·� return ��Ŵ
	public String submit(@ModelAttribute UserDeclaredCommand declaredCommand,
						 int pcafe_num,
						 HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("declaredCommand : " + declaredCommand);
			log.debug("pcafe_num : " + pcafe_num);
		}
		System.out.println("private_detailReplyDeclaredRegister_ajax ����");
		
		//d_state[ó������] = 0.ó�� ��, 1.ó�� ��,2.ó�� �Ϸ�, 3ó�� ����, 4. ó�� ���
		int d_state = 0;
		declaredCommand.setD_state(d_state);
		//�Ű� ���(���)�� ���� ��� ������(����ī�� ������)
		declaredCommand.setD_target_num(pcafe_num);
		//����� �޽���
		declaredCommand.setD_comment("����ī�� ��ۿ��� �Ű� �������� ó�� �� �����Դϴ�.");
		//�Ű��� �ٹٲ� ó��
		declaredCommand.setD_content(StringUtil.useBrNoHtml(declaredCommand.getD_content()));
		
		//��� �Ű�
		pcafeService.insertDeclaredReply(declaredCommand);
		
		String u_uid = (String)session.getAttribute("u_uid"); 
		//����ī�� ��۽Ű� �α�, umenu_name=3, umenu_log_state=3 ����
		//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
		//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(3);
		userMenuLogCommand.setUmenu_log_state(3);
		String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] ����ڰ� ����ī�信�� ����� �Ű� �Ͽ����ϴ�."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		pcafeService.insertUserLog(userMenuLogCommand);
		log.debug("[����ī�� �α�] userMenuLogCommand : " + userMenuLogCommand);
		
		//login�� js�� ���� ���� �ִµ�  login���� page_registration.js �����۽��� �Ⱦ��Ƿ� �Ű� map���� return ��Ű�� ����
		return "redirect:/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num;
	}

}

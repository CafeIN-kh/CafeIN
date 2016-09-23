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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.StringUtil;

@Controller
public class PCafeDetailReplyRegisterController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping(value="/cafein_user/private/private_detailReplyRegister_ajax.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute
							@Valid PCafeReplyCommand pcafeReplyCommand,
							HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pcafeReplyCommand : " + pcafeReplyCommand);
		}
		System.out.println("private_detailReplyRegister_ajax ����");
		
		Map<String,String> map = new HashMap<String,String>();
		
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid != null) {
			pcafeReplyCommand.setU_uid(u_uid);
			
		}else {
			u_uid = "Guest";
			pcafeReplyCommand.setU_uid(u_uid);
		}
		
		//�ٹٲ� ó��
		pcafeReplyCommand.setPreply_content(StringUtil.useBrNoHtml(pcafeReplyCommand.getPreply_content()));
		
		//�α��� ��, ��� ���
		pcafeService.insertReply(pcafeReplyCommand);
		
		//����ī��  ��� ��� �α�, umenu_name=3, umenu_log_state=0 ����
		//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
		//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(3);
		userMenuLogCommand.setUmenu_log_state(0);
		String logMessage = "";
		if(!u_uid.equals("Guest")){
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			logMessage = "[" + u_email + "] ����ڰ� ����ī�信�� ����� ��� �Ͽ����ϴ�."; 
		}else {
			logMessage = "[Guest] ����ڰ� ����ī�信�� ����� ��� �Ͽ����ϴ�."; 
		}
		userMenuLogCommand.setUmenu_log_message(logMessage);
		pcafeService.insertUserLog(userMenuLogCommand);
		log.debug("[����ī�� �α�] userMenuLogCommand : " + userMenuLogCommand);
		
		map.put("result", "success");
		
		return map;
	}
}

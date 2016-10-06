package kr.cafein.admin.privatecafe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.domain.UserMenuLogCommand;

@Controller
public class PrivateDeleteReplyController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	@RequestMapping(value="/admin/private/privatecafe-reply.do",method=RequestMethod.GET)
	public String process(@RequestParam("preply_num") int preply_num, HttpSession session)
			throws Exception{
		
		System.out.println("==============");
		
		if(log.isDebugEnabled()){
			log.debug("preply_num : " + preply_num);
		}
		 
		int pcafe_num = privateService.selectPcafe_num(preply_num);
		
		if(log.isDebugEnabled()){
			log.debug("preply_num : " + preply_num + ", pcafe_num : " + pcafe_num);
		}
		
		privateService.deletePrivateReplyAdminp(preply_num);
		String u_uid = (String)session.getAttribute("u_uid");
		
		
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(4);
		userMenuLogCommand.setUmenu_log_state(2);
		String logMessage = "";
		if(!u_uid.equals("Guest")){
			String u_email = privateService.selectEmail(u_uid).getU_email();
			logMessage = "[" + u_email + "] 사용자가 프렌차이즈 카페에서 댓글을 삭제 하였습니다."; 
		}else {
			logMessage = "[Guest] 사용자가 개인카페에서 댓글을 삭제 하였습니다."; 
		}
		userMenuLogCommand.setUmenu_log_message(logMessage);
		privateService.insertAdminPrivateLog(userMenuLogCommand);
		log.debug("[커스터마이징 admin 로그] userMenuLogCommand : " + userMenuLogCommand);
	      
		
		return "redirect:/admin/privatecafe/privatecafe-reply.do?pcafe_num=" + pcafe_num;
		
	}
}

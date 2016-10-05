package kr.cafein.admin.customizingcafe.controller;

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
import kr.cafein.domain.UserMenuLogCommand;

@Controller
public class AdminCustomizingDeleteReplyController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	@RequestMapping(value="/admin/customizing/deleteReply.do",method=RequestMethod.GET)
	public String process(@RequestParam("creply_num") int creply_num, HttpSession session)
			throws Exception{
		
		System.out.println("==============");
		
		if(log.isDebugEnabled()){
			log.debug("creply_num : " + creply_num);
		}
		 
		int custom_num = admincustomizingService.selectCustom_num(creply_num);
		
		if(log.isDebugEnabled()){
			log.debug("creply_num : " + creply_num + ", custom_num : " + custom_num);
		}
		
		admincustomizingService.deleteCutomizingReplyAdmin(creply_num);
		String u_uid = (String)session.getAttribute("u_uid");
		
		
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(4);
		userMenuLogCommand.setUmenu_log_state(2);
		String logMessage = "";
		if(!u_uid.equals("Guest")){
			String u_email = admincustomizingService.selectEmail(u_uid).getU_email();
			logMessage = "[" + u_email + "] ����ڰ� ���������� ī�信�� ����� ���� �Ͽ����ϴ�."; 
		}else {
			logMessage = "[Guest] ����ڰ� ����ī�信�� ����� ���� �Ͽ����ϴ�."; 
		}
		userMenuLogCommand.setUmenu_log_message(logMessage);
		admincustomizingService.insertAdminCustomLog(userMenuLogCommand);
		log.debug("[Ŀ���͸���¡ admin �α�] userMenuLogCommand : " + userMenuLogCommand);
	      
		
		return "redirect:/admin/customizing/customizing-reply.do?custom_num=" + custom_num;
		
	}
}

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
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingLogCommand;
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
		
		
		AdminCustomizingLogCommand adminCustomizingLogCommand = new AdminCustomizingLogCommand();
		
		adminCustomizingLogCommand.setCustom_num(custom_num);
		adminCustomizingLogCommand.setU_uid(u_uid);
		adminCustomizingLogCommand.setC_log_change(2);
		adminCustomizingLogCommand.setC_log_message("["+u_uid+"] 사용자가 ["+custom_num+"]의 Customizing_reply 글을 삭제했습니다");
		
		admincustomizingService.insertLog(adminCustomizingLogCommand);
		
		
		return "redirect:/admin/customizing/customizing-reply.do?custom_num=" + custom_num;
		
	}
}

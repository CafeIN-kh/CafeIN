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
import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
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

		PrivateLogCommand privateLogCommand = new PrivateLogCommand();
		
		privateLogCommand.setPcafe_num(pcafe_num);
		privateLogCommand.setU_uid(u_uid);
		privateLogCommand.setP_log_change(1);
		privateLogCommand.setP_log_message("["+u_uid+"] 사용자가 ["+pcafe_num+"]의 Private Reply 글을 삭제했습니다");
		
		privateService.insertLog(privateLogCommand);
		
		return "redirect:/admin/privatecafe/privatecafe-reply.do?pcafe_num=" + pcafe_num;
		
	}
}

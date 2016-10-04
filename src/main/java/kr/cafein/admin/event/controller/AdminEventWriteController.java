package kr.cafein.admin.event.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.domain.AdminEventLogCommand;
import kr.cafein.admin.event.service.AdminEventService;
import kr.cafein.util.FileUtil_adminEvent;

@Controller
@SessionAttributes("eventCommand")
public class AdminEventWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminEventService adminEventService;
	
	@RequestMapping(value="/cafein_admin/event/write.do", method=RequestMethod.GET)
	public String form(Model model,HttpSession session){
		AdminEventCommand eventCommand = new AdminEventCommand();
		String u_uid = (String)session.getAttribute("u_uid");
		eventCommand.setEvent_uid(u_uid);
		model.addAttribute("eventCommand", eventCommand);
		
		return "eventWrite";
	}
	
	@RequestMapping(value="/cafein_admin/event/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("eventCommand") @Valid AdminEventCommand eventCommand, BindingResult result, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		
		String newName = "";
		
		if(!eventCommand.getUpload().isEmpty()){
			newName = FileUtil_adminEvent.rename(eventCommand.getUpload().getOriginalFilename());
			eventCommand.setEvent_img(newName);
		}
		
		adminEventService.insertEvent(eventCommand);
		
		if(!eventCommand.getUpload().isEmpty()){
			File file = new File(FileUtil_adminEvent.UPLOAD_PATH+"/"+newName);
			eventCommand.getUpload().transferTo(file);
		}
		
		//=======================log남기기==================================
		AdminEventLogCommand adminEventLogCommand = new AdminEventLogCommand();
		
		String u_uid = (String)session.getAttribute("u_uid");
		System.out.println("");
		adminEventLogCommand.setE_log_uid(u_uid);
		adminEventLogCommand.setE_log_change(0);
		adminEventLogCommand.setE_log_message("["+u_uid+"] 사용자가 Event 게시판에 "+eventCommand.getEvent_title()+"글 을 작성했습니다.");
		System.out.println("로그 : "+adminEventLogCommand);
		
		adminEventService.insertAdminEvent_Log(adminEventLogCommand);
		//===============================================================
		
		return "redirect:/cafein_admin/event/List.do";
	}

}

package kr.cafein.admin.event.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.event.domain.EventCommand;
import kr.cafein.admin.event.service.EventService;
import kr.cafein.util.FileUtil_adminEvent;

@Controller
@SessionAttributes("eventCommand")
public class EventWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping(value="/cafein_admin/event/write.do", method=RequestMethod.GET)
	public String form(Model model){
		EventCommand eventCommand = new EventCommand();
		model.addAttribute("eventCommand", eventCommand);
		
		return "eventWrite";
	}
	
	@RequestMapping(value="/cafein_admin/event/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("eventCommand") @Valid EventCommand eventCommand, BindingResult result)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		
		String newName = "";
		
		if(!eventCommand.getUpload().isEmpty()){
			newName = FileUtil_adminEvent.rename(eventCommand.getUpload().getOriginalFilename());
			eventCommand.setEvent_img(newName);
		}
		
		eventService.insertEvent(eventCommand);
		
		if(!eventCommand.getUpload().isEmpty()){
			File file = new File(FileUtil_adminEvent.UPLOAD_PATH+"/"+newName);
			eventCommand.getUpload().transferTo(file);
		}
		
		return "redirect:/cafein_admin/event/List.do";
	}

}

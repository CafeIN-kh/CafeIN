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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.service.AdminEventService;
import kr.cafein.util.FileUtil_adminEvent;

@Controller
@SessionAttributes("eventCommand")
public class AdminEventUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminEventService adminEventService;
	
	@RequestMapping(value="/cafein_admin/event/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("seq") int seq, Model model){
		System.out.println(seq);
		AdminEventCommand eventCommand = adminEventService.selectEvent(seq);
		System.out.println(eventCommand);
		model.addAttribute("eventCommand", eventCommand);
		
		return "eventModify";
	}
	
	@RequestMapping(value="/cafein_admin/event/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("eventCommand") @Valid AdminEventCommand eventCommand, BindingResult result )throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : "+eventCommand);
		}
		
		if(result.hasErrors()){
			return "eventModify"; 
		}
				
		AdminEventCommand event = null;
		String oldFileName = "";
		
		event = adminEventService.selectEvent(eventCommand.getEvent_num());
		
		oldFileName = event.getEvent_img();
		
		if(!eventCommand.getUpload().isEmpty()){
			//전송된 파일이 있는 경우
			eventCommand.setEvent_img(FileUtil_adminEvent.rename(eventCommand.getUpload().getOriginalFilename()));
		}else{
			//전송된 파일이 없는 경우
			eventCommand.setEvent_img(oldFileName);
		}
		
		adminEventService.updateEvent(eventCommand);
		
		if(!eventCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
			File file = new File(FileUtil_adminEvent.UPLOAD_PATH+"/"+eventCommand.getEvent_img());
			eventCommand.getUpload().transferTo(file);
			if(oldFileName != null){
				//이전 파일 삭제
				FileUtil_adminEvent.removeFile(oldFileName);
			}
		}
		
		return "redirect:/cafein_admin/event/List.do";
		
	}

}

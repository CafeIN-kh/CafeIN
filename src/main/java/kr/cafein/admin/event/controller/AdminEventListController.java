package kr.cafein.admin.event.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.service.AdminEventService;

@Controller
public class AdminEventListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminEventService")
	private AdminEventService adminEventService;
	
	@RequestMapping("/cafein_admin/event/List.do")
	public ModelAndView process(){
		List<AdminEventCommand> list = adminEventService.getEventList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("eventList");
		mav.addObject("list",list);
		return mav;
	}

}

package kr.cafein.admin.event.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.event.domain.EventCommand;
import kr.cafein.admin.event.service.EventService;

@Controller
public class EventListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="eventService")
	private EventService eventService;
	
	@RequestMapping("/cafein_admin/event/List.do")
	public ModelAndView process(){
		List<EventCommand> list = eventService.getEventList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("eventList");
		mav.addObject("list",list);
		return mav;
	}

}

package kr.cafein.admin.event.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.event.service.EventService;

@Controller
public class EventDeleteController {
	
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;

	@RequestMapping("/cafein_admin/event/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		eventService.deletEvente(seq);
		
		return "redirect:/cafein_admin/event/List.do";
		
	}
}

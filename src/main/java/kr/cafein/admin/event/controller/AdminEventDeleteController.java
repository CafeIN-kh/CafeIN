package kr.cafein.admin.event.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.event.service.AdminEventService;

@Controller
public class AdminEventDeleteController {
	
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminEventService adminEventService;

	@RequestMapping("/cafein_admin/event/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		adminEventService.deletEvente(seq);
		
		return "redirect:/cafein_admin/event/List.do";
		
	}
}

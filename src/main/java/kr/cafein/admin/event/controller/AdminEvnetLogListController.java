package kr.cafein.admin.event.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.event.domain.AdminEventLogCommand;
import kr.cafein.admin.event.service.AdminEventService;

@Controller
public class AdminEvnetLogListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminEventService")
	private AdminEventService adminEventService;
	
	@RequestMapping("/cafein_admin/event/AdminLogList.do")
	public ModelAndView process(){
		List<AdminEventLogCommand> list = adminEventService.getAdminEvent_LogList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("eventLogList");
		mav.addObject("list",list);
		return mav;
		
	}

}

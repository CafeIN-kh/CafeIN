package kr.cafein.admin.privatecafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateLogController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService privateService;
	
	@RequestMapping(value="/admin/privatecafe/private_log.do")
	public ModelAndView process(){
		
		List<PrivateLogCommand> list = privateService.selectLog();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		ModelAndView mav = new ModelAndView("admin_privateLog");
		mav.addObject("list",list);
		return mav;
	}
}

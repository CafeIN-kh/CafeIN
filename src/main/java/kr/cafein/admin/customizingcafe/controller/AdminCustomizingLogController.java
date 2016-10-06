package kr.cafein.admin.customizingcafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingLogCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;

@Controller
public class AdminCustomizingLogController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminCustomizingService adminCustomizingService;
	
	@RequestMapping(value="/admin/customizing/customizing_log.do")
	public ModelAndView process(){
		
		List<AdminCustomizingLogCommand> list = adminCustomizingService.selectLog();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("admin_customizingLog");
		mav.addObject("list",list);
		return mav;
	}
	
}

package kr.cafein.admin.privatecafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	
	@RequestMapping("/admin/privatecafe/privatecafe.do")
	public ModelAndView process(){
		
		System.out.println("==============");
		
		List<PrivateCommand> list = privateService.getPrivateList();
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		ModelAndView mav = new ModelAndView("adminPrivateCafe");
		mav.addObject("list", list);
		
		System.out.println(list);
		return mav;

		
	}

}

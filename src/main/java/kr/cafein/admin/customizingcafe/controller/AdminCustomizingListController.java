package kr.cafein.admin.customizingcafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class AdminCustomizingListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	
	@RequestMapping("/admin/customizing/customizing.do")
	public ModelAndView process(){
		
		System.out.println("==============");
		
		List<PrivateCommand> list = admincustomizingService.getPrivateList();
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		ModelAndView mav = new ModelAndView("adminCustomizing");
		mav.addObject("list", list);
		
		System.out.println(list);
		return mav;

		
	}

}

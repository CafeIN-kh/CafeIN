package kr.cafein.admin.customizingcafe.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class AdminCustomizingDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminCustomizingService admincustomizingService;
	
	@RequestMapping("/admin/customizing/customizing-delete.do")
	public String submit(@RequestParam("custom_num") int custom_num)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("custom_num : "+custom_num);
		}
		
	/*	PrivateCommand privatecommand = privateService.selectBoard(pcafe_num);
		*/
		
		admincustomizingService.delete(custom_num);
		
		return "redirect:/admin/customizing/customizing.do";
		
	}

}

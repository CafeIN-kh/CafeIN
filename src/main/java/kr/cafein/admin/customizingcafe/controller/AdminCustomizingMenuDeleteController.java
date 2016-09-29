package kr.cafein.admin.customizingcafe.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;


@Controller
public class AdminCustomizingMenuDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminCustomizingService admincustomizingService;
	
	@RequestMapping("/admin/customizing/customizingmenu-delete.do")
	public String submit(@RequestParam("custom_num") int custom_num, @ModelAttribute AdminCustomizingCommand adminCustomizingCommand)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("custom_num : " + custom_num);
			log.debug("privateCafeMenuCommand : " +  adminCustomizingCommand);
		}
		
		admincustomizingService.delete(custom_num);
		
		
		
		
		
		return "redirect:/admin/customizing/customizingmenu.do?custom_num="+adminCustomizingCommand.getCustom_num();
	}
}

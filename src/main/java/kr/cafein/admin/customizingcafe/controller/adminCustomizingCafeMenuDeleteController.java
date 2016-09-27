package kr.cafein.admin.customizingcafe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class adminCustomizingCafeMenuDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService adminprivateService;
	
	@RequestMapping("/admin/privatecafe/privatecafemenu-delete.do")
	public String submit(@RequestParam("pmenu_num") int pmenu_num, @ModelAttribute PrivateMenuCommand privateCafeMenuCommand)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pmenu_num : " + pmenu_num);
			log.debug("privateCafeMenuCommand : " +  privateCafeMenuCommand);
		}
		
		adminprivateService.deletemenu(pmenu_num);
		
		
		
		
		
		return "redirect:/admin/privatecafe/privatecafemenu.do?pcafe_num="+privateCafeMenuCommand.getPcafe_num();
	}
}

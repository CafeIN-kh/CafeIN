package kr.cafein.admin.customizingcafe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingLogCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;


@Controller
public class AdminCustomizingMenuDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminCustomizingService admincustomizingService;
	
	@RequestMapping("/admin/customizing/customizingmenu-delete.do")
	public String submit(@RequestParam("custom_num") int custom_num, @ModelAttribute AdminCustomizingCommand adminCustomizingCommand,HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("custom_num : " + custom_num);
			log.debug("privateCafeMenuCommand : " +  adminCustomizingCommand);
		}
		
		admincustomizingService.delete(custom_num);
		
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		
		AdminCustomizingLogCommand adminCustomizingLogCommand = new AdminCustomizingLogCommand();
		
		adminCustomizingLogCommand.setCustom_num(custom_num);
		adminCustomizingLogCommand.setU_uid(u_uid);
		adminCustomizingLogCommand.setC_log_change(2);
		adminCustomizingLogCommand.setC_log_message("["+u_uid+"] ����ڰ� ["+custom_num+"]�� Customizing ���� �����߽��ϴ�");
		
		admincustomizingService.insertLog(adminCustomizingLogCommand);
		
		
		
		return "redirect:/admin/customizing/customizingmenu.do?custom_num="+adminCustomizingCommand.getCustom_num();
	}
}

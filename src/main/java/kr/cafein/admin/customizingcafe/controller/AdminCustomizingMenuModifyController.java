package kr.cafein.admin.customizingcafe.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;

import kr.cafein.util.FileUtil_Customizing;

@Controller
@SessionAttributes("customcommand")
public class AdminCustomizingMenuModifyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	@RequestMapping(value="/admin/customizing/customizingmenu-modify.do",method=RequestMethod.GET)
	public String form(@RequestParam("custom_num") int custom_num, Model model){
		
		System.out.println(custom_num);
		
		AdminCustomizingCommand adminCustomizingCommand = admincustomizingService.getCustomizing(custom_num);
		System.out.println(adminCustomizingCommand);
		model.addAttribute("customcommand",adminCustomizingCommand);
		
		return "adminCustomizingMenuModify";
	}
	

	@RequestMapping(value="/admin/customizing/customizingmenu-modify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("customcommand")@Valid AdminCustomizingCommand adminCustomizingCommand, BindingResult result, SessionStatus status,HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("adminCustomizingCommand : "  + adminCustomizingCommand);
		}
		
		System.out.println("error미진입");
		if(result.hasErrors()){
			System.out.println("error진입");
			return "adminCustomizingMenuModify";
		}
		
		
		AdminCustomizingCommand customMenu = null;
		String oldFileName = "";
		
		customMenu = admincustomizingService.getCustomizing(adminCustomizingCommand.getCustom_num());
		
		
		
		oldFileName = customMenu.getCustom_img();
		
		if(!adminCustomizingCommand.getUpload().isEmpty()){
			adminCustomizingCommand.setCustom_img(FileUtil_Customizing.rename(adminCustomizingCommand.getUpload().getOriginalFilename()));
		}else{
			adminCustomizingCommand.setCustom_img(oldFileName);
		}
		
		//글수정
		admincustomizingService.update(adminCustomizingCommand);
		status.setComplete();
		
		if(!adminCustomizingCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
			File file = new File(FileUtil_Customizing.UPLOAD_PATH+"/"+adminCustomizingCommand.getCustom_img());
			adminCustomizingCommand.getUpload().transferTo(file);
		
			if(oldFileName!=null){
				//이전 파일 삭제
				FileUtil_Customizing.removeFile(oldFileName);
			}
		
		}
		return "redirect:/admin/customizing/customizingmenu.do?custom_num="+adminCustomizingCommand.getCustom_num();
	}
	
}
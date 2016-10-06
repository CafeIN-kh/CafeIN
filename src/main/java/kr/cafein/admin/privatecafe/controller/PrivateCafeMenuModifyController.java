package kr.cafein.admin.privatecafe.controller;

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

import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.util.FileUtil_PrivateMenu;

@Controller
@SessionAttributes("command")
public class PrivateCafeMenuModifyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	@RequestMapping(value="/admin/privatecafe/privatecafemenu-modify.do",method=RequestMethod.GET)
	public String form(@RequestParam("pmenu_num") int pmenu_num, Model model){
		
		System.out.println(pmenu_num);
		
		PrivateMenuCommand privateCafeMenuCommand = privateService.selectMenu(pmenu_num);
		System.out.println(privateCafeMenuCommand);
		model.addAttribute("command",privateCafeMenuCommand);
		
		return "adminPrivateCafeMenuModify";
	}
	

	@RequestMapping(value="/admin/privatecafe/privatecafemenu-modify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid PrivateMenuCommand privateCafeMenuCommand, BindingResult result, SessionStatus status,HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("privateCafeMenuCommand : "  + privateCafeMenuCommand);
		}
		
		System.out.println("error미진입");
		if(result.hasErrors()){
			System.out.println("error진입");
			return "adminPrivateCafeMenuModify";
		}
		
		
		PrivateMenuCommand privateCafeMenu = null;
		String oldFileName = "";
		
		privateCafeMenu = privateService.selectMenu(privateCafeMenuCommand.getPmenu_num());
		
		System.out.println(privateCafeMenuCommand.getPmenu_num());
		
		oldFileName = privateCafeMenu.getPmenu_img();
		
		if(!privateCafeMenuCommand.getUpload().isEmpty()){
			privateCafeMenuCommand.setPmenu_img(FileUtil_PrivateMenu.rename(privateCafeMenuCommand.getUpload().getOriginalFilename()));
		}else{
			privateCafeMenuCommand.setPmenu_img(oldFileName);
		}
		
		//글수정
		privateService.update2(privateCafeMenuCommand);
		
		String u_uid = (String)session.getAttribute("u_uid");
		int pcafenum = privateCafeMenuCommand.getPmenu_num();
		
		PrivateLogCommand privateLogCommand = new PrivateLogCommand();
		
		privateLogCommand.setPcafe_num(pcafenum);
		privateLogCommand.setU_uid(u_uid);
		privateLogCommand.setP_log_change(2);
		privateLogCommand.setP_log_message("["+u_uid+"] 사용자가 ["+pcafenum+"]의 Private Cafe Menu 글을 수정했습니다");
		
		privateService.insertLog(privateLogCommand);
		
		if(!privateCafeMenuCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
			File file = new File(FileUtil_PrivateMenu.UPLOAD_PATH+"/"+privateCafeMenuCommand.getPmenu_img());
			privateCafeMenuCommand.getUpload().transferTo(file);
		
			if(oldFileName!=null){
				//이전 파일 삭제
				FileUtil_PrivateMenu.removeFile(oldFileName);
			}
		
		}
		return "redirect:/admin/privatecafe/privatecafemenu.do?pcafe_num="+privateCafeMenuCommand.getPcafe_num();
	}
	
}
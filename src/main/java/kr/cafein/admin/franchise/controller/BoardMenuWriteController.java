package kr.cafein.admin.franchise.controller;

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

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.FileUtil_adminFranchisemenu;


@Controller
@SessionAttributes("command")
public class BoardMenuWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@ModelAttribute("command")
	public AdminFranchiseMenuCommand initCommand(){
		return new AdminFranchiseMenuCommand();
	}

	
	@RequestMapping(value="/cafein_admin/franchise/franchise_menuWrite.do",method=RequestMethod.GET)
	public String form(@RequestParam("franchise_num") int franchise_num, HttpSession session, Model model){
		/*String id = (String)session.getAttribute("userId");*/

		AdminFranchiseMenuCommand command = new AdminFranchiseMenuCommand();
		/*command.setFranchise_name(franchise_name);*/

		String name = adminFranchiseService.getFranchise_name(franchise_num);
		int number = adminFranchiseService.getFranchise_num(franchise_num);
		model.addAttribute("name",name);
		model.addAttribute("number",number);
		
		return "franchise_menuWrite";
	}
	@RequestMapping(value="/cafein_admin/franchise/franchise_menuWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid AdminFranchiseMenuCommand franchiseMenuCommand, AdminFranchiseCommand franchiseCommand, BindingResult result, SessionStatus status) throws Exception{
		
		
		if(log.isDebugEnabled()){
			log.debug("franchiseMenuCommand : " + franchiseMenuCommand);
		}
		
		
		String newName = "";
		if(!franchiseMenuCommand.getUpload().isEmpty()){
			newName = FileUtil_adminFranchisemenu.rename(franchiseMenuCommand.getUpload().getOriginalFilename());
	
			franchiseMenuCommand.setFmenu_img(franchiseMenuCommand.getFmenu_name() + newName);
			
			String cr = franchiseCommand.getFranchise_name();
			FileUtil_adminFranchisemenu.makeFile(cr);
			
		}
		
		//글쓰기
		adminFranchiseService.insertMenu(franchiseMenuCommand);
		
		    
		//파일을 업로드 폴더에 저장
		if(!franchiseMenuCommand.getUpload().isEmpty()){
			File file = new File(FileUtil_adminFranchisemenu.UPLOAD_PATH+"/"+ franchiseMenuCommand.getFmenu_img());
			franchiseMenuCommand.getUpload().transferTo(file);
		}
			
			String mv = franchiseCommand.getFranchise_name();
			String mv2 = franchiseMenuCommand.getFmenu_name();
			
			FileUtil_adminFranchisemenu.moveFile(mv2,mv);
			
				return "redirect:/cafein_admin/franchise/franchise_menuList.do?franchise_num=" +franchiseCommand.getFranchise_num();
	}
}








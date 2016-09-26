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

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.FileUtil_adminFranchisemenu;

@Controller
@SessionAttributes("noticeCommand")
public class BoardMenuUpdateController {
	
	@ModelAttribute("command")
	public AdminFranchiseMenuCommand initCommand(){
		return new AdminFranchiseMenuCommand();
	}
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_menuUpdate.do", method=RequestMethod.GET)
	public String form(@RequestParam("franchise_num") int franchise_num, @RequestParam("fmenu_num") int fmenu_num,@RequestParam("franchise_name") String franchise_name,Model model, HttpSession session){
		AdminFranchiseCommand adminFranchiseCommand = adminFranchiseService.selectFranchise(franchise_num);
		String u_uid = (String)session.getAttribute("u_uid");

		model.addAttribute("adminFranchiseCommand", adminFranchiseCommand);
		model.addAttribute("franchise_num",franchise_num);
		model.addAttribute("fmenu_num",fmenu_num);
		model.addAttribute("franchise_name",franchise_name);
		
		
		

		return "franchise_menuUpdate";
	}
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_menuUpdate.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("adminFranchiseMenuCommand") @Valid AdminFranchiseMenuCommand franchiseMenuCommand, BindingResult result, @ModelAttribute("adminFranchiseCommand") @Valid AdminFranchiseCommand franchiseCommand, HttpSession session)throws Exception{

		if(log.isDebugEnabled()){
			log.debug("adminFranchiseCommand : "+franchiseMenuCommand);
		}
		
		AdminFranchiseLogCommand adminFranchiseLogCommand = new AdminFranchiseLogCommand(); 
		
		String u_uid = (String)session.getAttribute("u_uid");
		int franchise_num_log = franchiseCommand.getFranchise_num();

		adminFranchiseLogCommand.setFranchise_num_log(franchise_num_log);
		adminFranchiseLogCommand.setFranchise_admin_log(u_uid);
		adminFranchiseLogCommand.setFranchise_change_log(2);
		adminFranchiseLogCommand.setFranchise_message_log(u_uid + "가 " + franchiseMenuCommand.getFmenu_name() + " 메뉴를 수정하였습니다.");
		adminFranchiseLogCommand.setU_uid(u_uid);
		
		adminFranchiseService.f_log_insert(adminFranchiseLogCommand);
		

		if(result.hasErrors()){
			return "franchise_menuUpdate"; 
		}
		AdminFranchiseMenuCommand franchiseMenu = null;
		String oldFileName = "";
		
		franchiseMenu = adminFranchiseService.selectFmenu(franchiseMenuCommand.getFmenu_num());
		
		oldFileName = franchiseMenu.getFmenu_img();
		
		
		String newName = "";
		if(!franchiseMenuCommand.getUpload().isEmpty()){
			//전송된 파일이 있는 경우
			newName = FileUtil_adminFranchisemenu.rename(franchiseMenuCommand.getUpload().getOriginalFilename());
			franchiseMenuCommand.setFmenu_img(franchiseMenuCommand.getFmenu_name() + newName);
			String cr = franchiseCommand.getFranchise_name();
			FileUtil_adminFranchisemenu.makeFile(cr);
			/*franchiseCommand.setFranchise_img(FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename()));*/
		}else{
			//전송된 파일이 없는 경우
			franchiseMenuCommand.setFmenu_img(oldFileName);
		}
		
		adminFranchiseService.updateFranchiseMenu(franchiseMenuCommand);
		
		if(!franchiseMenuCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
	
			File file = new File(FileUtil_adminFranchisemenu.UPLOAD_PATH+"/"+franchiseMenuCommand.getFmenu_img());
			franchiseMenuCommand.getUpload().transferTo(file);
			
			if(oldFileName != null){
				//이전 파일 삭제
				FileUtil_adminFranchisemenu.removeFile(oldFileName);
			}
		}
		
		String mv = franchiseCommand.getFranchise_name();
		String mv2 = franchiseMenuCommand.getFmenu_name();
	
		
		
		FileUtil_adminFranchisemenu.moveFile(mv2,mv);
		
		
		return "redirect:/cafein_admin/franchise/franchise_menuList.do?franchise_num=" + franchiseCommand.getFranchise_num();
		
	}
	

}

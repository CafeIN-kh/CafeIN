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
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.FileUtil;

@Controller
@SessionAttributes("noticeCommand")
public class BoardUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_brandUpdate.do", method=RequestMethod.GET)
	public String form(@RequestParam("franchise_num") int franchise_num, Model model, HttpSession session){
		AdminFranchiseCommand adminFranchiseCommand = adminFranchiseService.selectFranchise(franchise_num);
		String u_uid = (String)session.getAttribute("u_uid");

		model.addAttribute("adminFranchiseCommand", adminFranchiseCommand);
		
		return "franchise_brandUpdate";
	}
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("adminFranchiseCommand") @Valid AdminFranchiseCommand franchiseCommand, BindingResult result, HttpSession session)throws Exception{

		if(log.isDebugEnabled()){
			log.debug("adminFranchiseCommand : "+franchiseCommand);
		}
		
		if(result.hasErrors()){
			return "franchise_brandUpdate"; 
		}
		
		AdminFranchiseLogCommand adminFranchiseLogCommand = new AdminFranchiseLogCommand(); 
		
		String u_uid = (String)session.getAttribute("u_uid");
		int franchise_num_log = franchiseCommand.getFranchise_num();

		adminFranchiseLogCommand.setFranchise_num_log(franchise_num_log);
		adminFranchiseLogCommand.setFranchise_admin_log(u_uid);
		adminFranchiseLogCommand.setFranchise_change_log(2);
		adminFranchiseLogCommand.setFranchise_message_log(u_uid + "가 " + franchiseCommand.getFranchise_name() + " 브랜드를 수정하였습니다.");
		adminFranchiseLogCommand.setU_uid(u_uid);
		
		adminFranchiseService.f_log_insert(adminFranchiseLogCommand);
		
		
		AdminFranchiseCommand franchise = null;
		String oldFileName = "";
		
		franchise = adminFranchiseService.selectFranchise(franchiseCommand.getFranchise_num());
		
		oldFileName = franchise.getFranchise_img();
		
		
		String newName = "";
		if(!franchiseCommand.getUpload().isEmpty()){
			//전송된 파일이 있는 경우
			newName = FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename());
			System.out.println("newname : " + newName);
			franchiseCommand.setFranchise_img(franchiseCommand.getFranchise_name() + newName);
			String cr = franchiseCommand.getFranchise_name();
			FileUtil.makeFile(cr);
			/*franchiseCommand.setFranchise_img(FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename()));*/
		}else{
			//전송된 파일이 없는 경우
			franchiseCommand.setFranchise_img(oldFileName);
		}
		
		adminFranchiseService.updateFranchise(franchiseCommand);
		
		if(!franchiseCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
	
			File file = new File(FileUtil.UPLOAD_PATH+"/"+franchiseCommand.getFranchise_img());
			franchiseCommand.getUpload().transferTo(file);
			

			if(oldFileName != null){
				//이전 파일 삭제
				FileUtil.removeFile(oldFileName);
			}
		}
		String mv = franchiseCommand.getFranchise_name();
		FileUtil.moveFile(mv);
		return "redirect:/cafein_admin/franchise/franchise_brandDetail.do?franchise_num=" + franchiseCommand.getFranchise_num();
		
	}
	

}

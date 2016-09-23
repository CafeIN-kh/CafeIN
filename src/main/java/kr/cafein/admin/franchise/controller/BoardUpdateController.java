package kr.cafein.admin.franchise.controller;

import java.io.File;

import javax.annotation.Resource;
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
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.FileUtil;

@Controller
@SessionAttributes("noticeCommand")
public class BoardUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_brandUpdate.do", method=RequestMethod.GET)
	public String form(@RequestParam("franchise_num") int franchise_num, Model model){
		AdminFranchiseCommand adminFranchiseCommand = adminFranchiseService.selectFranchise(franchise_num);
		
		model.addAttribute("adminFranchiseCommand", adminFranchiseCommand);
		
		return "franchise_brandUpdate";
	}
	
	@RequestMapping(value="/cafein_admin/franchise/franchise_update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("adminFranchiseCommand") @Valid AdminFranchiseCommand franchiseCommand, BindingResult result)throws Exception{

		if(log.isDebugEnabled()){
			log.debug("adminFranchiseCommand : "+franchiseCommand);
		}
		
		if(result.hasErrors()){
			return "franchise_brandUpdate"; 
		}
		AdminFranchiseCommand franchise = null;
		String oldFileName = "";
		
		franchise = adminFranchiseService.selectFranchise(franchiseCommand.getFranchise_num());
		
		oldFileName = franchise.getFranchise_img();
		
		
		String newName = "";
		if(!franchiseCommand.getUpload().isEmpty()){
			//���۵� ������ �ִ� ���
			newName = FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename());
			System.out.println("newname : " + newName);
			franchiseCommand.setFranchise_img(franchiseCommand.getFranchise_name() + newName);
			String cr = franchiseCommand.getFranchise_name();
			FileUtil.makeFile(cr);
			/*franchiseCommand.setFranchise_img(FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename()));*/
		}else{
			//���۵� ������ ���� ���
			franchiseCommand.setFranchise_img(oldFileName);
		}
		
		adminFranchiseService.updateFranchise(franchiseCommand);
		
		if(!franchiseCommand.getUpload().isEmpty()){
			//���۵� ������ ���� ���
	
			File file = new File(FileUtil.UPLOAD_PATH+"/"+franchiseCommand.getFranchise_img());
			franchiseCommand.getUpload().transferTo(file);
			

			if(oldFileName != null){
				//���� ���� ����
				FileUtil.removeFile(oldFileName);
			}
		}
		String mv = franchiseCommand.getFranchise_name();
		FileUtil.moveFile(mv);
		return "redirect:/cafein_admin/franchise/franchise_brandDetail.do?franchise_num=" + franchiseCommand.getFranchise_num();
		
	}
	

}

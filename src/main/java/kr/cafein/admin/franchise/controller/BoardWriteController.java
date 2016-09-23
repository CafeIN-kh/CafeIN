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
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.FileUtil;


@Controller
public class BoardWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@ModelAttribute("command")
	public AdminFranchiseCommand initCommand(){
		return new AdminFranchiseCommand();
	}

	
	@RequestMapping(value="/cafein_admin/franchise/franchise_brandWrite.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		/*String id = (String)session.getAttribute("userId");*/

		AdminFranchiseCommand command = new AdminFranchiseCommand();
		
		
		System.out.println("command : " + command);
		
		/*command.setFranchise_name(franchise_name);*/

		
		return "franchise_brandWrite";
	}
	@RequestMapping(value="/cafein_admin/franchise/franchise_brandWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid AdminFranchiseCommand franchiseCommand, BindingResult result, Model model) throws Exception{
		
		System.out.println("넘버1 : " +franchiseCommand.getFranchise_num());
		if(log.isDebugEnabled()){
			log.debug("franchiseCommand : " + franchiseCommand);
		}
		
		String newName = "";
		if(!franchiseCommand.getUpload().isEmpty()){
			newName = FileUtil.rename(franchiseCommand.getUpload().getOriginalFilename());
	
			franchiseCommand.setFranchise_img(franchiseCommand.getFranchise_name() + newName);
			
			String cr = franchiseCommand.getFranchise_name();
			FileUtil.makeFile(cr);
			
		}
		
		
		//글쓰기
		adminFranchiseService.insert(franchiseCommand);
		
		System.out.println("넘버2 : " +franchiseCommand.getFranchise_num());
		//파일을 업로드 폴더에 저장
		if(!franchiseCommand.getUpload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+ franchiseCommand.getFranchise_img());
			franchiseCommand.getUpload().transferTo(file);
		}
			
			String mv = franchiseCommand.getFranchise_name();
			FileUtil.moveFile(mv);
			
			System.out.println("넘버3 : " +franchiseCommand.getFranchise_num());
		
			return "redirect:/cafein_admin/franchise/franchise_brandList.do";
							
	}
}








package kr.cafein.admin.franchise.controller;

import java.io.File;
import java.sql.Date;

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
import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
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
		System.out.println("session12 : " + session);
		
		String u_uid = (String)session.getAttribute("u_uid");

		AdminFranchiseCommand command = new AdminFranchiseCommand();
				
		/*command.setFranchise_name(franchise_name);*/
		System.out.println("ggcommand : " + command);
		
		return "franchise_brandWrite";
	}
	@RequestMapping(value="/cafein_admin/franchise/franchise_brandWrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid AdminFranchiseCommand franchiseCommand, BindingResult result, Model model,HttpSession session) throws Exception{
		
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
		
		AdminFranchiseLogCommand adminFranchiseLogCommand = new AdminFranchiseLogCommand(); 
		
		String u_uid = (String)session.getAttribute("u_uid");
		int franchise_num_log = franchiseCommand.getFranchise_num();

		adminFranchiseLogCommand.setFranchise_num_log(franchise_num_log);
		adminFranchiseLogCommand.setFranchise_admin_log(u_uid);
		adminFranchiseLogCommand.setFranchise_change_log(0);
		adminFranchiseLogCommand.setFranchise_message_log(u_uid + "가 " + franchiseCommand.getFranchise_name() + " 브랜드를 추가하였습니다.");
		adminFranchiseLogCommand.setU_uid(u_uid);
		
		adminFranchiseService.f_log_insert(adminFranchiseLogCommand);
		
		//파일을 업로드 폴더에 저장
		if(!franchiseCommand.getUpload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+ franchiseCommand.getFranchise_img());
			franchiseCommand.getUpload().transferTo(file);
		}
			
			String mv = franchiseCommand.getFranchise_name();
			FileUtil.moveFile(mv);
			
		
			return "redirect:/cafein_admin/franchise/franchise_brandList.do";
							
	}
}








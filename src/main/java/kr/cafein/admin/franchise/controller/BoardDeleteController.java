package kr.cafein.admin.franchise.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;

@Controller
public class BoardDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping("/cafein_admin/franchise/franchise_brandDelete.do")
	public String submit(@RequestParam("franchise_num") int franchise_num, @RequestParam("franchise_name") String franchise_name, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("franchise_num : "+franchise_num);
		}
		
		adminFranchiseService.delete(franchise_num);

		AdminFranchiseLogCommand adminFranchiseLogCommand = new AdminFranchiseLogCommand(); 
		
		String u_uid = (String)session.getAttribute("u_uid");
		int franchise_num_log = franchise_num;

		adminFranchiseLogCommand.setFranchise_num_log(franchise_num_log);
		adminFranchiseLogCommand.setFranchise_admin_log(u_uid);
		adminFranchiseLogCommand.setFranchise_change_log(1);
		adminFranchiseLogCommand.setFranchise_message_log(u_uid + "가 " + franchise_name + " 브랜드를 삭제하였습니다.");
		adminFranchiseLogCommand.setU_uid(u_uid);
		
		
		adminFranchiseService.f_log_insert(adminFranchiseLogCommand);
		
		return "redirect:/cafein_admin/franchise/franchise_brandList.do";
		
	}

}

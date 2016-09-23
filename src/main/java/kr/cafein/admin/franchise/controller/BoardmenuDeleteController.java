package kr.cafein.admin.franchise.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.franchise.service.AdminFranchiseService;

@Controller
public class BoardmenuDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping("/cafein_admin/franchise/franchise_menuDelete.do")
	public String submit(@RequestParam("fmenu_num") int fmenu_num)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("fmenu_num : "+fmenu_num);
		}
		
		adminFranchiseService.deletemenu(fmenu_num);
		
		return "redirect:/cafein_admin/franchise/franchise_menuList.do";
		
	}
}

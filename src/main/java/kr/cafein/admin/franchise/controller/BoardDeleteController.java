package kr.cafein.admin.franchise.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.franchise.service.AdminFranchiseService;

@Controller
public class BoardDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	@RequestMapping("/cafein_admin/franchise/franchise_brandDelete.do")
	public String submit(@RequestParam("franchise_num") int franchise_num)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("franchise_num : "+franchise_num);
		}
		
		adminFranchiseService.delete(franchise_num);
		
		return "redirect:/cafein_admin/franchise/franchise_brandList.do";
		
	}

}

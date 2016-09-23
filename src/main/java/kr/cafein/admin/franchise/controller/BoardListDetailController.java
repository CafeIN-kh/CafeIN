package kr.cafein.admin.franchise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;


@Controller
public class BoardListDetailController {

	
		private Logger log = Logger.getLogger(this.getClass());
	
			@Resource
			private AdminFranchiseService adminFranchiseService;
			
			@RequestMapping("/cafein_admin/franchise/franchise_brandDetail.do")
			public ModelAndView process(@RequestParam(value="franchise_num",defaultValue="") int franchise_num){
		
				List<AdminFranchiseCommand> listDetail = adminFranchiseService.listDetail(franchise_num);
				
				AdminFranchiseCommand franchise = adminFranchiseService.selectFranchiseDetail(franchise_num);
				

				

				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("franchise_brandDetail");
				mav.addObject("listDetail", listDetail);
				mav.addObject("franchise",franchise);
			/*	mav.addObject("franchise_img",franchise_img);*/
				
				log.debug("/cafein_user/franchise/franchise_main.do");
		

				return mav;  
			}
				
		
	}


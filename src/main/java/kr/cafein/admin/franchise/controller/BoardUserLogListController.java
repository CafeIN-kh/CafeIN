package kr.cafein.admin.franchise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.domain.UserMenuLogCommand;

@Controller
public class BoardUserLogListController {
	
	 private Logger log = Logger.getLogger(this.getClass());
	   
     @Resource
     private AdminFranchiseService adminFranchiseService;
     
     @RequestMapping("/cafein_admin/franchise/franchise_brandUserLogList.do")
     public ModelAndView process(){
    
    	 List<UserMenuLogCommand> list = adminFranchiseService.getUserFranchiseLog();
    	 
    	 System.out.println("========¸®½ºÆ®=========== : "+list);
    	          
         ModelAndView mav = new ModelAndView();
         mav.setViewName("franchise_UserlogList");
         mav.addObject("list", list);
         
         log.debug("/cafein_user/franchise/franchise_main.do");
   

         return mav;  
    	     	 
     }

}

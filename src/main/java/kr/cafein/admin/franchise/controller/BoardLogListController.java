package kr.cafein.admin.franchise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;


@Controller
public class BoardLogListController {

   
      private Logger log = Logger.getLogger(this.getClass());
   
         @Resource
         private AdminFranchiseService adminFranchiseService;
         
         @RequestMapping("/cafein_admin/franchise/franchise_brandLogList.do")
         public ModelAndView process(){
      
            
            List<AdminFranchiseLogCommand> logList = adminFranchiseService.logList();
            
            ModelAndView mav = new ModelAndView();
            mav.setViewName("franchise_logList");
            mav.addObject("logList", logList);
            
            log.debug("/cafein_user/franchise/franchise_main.do");
      

            return mav;  
         }
            
      
   }

package kr.cafein.admin.qna.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.qna.service.AdminQnaService;
import kr.cafein.domain.UserMenuLogCommand;

@Controller
public class AdminQnaUserLogListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminQnaService")
	private AdminQnaService adminQnaService;
	
	 @RequestMapping("/cafein_admin/qna/UserLogList.do")
     public ModelAndView process(){
    
    	 List<UserMenuLogCommand> list = adminQnaService.getUserQna_LogList();
    	 
    	 System.out.println("========¸®½ºÆ®=========== : "+list);
    	          
         ModelAndView mav = new ModelAndView();
         mav.setViewName("qnaUserLogList");
         mav.addObject("list", list);
         
         log.debug("/cafein_user/qna/List.do");
   

         return mav;  
    	     	 
     }

}

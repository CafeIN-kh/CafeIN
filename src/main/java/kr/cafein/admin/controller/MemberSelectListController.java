package kr.cafein.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

@Controller
public class MemberSelectListController {
   //로그처리
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="memberService")
   private MemberService memberService;
   
   
   @RequestMapping("/cafein_admin/member/memberlist.do") 
   public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
                                    int currentPage){
	   
	   
      if(log.isDebugEnabled()){
         log.debug("pageNum : " + currentPage);
      }
      
      int count = memberService.getMemberCount(); // 회원의 총 수를 구함
      
      List<MemberCommand> list = null;
      if(count>0){
    	  
    	
    	  Map<String,Object> map = new HashMap<String,Object>();
    	
    	  
    	  list = memberService.getAllMemberList();
      }else{
    	  list = Collections.emptyList();
      }
      
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("memberManagement");
      mav.addObject("count", count);
      mav.addObject("list", list);
     
     
      return mav;
   }
   
}
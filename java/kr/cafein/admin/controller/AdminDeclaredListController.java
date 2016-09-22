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

import kr.cafein.admin.domain.DeclaredCommand;
import kr.cafein.admin.service.DeclaredService;

@Controller
public class AdminDeclaredListController {
	 //로그처리
	   private Logger log = Logger.getLogger(this.getClass());
	   
	   // 로그테이블 mapper,service 만들기
	   @Resource(name="declaredService")
	   private DeclaredService declaredService;
	   
	   @RequestMapping("/admin/declaredlist.do") 
	   public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
	                                    int currentPage){
		   
		      if(log.isDebugEnabled()){
		         log.debug("pageNum : " + currentPage);
		      }
		      
		      int count = declaredService.getDeclaredCount(); // 회원의 총 수를 구함
		      
		     // PagingUtil page = new PagingUtil(currentPage,count,20,20,"memberlist.do");
		      
		      List<DeclaredCommand> list = null;
		      if(count>0){
		    	  
		    	 /* Map, ModelMap

		    	  뷰에 전달할 객체 정보를 담고 있는 Map 혹은 ModelMap을 리턴한다. 이때 뷰 이름은 요청 URL로부터 결정된다. 
		    	  */
		    	  
		    	  Map<String,Object> map = new HashMap<String,Object>();
		    	
		    	  
		    	  list = declaredService.getAllDeclaredList();
		      }else{
		    	  list = Collections.emptyList();
		      }
		      
		      
		      ModelAndView mav = new ModelAndView();
		      mav.setViewName("declared");
		      mav.addObject("count", count);
		      mav.addObject("list", list);
		     
		     
		      return mav;
		   
		   
	   }
}

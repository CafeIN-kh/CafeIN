package kr.cafein.admin.customizingcafe.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.util.PagingUtil_adminPrivate;

@Controller
public class AdminCustomizingMenuListController {
   
   private int rowCount = 8;
   private int pageCount = 10;   
   
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="admincustomizingService")
   private AdminCustomizingService admincustomizingService;
   
   
   @RequestMapping("/admin/customizing/customizingmenu.do")
   public ModelAndView process(@RequestParam(value="pcafe_num",defaultValue="") int pcafe_num,
                        @RequestParam(value="pageNum",defaultValue="1") int currentPage,
                        @RequestParam(value="keyword",defaultValue="") String keyword)throws Exception{
      
   
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("keyword", keyword);
      
      
      //�� ���� ���� �Ǵ� �˻��� ���� ����
      int count = admincustomizingService.getRowCount(pcafe_num);
      
      PagingUtil_adminPrivate page = new PagingUtil_adminPrivate(keyword,currentPage,count,rowCount,pageCount,pcafe_num,"privatecafemenu.do");
      
      map.put("start", page.getStartCount());
      map.put("end", page.getEndCount());
      map.put("pcafe_num", pcafe_num);
      
      System.out.println("==============");
      
      
      PrivateCommand privatecafe = admincustomizingService.selectBoard(pcafe_num);
      
     
      
      /*List<PrivateMenuCommand> menuList = privateService.menuList(map);*/
      List<PrivateMenuCommand> searchList = null;
     
      if(log.isDebugEnabled()){
         log.debug("pcafe_num : "+pcafe_num);
      }
      
      
      
   
      
      if(count > 0){
    	  searchList = admincustomizingService.searchList(map);
      }else{
    	  searchList = Collections.emptyList();
      }

      
      
      ModelAndView mav = new ModelAndView("adminCustomizingMenu");
      mav.addObject("privatecafe", privatecafe);
      mav.addObject("searchList", searchList);
      mav.addObject("pcafe_num", pcafe_num);
      mav.addObject("count", count);
      mav.addObject("pagingHtml",page.getPagingHtml());
   
      System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
      /*System.out.println(list1);*/
      return mav;

      
   }

}
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

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.util.PagingUtil_adminCustomizing;

@Controller
public class AdminCustomizingMenuListController {
   
   private int rowCount = 8;
   private int pageCount = 10;   
   
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="admincustomizingService")
   private AdminCustomizingService admincustomizingService;
   
   
   @RequestMapping("/admin/customizing/customizingmenu.do")
   public ModelAndView process(@RequestParam(value="custom_num",defaultValue="") int custom_num,
                        @RequestParam(value="pageNum",defaultValue="1") int currentPage,
                        @RequestParam(value="keyword",defaultValue="") String keyword)throws Exception{
      
   
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("keyword", keyword);
      
      
      //ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
      int count = admincustomizingService.getRowCount(custom_num);
      
      PagingUtil_adminCustomizing page = new PagingUtil_adminCustomizing(keyword,currentPage,count,rowCount,pageCount,custom_num,"customizingmenu.do");
      
      map.put("start", page.getStartCount());
      map.put("end", page.getEndCount());
      map.put("custom_num", custom_num);
      
      System.out.println("==============");
      
      
      AdminCustomizingCommand adminCustomizingCommand = admincustomizingService.selectCustomizing(custom_num);
      
     
      
      /*List<PrivateMenuCommand> menuList = privateService.menuList(map);*/
      List<AdminCustomizingCommand> searchList = null;
     
      if(log.isDebugEnabled()){
         log.debug("pcafe_num : "+custom_num);
      }
      
      
      
   
      
      if(count > 0){
    	  searchList = admincustomizingService.searchList(map);
      }else{
    	  searchList = Collections.emptyList();
      }

      
      
      ModelAndView mav = new ModelAndView("adminCustomizingMenu");
      mav.addObject("adminCustomizingCommand", adminCustomizingCommand);
      mav.addObject("searchList", searchList);
      mav.addObject("custom_num", custom_num);
      mav.addObject("count", count);
      mav.addObject("pagingHtml",page.getPagingHtml());
   
      System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
      /*System.out.println(list1);*/
      return mav;

      
   }

}
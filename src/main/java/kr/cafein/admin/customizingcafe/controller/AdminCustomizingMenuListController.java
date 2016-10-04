package kr.cafein.admin.customizingcafe.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.domain.LikeCommand;
import kr.cafein.util.PagingUtil_adminCustomizing;

@Controller
public class AdminCustomizingMenuListController {
   
   private int rowCount = 8;
   private int pageCount = 10;   
   
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name="admincustomizingService")
   private AdminCustomizingService admincustomizingService;
   
   
   @RequestMapping("/admin/customizing/customizingmenu.do")
   public ModelAndView process(@RequestParam(value="custom_num") int custom_num,
                        @RequestParam(value="pageNum",defaultValue="1") int currentPage,
                        @RequestParam(value="keyword",defaultValue="") String keyword,
                        @RequestParam(value="franchise_num",defaultValue="") int franchise_num,
                        HttpSession session)throws Exception{
      
	   
	   System.out.println("keyword :" + keyword);
	   System.out.println("custom_num : " + custom_num);
	   
	   
      HashMap<String, Object> map = new HashMap<String, Object>();
    
      map.put("keyword", keyword);
      
      
      //총 글의 갯수 또는 검색된 글의 갯수
      int count = admincustomizingService.getRowCount(custom_num);
      
    /*  String u_uid = (String)session.getAttribute("u_uid");*/
      
      String u_uid = admincustomizingService.selectUid(custom_num);
      System.out.println("u_uid : " + u_uid);
      PagingUtil_adminCustomizing page = new PagingUtil_adminCustomizing(keyword,currentPage,count,rowCount,pageCount,custom_num,"customizingmenu.do");
      
      map.put("start", page.getStartCount());
      map.put("end", page.getEndCount());
      map.put("custom_num", custom_num);
      map.put("u_uid", u_uid);
      map.put("franchise_num", franchise_num);
      
      log.debug("franchise_num : " + franchise_num);
      System.out.println("==============");
      
      
      AdminCustomizingCommand adminCustomizingCommand = admincustomizingService.getCustomizing(custom_num);
      
      
     /*List<PrivateMenuCommand> menuList = privateService.menuList(map);*/
      List<AdminCustomizingDetailCommand> searchList = null;
     
      if(log.isDebugEnabled()){
         log.debug("pcafe_num : "+custom_num);
      }
      
      
      
      
   
      
      if(count > 0){
    	  searchList = admincustomizingService.searchList(map);
      }else{
    	  searchList = Collections.emptyList();
      }
      
      System.out.println("searchList:" + searchList);
      System.out.println("count:" + count);
      System.out.println("franchise_num:" + franchise_num);
      System.out.println("u_uid:" + u_uid);
      System.out.println("keyword: " + keyword);
      System.out.println("custom_num:" + custom_num);
      

      
    //해쉬태그
      String hashTag = adminCustomizingCommand.getCustom_hash_tag();
      //원래 , 적용된 해쉬태그 뷰에 반환
      String hashTagOriginal1 = adminCustomizingCommand.getCustom_hash_tag();
      //초기화
      adminCustomizingCommand.setCustom_hash_tag("");
      String[] hashTagArray = hashTag.split(",");
      for (int i = 0; i < hashTagArray.length; i++) {
        //인덱스 안에 , 값이 없으면 -1 반환
        if(hashTagArray[i].indexOf(",") != -1){
           //*이 있다는 것이므로 *표를 빈값으로 대체
           //,표시 없애주기
     	  hashTagArray[i] = hashTagArray[i].replace(",","");
        }
        adminCustomizingCommand.setCustom_hash_tag(adminCustomizingCommand.getCustom_hash_tag() + "#"+hashTagArray[i] + " ");
     }

		List<LikeCommand> getLikeUser1= admincustomizingService.getLikeUser(custom_num);

      
      ModelAndView mav = new ModelAndView("adminCustomizingMenu");
      mav.addObject("adminCustomizingCommand", adminCustomizingCommand);
      mav.addObject("hashTagOriginal1", hashTagOriginal1);
      mav.addObject("getLikeUser1", getLikeUser1);
      mav.addObject("searchList", searchList);
      mav.addObject("custom_num", custom_num);
      mav.addObject("count", count);
      mav.addObject("pagingHtml",page.getPagingHtml());
   
      System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
      /*System.out.println(list1);*/
      return mav;

      
   }

}
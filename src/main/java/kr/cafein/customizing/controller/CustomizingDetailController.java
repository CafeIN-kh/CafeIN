package kr.cafein.customizing.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.customizing.domain.CustomizingDetailCafeNameCommand;
import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.util.PagingUtil;

@Controller
public class CustomizingDetailController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 6;
	private int pageCount = 6;
	
	@Resource(name="customizingDetailService")
	private CustomizingDetailService customizingDetailService;
	   
	@RequestMapping("/cafein_user/customizing/customizing_detail.do")
	@ResponseBody
	public ModelAndView process(@RequestParam(value="custom_num",defaultValue="")int custom_num,
								@RequestParam(value="u_uid",defaultValue="")String uid,
								@RequestParam(value="franchise_num")int franchise_num,
								HttpSession session){

		if(log.isDebugEnabled()){
			log.debug("custom_num : " + custom_num);
		}
		
		//String u_uid = (String)session.getAttribute("u_uid");
		
		customizingDetailService.updateHit(custom_num);
		
		//페이지뷰 카운트, 오늘 날짜에 따라 페이지뷰 로우 생성(insert)과 업데이트(update)
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
        userCountLogCommand = customizingDetailService.selectCustomUserCountLogByDate();	//오늘 날짜와 db에 저장된 날짜가 일치하는 row 찾기 
        if(userCountLogCommand == null) {
        	log.debug("★★★오늘날짜 페이지뷰 로우 없으므로 insert");
        	customizingDetailService.insertCustomUserCountLog();
        }else {
        	log.debug("★★★오늘날자 페이지뷰 로우 있으므로 update, 전체카운트와 개인카페 카운트+1");
        	customizingDetailService.updateCustomUserCountLog();
        }
        
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("custom_num", custom_num);
		map.put("u_uid", uid);
		map.put("franchise_num", franchise_num);
		
		System.out.println("custom_num : " + custom_num + ", uid : " + uid + ", franchise_num : " + franchise_num);
		
		
		
		CustomizingDetailCommand customCommand = null;
		
		
		customCommand = customizingDetailService.selectCustomMenu(map);
		
		customCommand.setCustom_introduce(customCommand.getCustom_introduce().replace("<br>", "\n"));
		
		customCommand.setCustom_recipe(customCommand.getCustom_recipe().replace("<br>","\n"));
		
		//해쉬태그 #로 바꾸는 과정
		String customTagName = customCommand.getCustom_hash_tag();
	    String[] customTagNameArray;
	    String customTagSum = "";
	    //문자열에 ,가 있다면 쪼개서 배열에 담기
	    customTagNameArray = customTagName.split(",");
	    for (int j = 0; j < customTagNameArray.length; j++) {
	    	customTagSum += "#"+customTagNameArray[j]+" ";
		}
	    customCommand.setCustom_hash_tag(customTagSum);
		
		String cafeName = customizingDetailService.selectCafeName(custom_num);
		
		int start = 3;
		
		int bookmarkCount = customizingDetailService.selectFirstBookmarkCount(custom_num);
		
		
		int likeCount = customizingDetailService.selectFirstLikeCount(custom_num);
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		
		List<CustomizingDetailCommand> list = null;
		map1.put("franchise_num", franchise_num);
		map1.put("custom_num", custom_num);
		map1.put("u_uid", uid);
		map1.put("start", start);
		list = customizingDetailService.list(map1);
						
		List<CustomizingDetailCafeNameCommand> customizingDetailCafeNameCommand = null;
		
		customizingDetailCafeNameCommand = customizingDetailService.selectCafeMenu();
		
		System.out.println("customCommand : " + customCommand);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customizing_detail");
		mav.addObject("customCommand",customCommand);
		//#로 바꾸기 전 ,태그 수정창에 띄우기 위함
		mav.addObject("customTagName",customTagName);
		mav.addObject("cafeName",cafeName);
		mav.addObject("bookmarkCount",bookmarkCount);
		mav.addObject("likeCount",likeCount);
		mav.addObject("customizingDetailCafeNameCommand",customizingDetailCafeNameCommand);
		mav.addObject("list",list);

		return mav;

	}
	
	@RequestMapping("/cafein_user/customizing/custom/customreplylistAjax.do")
	@ResponseBody
	public Map<String, Object> customReplyList(//@RequestBody Map<String, Object> params,
												@RequestParam(value="pageNum", defaultValue="1") int currentPage,
												@RequestParam(value="custom_num", defaultValue="") int custom_num,
												HttpSession session){
		
		
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
			log.debug("custom_num : " + custom_num);
		}
		
		System.out.println("custom_num ------------------ " + custom_num);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		int count = customizingDetailService.getReplyRowCount(custom_num);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"/cafein_user/customizing/custom/customreplylistAjax.do");
		
		map.put("custom_num", custom_num);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		System.out.println("custom_num*********************" + custom_num);
		System.out.println("start" + page.getStartCount());
		System.out.println("end" + page.getEndCount());
		
		List<CustomizingDetailReplyCommand> customReplyList = null;
		
		if(count > 0) {
			customReplyList = customizingDetailService.customReplyList(map);
			System.out.println("list : " +  customReplyList);
		}else {
			customReplyList = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("customReplyList", customReplyList);

		return mapJson;
	}
}

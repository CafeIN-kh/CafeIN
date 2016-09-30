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
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("custom_num", custom_num);
		map.put("u_uid", uid);
		map.put("franchise_num", franchise_num);
		
		System.out.println("custom_num : " + custom_num + ", uid : " + uid + ", franchise_num : " + franchise_num);
		
		CustomizingDetailCommand customCommand = customizingDetailService.selectCustomMenu(map);
		
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

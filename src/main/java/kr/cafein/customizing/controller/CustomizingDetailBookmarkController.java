package kr.cafein.customizing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.customizing.domain.CustomizingDetailBookmarkCommand;
import kr.cafein.customizing.service.CustomizingDetailService;

@Controller
public class CustomizingDetailBookmarkController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/custom/selectbookmark.do")
	@ResponseBody
	public Map<String, String> BookmarkCount(@ModelAttribute
											@Valid  CustomizingDetailBookmarkCommand customizingDetailBookmarkCommand,
											BindingResult result,
											HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailBookmarkCommand : " + customizingDetailBookmarkCommand);
		}
		
		int bookCount = customizingDetailService.selectUserBookmark(customizingDetailBookmarkCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(bookCount==0){
			map.put("result", "fail");
		}else{
			map.put("result", "success");
		}
		System.out.println("ºÏ¸¶Å©ÄÁÆ®·Ñ·¯");
		return map;
	}

	@RequestMapping(value="/cafein_user/custom/insertbookmark.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Bookmark(@ModelAttribute
										@Valid  CustomizingDetailBookmarkCommand customizingDetailBookmarkCommand,
										BindingResult result,
										HttpSession session)throws Exception{
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailBookmarkCommand : " + customizingDetailBookmarkCommand);
		}
		System.out.println("ºÏ¸¶Å©ÄÁÆ®·Ñ·¯1");
		
		int bookmarkCount = customizingDetailService.selectUserBookmark(customizingDetailBookmarkCommand);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//Map<String,String> map = new HashMap<String,String>();
		
		if(bookmarkCount ==0){
			customizingDetailService.insertBookmark(customizingDetailBookmarkCommand);
			map.put("result", "bookmarkInsert");
			bookmarkCount = customizingDetailService.selectBookmarkCount(customizingDetailBookmarkCommand);
			map.put("LikeTotalCount", bookmarkCount);
			System.out.println("Insert ì§„í–‰");
		}else{
			customizingDetailService.deleteBookmark(customizingDetailBookmarkCommand);
			map.put("result", "bookmarkDelete");
			bookmarkCount = customizingDetailService.selectBookmarkCount(customizingDetailBookmarkCommand);
			map.put("LikeTotalCount", bookmarkCount);
			System.out.println("Delete ì§„í–‰");
		}
		
		System.out.println(customizingDetailBookmarkCommand);
		

		return map;
	}
}

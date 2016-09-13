package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseBookmarkController {
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping(value="/cafein_user/franchise/bookmark.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> showBookmark(@ModelAttribute FC_FranchiseBookmarkCommand franchiseBookmarkCommand, 
			BindingResult result, HttpSession session) throws Exception{
		
		int count = franchiseService.selectBookmarkID(franchiseBookmarkCommand);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(count == 0){
			franchiseService.insertBookmark(franchiseBookmarkCommand);
			map.put("result", "bookmarkInsert");
			System.out.println("合付农 insert 贸府 肯丰");
		}else{
			franchiseService.deleteBookmark(franchiseBookmarkCommand);
			map.put("result", "bookmarkDelete");
			System.out.println("合付农 delete 贸府 肯丰");
		}
		
		return map;
	}
	
	@RequestMapping(value="/cafein_user/franchise/selectbookmark.do", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> checkBookmark(@ModelAttribute FC_FranchiseBookmarkCommand franchiseBookmarkCommand, BindingResult result, HttpSession seeion){ 
		int count = franchiseService.selectBookmarkID(franchiseBookmarkCommand);
		//System.out.println(count);
		Map<String, String> map = new HashMap<String, String>();
		
		if(count == 0){
			map.put("result", "notCheked");
		}else{
			map.put("result", "checked");
		}
		
		return map;
	}
}

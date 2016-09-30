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

import kr.cafein.customizing.domain.CustomizingDetailULikeCommand;
import kr.cafein.customizing.service.CustomizingDetailService;

@Controller
public class CustomizingDetailULikeController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/custom/selectlike.do")
	@ResponseBody
	public Map<String, String> LikeCount(@ModelAttribute
											@Valid  CustomizingDetailULikeCommand customizingDetailULikeCommand,
											BindingResult result,
											HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("customizingDetailULikeCommand : " + customizingDetailULikeCommand);
		}
		
		int likeCount = customizingDetailService.selectULike(customizingDetailULikeCommand);
		
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(likeCount==0){
			map.put("result", "fail");
		}else{
			map.put("result", "success");
		}
		
		return map;
	}
	
	@RequestMapping(value="/cafein_user/custom/insertlike.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Bookmark(@ModelAttribute
										@Valid  CustomizingDetailULikeCommand customizingDetailULikeCommand,
										BindingResult result,
										HttpSession session)throws Exception{
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailULikeCommand : " + customizingDetailULikeCommand);
		}
		
		
		int likeCount = customizingDetailService.selectULike(customizingDetailULikeCommand);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//Map<String,String> map = new HashMap<String,String>();
		
		if(likeCount ==0){
			customizingDetailService.insertLike(customizingDetailULikeCommand);
			map.put("result", "LikeInsert");
			int totallikeCount = customizingDetailService.selectLikeCount(customizingDetailULikeCommand);
			map.put("LikeTotalCount", totallikeCount);
			System.out.println("Insert 작업");
		}else{
			customizingDetailService.deleteLike(customizingDetailULikeCommand);
			map.put("result", "LikeDelete");
			int totallikeCount = customizingDetailService.selectLikeCount(customizingDetailULikeCommand);
			map.put("LikeTotalCount", totallikeCount);
			System.out.println("Delete 작업");
		}
		
		System.out.println(customizingDetailULikeCommand);
		

		return map;
	}
}

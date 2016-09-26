package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.domain.FC_FranchiseLikeCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseLikeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/selectLike.do")
	@ResponseBody
	public Map<String, String> showLike(@ModelAttribute FC_FranchiseLikeCommand franchiseLikeCommand, HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("franchiseLikeCommand : " + franchiseLikeCommand);
		}
		String u_uid = (String)session.getAttribute("u_uid");
		int count = franchiseService.selectFranchiseLike(franchiseLikeCommand);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(u_uid == null){
			map.put("result", "logout");
		}else{
			if(count == 0){
				map.put("result", "notChecked");
			}else{
				map.put("result", "checked");
			}
		}
		return map;
	}
	
	@RequestMapping("/cafein_user/franchise/like.do")
	@ResponseBody
	public Map<String, Object> insertLike(@ModelAttribute FC_FranchiseLikeCommand franchiseLikeCommand, HttpSession session,
			@RequestParam("franchise_num") int franchise_num){
		
		if(log.isDebugEnabled()){
			log.debug("FranchiseLikeCommand : " + franchiseLikeCommand);
		}
		
		int count = franchiseService.selectFranchiseLike(franchiseLikeCommand);
				
		Map<String, Object> map = new HashMap<String, Object>();
		
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid == null){
			map.put("result", "logout");
		}else{
			if(count == 0){
				franchiseService.insertFranchiseLike(franchiseLikeCommand);
				map.put("result", "insert");				
			}else{
				franchiseService.deleteFranchiseLike(franchiseLikeCommand);
				map.put("result", "delete");
			}
		}
		int totalCount = franchiseService.totalFranchiseLike(franchise_num);
		map.put("count", totalCount);
		return map;
	}
}

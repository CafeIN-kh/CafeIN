package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.domain.FC_FranchiseMenuLikeCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseMenuLikeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/selectMenuLike.do")
	@ResponseBody
	public Map<String, Object> showMenuLike(@ModelAttribute FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand, HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("FranchiseMenuLikeCommand : " + franchiseMenuLikeCommand);
		}
		String u_uid = (String)session.getAttribute("u_uid");
		
		franchiseMenuLikeCommand.setU_uid(u_uid);
		franchiseMenuLikeCommand.setFmenu_num(franchiseMenuLikeCommand.getFmenu_num());
		
		int likeCount = franchiseService.selectMenuLike(franchiseMenuLikeCommand);
		int totalLikeCount = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(likeCount == 0){
			franchiseService.insertMenuLike(franchiseMenuLikeCommand);
			totalLikeCount = franchiseService.totalMenuLike(franchiseMenuLikeCommand);
			map.put("result", "likeInsert");
			map.put("totalLikeCount", totalLikeCount);
		}else{
			franchiseService.deleteMenuLike(franchiseMenuLikeCommand);
			map.put("result", "likeDelete");
			map.put("totalLikeCount", totalLikeCount);
		}
		
		return map;
	}
}
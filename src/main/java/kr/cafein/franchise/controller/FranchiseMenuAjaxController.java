package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuLikeCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseMenuAjaxController {
	@Resource
	private FranchiseService franchiseService;
	
	//private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/cafein_user/franchise/franchise_Ajax.do")
	@ResponseBody
	public Map<String, Object> process(@RequestParam("franchise_name") String franchise_name, @RequestParam("fmenu_num") int fmenu_num,
			HttpSession session){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FC_FranchiseMenuCommand franchiseMenu = franchiseService.selectMenu(fmenu_num);
		String u_uid = (String)session.getAttribute("u_uid");
		int menuLikeCount = 0;
		FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand = new FC_FranchiseMenuLikeCommand();
		franchiseMenuLikeCommand.setFmenu_num(fmenu_num);
		if(u_uid != null){
			franchiseMenuLikeCommand.setU_uid(u_uid);
			menuLikeCount = franchiseService.selectMenuLike(franchiseMenuLikeCommand);
		}
		
		int totalMenuLikeCount = franchiseService.totalMenuLike(franchiseMenuLikeCommand);
		
		map.put("name", franchiseMenu.getFmenu_name());
		map.put("price", franchiseMenu.getFmenu_price());
		map.put("photo", franchiseMenu.getFmenu_img());
		map.put("introduce", franchiseMenu.getFmenu_introduce());
		map.put("totalMenuLikeCount", totalMenuLikeCount);
		map.put("menuLikeCount", menuLikeCount);
		map.put("success", "success");
		map.put("fmenu_num", fmenu_num);
		map.put("franchise_name", franchise_name);
		
		return map;
	}
}

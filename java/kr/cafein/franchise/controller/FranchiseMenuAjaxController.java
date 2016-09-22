package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseMenuAjaxController {
	@Resource
	private FranchiseService franchiseService;
	
	//private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/cafein_user/franchise/franchise_Ajax.do")
	@ResponseBody
	public Map<String, Object> process(@RequestParam("franchise_name") String franchise_name, @RequestParam("fmenu_num") int fmenu_num){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FC_FranchiseMenuCommand franchiseMenu = franchiseService.selectMenu(fmenu_num);
		
		map.put("name", franchiseMenu.getFmenu_name());
		map.put("price", franchiseMenu.getFmenu_price());
		map.put("photo", franchiseMenu.getFmenu_img());
		map.put("introduce", franchiseMenu.getFmenu_introduce());
		map.put("franchise_name", franchise_name);
		//map.put("result", "success");
		
		
		
		return map;
	}
}

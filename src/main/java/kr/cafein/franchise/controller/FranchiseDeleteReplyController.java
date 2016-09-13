package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseDeleteReplyController {
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/deleteReply.do")
	@ResponseBody
	public Map<String, String> deleteReply(@RequestParam("freply_num") int freply_num){
		Map<String, String> map = new HashMap<String, String>();
		franchiseService.deleteReply(freply_num);
		map.put("result", "success");
		return map;
	}
}

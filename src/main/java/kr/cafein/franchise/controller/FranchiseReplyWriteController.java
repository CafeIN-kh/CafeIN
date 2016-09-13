package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;
import kr.cafein.franchise.service.FranchiseService;

@Controller
public class FranchiseReplyWriteController {
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping(value="/cafein_user/franchise/writeReply.do")
	@ResponseBody
	public Map<String, String> writeReply(@ModelAttribute FC_FranchiseReplyCommand franchiseReplyCommand, @RequestParam("franchise_num") int franchise_num){
		
		//System.out.println("write 컨트롤러 진입");
		
		//int franchise_num = 1;
		String u_uid = "test";
		String freply_nickname = "test";
		
		franchiseReplyCommand.setFranchise_num(franchise_num);
		franchiseReplyCommand.setU_uid(u_uid);
		franchiseReplyCommand.setFreply_nickname(freply_nickname);
		//System.out.println(franchiseReplyCommand);
		franchiseService.insertReply(franchiseReplyCommand);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("result", "success");
		return map;
	}
}

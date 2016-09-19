package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	public Map<String, String> writeReply(@ModelAttribute FC_FranchiseReplyCommand franchiseReplyCommand, @RequestParam("franchise_num") int franchise_num,
			HttpSession session){
		
		//System.out.println("write 컨트롤러 진입");
		
		//int franchise_num = 1;

		String freply_nickname = (String)session.getAttribute("u_name");
		String u_uid = (String)session.getAttribute("u_uid");
		
		if(freply_nickname == null){
			freply_nickname = "Guest";
		}
		
		if(u_uid == null){
			u_uid = "Guest";
		}
		
		franchiseReplyCommand.setFranchise_num(franchise_num);
		franchiseReplyCommand.setFreply_nickname(freply_nickname);
		franchiseReplyCommand.setU_uid(u_uid);
		franchiseService.insertReply(franchiseReplyCommand);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("result", "success");
		return map;
	}
}

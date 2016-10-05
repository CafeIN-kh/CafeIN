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

import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;
import kr.cafein.franchise.service.FranchiseService;
import kr.cafein.util.StringUtil;

@Controller
public class FranchiseReplyWriteController {
	
	Logger log = Logger.getLogger(this.getClass());
	
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
		
		//줄바꿈 처리
		franchiseReplyCommand.setFreply_content(StringUtil.useBrNoHtml(franchiseReplyCommand.getFreply_content()));
		
		franchiseService.insertReply(franchiseReplyCommand);
		
		Map<String, String> map = new HashMap<String, String>();
		
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(2);
		userMenuLogCommand.setUmenu_log_state(0);
		String logMessage = "";
		if(!u_uid.equals("Guest")){
			String u_email = franchiseService.selectDeclaredMember(u_uid).getU_email();
			logMessage = "[" + u_email + "] 사용자가 프렌차이즈 카페에서 댓글을 등록 하였습니다."; 
		}else {
			logMessage = "[Guest] 사용자가 개인카페에서 댓글을 등록 하였습니다."; 
		}
		userMenuLogCommand.setUmenu_log_message(logMessage);
		franchiseService.insertUserLog_FC(userMenuLogCommand);
		log.debug("[프랜차이즈카페 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		
		map.put("result", "success");
		return map;
	}
}

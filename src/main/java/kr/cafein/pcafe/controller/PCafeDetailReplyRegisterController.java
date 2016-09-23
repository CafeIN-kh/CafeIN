package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.StringUtil;

@Controller
public class PCafeDetailReplyRegisterController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping(value="/cafein_user/private/private_detailReplyRegister_ajax.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute
							@Valid PCafeReplyCommand pcafeReplyCommand,
							HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pcafeReplyCommand : " + pcafeReplyCommand);
		}
		System.out.println("private_detailReplyRegister_ajax 진입");
		
		Map<String,String> map = new HashMap<String,String>();
		
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid != null) {
			pcafeReplyCommand.setU_uid(u_uid);
			
		}else {
			u_uid = "Guest";
			pcafeReplyCommand.setU_uid(u_uid);
		}
		
		//줄바꿈 처리
		pcafeReplyCommand.setPreply_content(StringUtil.useBrNoHtml(pcafeReplyCommand.getPreply_content()));
		
		//로그인 됨, 댓글 등록
		pcafeService.insertReply(pcafeReplyCommand);
		
		//개인카페  댓글 등록 로그, umenu_name=3, umenu_log_state=0 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(3);
		userMenuLogCommand.setUmenu_log_state(0);
		String logMessage = "";
		if(!u_uid.equals("Guest")){
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			logMessage = "[" + u_email + "] 사용자가 개인카페에서 댓글을 등록 하였습니다."; 
		}else {
			logMessage = "[Guest] 사용자가 개인카페에서 댓글을 등록 하였습니다."; 
		}
		userMenuLogCommand.setUmenu_log_message(logMessage);
		pcafeService.insertUserLog(userMenuLogCommand);
		log.debug("[개인카페 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		map.put("result", "success");
		
		return map;
	}
}

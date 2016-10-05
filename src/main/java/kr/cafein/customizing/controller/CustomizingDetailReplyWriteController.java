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

import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.util.StringUtil;

@Controller
public class CustomizingDetailReplyWriteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/customizing/custom/insertreply.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> submit(@ModelAttribute
											@Valid  CustomizingDetailReplyCommand customizingDetailReplyCommand,
											BindingResult result,
											HttpSession session)throws Exception{

		
	/*	int custom_num = customizingDetailReplyCommand.getCustom_num();
		customizingDetailReplyCommand.setCustom_num(custom_num);
		*/
		//String u_uid = "1";
		//String u_uid = (String)session.getAttribute("u_uid");
		
		//customizingDetailReplyCommand.setU_uid(u_uid);
		
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid != null) {
			customizingDetailReplyCommand.setU_uid(u_uid);
			
		}else {
			u_uid = "Guest";
			customizingDetailReplyCommand.setU_uid(u_uid);
		}
		/*
		//int creply_num = 0;
		//customizingDetailReplyCommand.setCreply_num(creply_num);
		
		session.setAttribute("creply_num", creply_num);
		
		if(u_uid != null){
			session.setAttribute("u_uid", u_uid);
		}
		*/
		//String nickname = "장딜바보";
		
		//customizingDetailReplyCommand.setCreply_nickname(nickname);
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailReplyCommand : " + customizingDetailReplyCommand);
		}
		
		customizingDetailReplyCommand.setCreply_content(StringUtil.useBrNoHtml(customizingDetailReplyCommand.getCreply_content()));

		customizingDetailService.insertReply(customizingDetailReplyCommand);
		
		//System.out.println("커맨트등록" + customizingDetailReplyCommand.getCreply_content());
		
		//커스텀메뉴 로그, umenu_name=4, umenu_log_state=0 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(4);
		userMenuLogCommand.setUmenu_log_state(0);
		String u_email = customizingDetailService.selectCustomUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴에서 댓글을 등록 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
	}
}

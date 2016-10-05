package kr.cafein.customizing.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.UserMenuLogCommand;

@Controller
public class CustomizingDetailReplyDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/customizing/customizing_deleteReplyAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> process(@RequestParam int creply_num,
										@RequestParam String u_uid,
										HttpSession session){
		
		System.out.println("댓글삭제 컨트롤러 진입!!!!");
		
		//CustomizingDetailReplyCommand customizingDetailReplyCommand;
		
		if(log.isDebugEnabled()){
			 //log.debug("customizingDetailReplyCommand : " + customizingDetailReplyCommand);
			 log.debug("creply_num : " + creply_num);
			 log.debug("u_uid : " + u_uid);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		System.out.println("u_uid!!!!!!!" + u_uid);
		 
		//로그인 여부
		try{
			u_uid = (String)session.getAttribute("u_uid");
			if(u_uid == null){
				//로그인 안되어있는 것
				map.put("result", "logout");
			}else if(u_uid != null && u_uid.equals(u_uid)){
				customizingDetailService.customizingReplyDelete(creply_num);
				
				//커스텀메뉴 로그, umenu_name=4, umenu_log_state=2 고정
				//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
				//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
				UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
				userMenuLogCommand.setUmenu_log_u_uid(u_uid);
				userMenuLogCommand.setUmenu_name(4);
				userMenuLogCommand.setUmenu_log_state(2);
				String u_email = customizingDetailService.selectCustomUserLogByMember(u_uid).getU_email();
				String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴에서 댓글을 삭제 하였습니다."; 
				userMenuLogCommand.setUmenu_log_message(logMessage);
				customizingDetailService.insertCustomUserLog(userMenuLogCommand);
				log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);
				
				map.put("result", "success");
				System.out.println("u_uid!!!!!!!--" + u_uid);
			}else{
				map.put("result", "wrongAccess");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		System.out.println("u_uid!!!!!!!" + u_uid);
		//System.out.println("custom_num!!!!!!!" + custom_num);
		System.out.println("creply_num!!!!!!!" + creply_num);
		
		map.put("result", "success");
		
		return map;
	}

}

package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;

@Controller
public class PCafeDetailReplyDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping("/cafein_user/private/private_detailReplyDelete_ajax.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("preply_num") int preply_num
									  ,@RequestParam("u_uid") String u_id
									  ,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("preply_num : " + preply_num);
			log.debug("u_id : " + u_id);
		} 
		
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			String u_uid = (String) session.getAttribute("u_uid");
			
			if(u_uid == null) {
				
				map.put("result", "logout");
				
			}else if(u_uid != null && u_uid.equals(u_id)) {
				
				pcafeService.deleteReply(preply_num);
				
				//개인카페  댓글 삭제 로그, umenu_name=3, umenu_log_state=2 고정
				//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
				//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
				UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
				userMenuLogCommand.setUmenu_log_u_uid(u_uid);
				userMenuLogCommand.setUmenu_name(3);
				userMenuLogCommand.setUmenu_log_state(2);
				String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
				String logMessage = "[" + u_email + "] 사용자가 개인카페에서 댓글을 삭제 하였습니다."; 
				userMenuLogCommand.setUmenu_log_message(logMessage);
				pcafeService.insertUserLog(userMenuLogCommand);
				log.debug("[개인카페 로그] userMenuLogCommand : " + userMenuLogCommand);
				
				map.put("result", "success");
				
			}else {
				
				map.put("result", "wrongAccess");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}
		
		return map;
	}
	
}

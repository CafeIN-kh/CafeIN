package kr.cafein.customizing.controller;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.util.FileUtilCus;;


@Controller
public class CustomizingDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingService customizingService;
	@Resource(name="customizingDetailService")
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping("/cafein_user/customizing/customizing_delete.do")
	public String submit(
			@RequestParam(value="custom_num",defaultValue="") int custom_num, 
			HttpSession session) throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("custom_num : " + custom_num);
		}
		
		CustomizingCommand customizingCommand = customizingService.selectBoard(custom_num);
		
		System.out.println("customizingCommand안에다가 customizingService.selectBoard(custom_num)을 넣어주면 : " +customizingCommand.toString());
		String u_uid = (String)session.getAttribute("u_uid");
		
		if(!u_uid.equals(customizingCommand.getU_uid())) {
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		customizingService.deleteU_like(custom_num);
		customizingService.deleteBookmark(custom_num);
		customizingService.deleteReply(custom_num);
		customizingService.deleteCboard(custom_num);
		
		//파일 삭제 여부 체크
		if(customizingCommand.getCustom_img() != null) {
			FileUtilCus.removeFile(customizingCommand.getCustom_img());
		}
		
		//커스텀메뉴 로그, umenu_name=1, umenu_log_state=2 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(1);
		userMenuLogCommand.setUmenu_log_state(2);
		String u_email = customizingDetailService.selectCustomUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴를 삭제 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		return "redirect:/cafein_user/customizing/customizing_list.do";
	}
}

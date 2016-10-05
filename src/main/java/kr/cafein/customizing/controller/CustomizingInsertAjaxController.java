package kr.cafein.customizing.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.util.FileUtilCus;
import kr.cafein.util.StringUtil;

@Controller
public class CustomizingInsertAjaxController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingService customizingService; 
	@Resource(name="customizingDetailService")
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping("/cafein_user/customizing/customizingInsert_ajax.do")
	@ResponseBody
	public Map<String,String> process(@ModelAttribute("command")
								     @Valid CustomizingCommand customizingCommand,BindingResult result,
									        SessionStatus status,
									        HttpSession session)
			throws Exception{
		
		String u_uid = (String)session.getAttribute("u_uid");
		customizingCommand.setU_uid(u_uid);
		
		
		if(log.isDebugEnabled()){
			log.debug("customizingCommand : " + customizingCommand);
		}
		
		String newName = "";
		
		if(customizingCommand.getUpload()!=null && !customizingCommand.getUpload().isEmpty()){
			newName = FileUtilCus.rename(customizingCommand.getUpload().getOriginalFilename());
		  customizingCommand.setCustom_img(newName);
		}
		
		//줄바꿈허용
		customizingCommand.setCustom_introduce(StringUtil.useBrNoHtml(customizingCommand.getCustom_introduce()));
		customizingCommand.setCustom_recipe(StringUtil.useBrNoHtml(customizingCommand.getCustom_recipe()));
	      
		
		//글쓰기
		customizingService.insert(customizingCommand);
		status.setComplete();
		
		
		
		//파일을 upload 폴더에 저장
		if(customizingCommand.getUpload()!=null && !customizingCommand.getUpload().isEmpty()){
			File file =
			new File(FileUtilCus.UPLOAD_PATH+"/"+newName);
			customizingCommand.getUpload().transferTo(file);
			FileUtilCus.createThumbnail(newName, newName, 720, 455);
		}
		
		//System.out.println("command : "+customizingCommand.toString());
		
		//커스텀메뉴 로그, umenu_name=1, umenu_log_state=0 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(1);
		userMenuLogCommand.setUmenu_log_state(0);
		String u_email = customizingDetailService.selectCustomUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴를 등록 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		
		Map<String,String> mapJson = new HashMap<String,String> ();
		mapJson.put("result", "success");
		
		return mapJson;
	}

}

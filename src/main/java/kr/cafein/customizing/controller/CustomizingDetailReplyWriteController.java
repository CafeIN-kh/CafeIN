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

		

		
		String u_name= (String)session.getAttribute("u_name");
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid != null) {
			customizingDetailReplyCommand.setU_uid(u_uid);
			customizingDetailReplyCommand.setCreply_nickname(u_name);
			
		}else {
			u_uid = "Guest";
			customizingDetailReplyCommand.setU_uid(u_uid);
			customizingDetailReplyCommand.setCreply_nickname(u_uid);
		}
		
		
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailReplyCommand : " + customizingDetailReplyCommand);
		}
		
		customizingDetailReplyCommand.setCreply_content(StringUtil.useBrNoHtml(customizingDetailReplyCommand.getCreply_content()));
		
		customizingDetailService.insertReply(customizingDetailReplyCommand);
		
		
	
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
	}
}

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

@Controller
public class CustomizingDetailReplyDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/customizing/customizing_deleteReplyAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> process(//@ModelAttribute
										//@Valid CustomizingDetailReplyCommand customizingDetailReplyCommand,
										@RequestParam int creply_num,
										@RequestParam String u_uid,
										 //@RequestParam(value="custom_num", defaultValue="1") int custom_num,
										HttpSession session){
		
		System.out.println("댓글삭제 컨트롤러 진입!!!!!!!!!!!!!!!!!!!!");
		
		//CustomizingDetailReplyCommand customizingDetailReplyCommand;
		
		if(log.isDebugEnabled()){
			 //log.debug("customizingDetailReplyCommand : " + customizingDetailReplyCommand);
			 log.debug("creply_num : " + creply_num);
			 log.debug("u_uid : " + u_uid);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		//int custom_num = 1;
		 //customizingDetailReplyCommand.setCustom_num(custom_num);
		
		//String u_uid = "1";
		//customizingDetailReplyCommand.setU_uid(u_uid);
		
		String nickname = "장딜바보";
		//customizingDetailReplyCommand.setCreply_nickname(nickname);
		System.out.println("u_uid!!!!!!!" + u_uid);
		 
		//로그인 여부
		try{
			u_uid = (String)session.getAttribute("u_uid");
			if(u_uid == null){
				//로그인 안되어있는 것
				map.put("result", "logout");
			}else if(u_uid != null && u_uid.equals(u_uid)){
				customizingDetailService.customizingReplyDelete(creply_num);
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

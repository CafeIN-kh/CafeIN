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

import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.service.PCafeService;

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
		System.out.println("private_detailReplyRegister_ajax ÁøÀÔ");
		
		Map<String,String> map = new HashMap<String,String>();
		
		String u_uid = (String)session.getAttribute("u_uid");
		if(u_uid != null) {
			pcafeReplyCommand.setU_uid(u_uid);
		}else {
			pcafeReplyCommand.setU_uid("Guest");
		}
		//·Î±×ÀÎ µÊ, ´ñ±Û µî·Ï
		pcafeService.insertReply(pcafeReplyCommand);
		map.put("result", "success");
		
		return map;
	}
}

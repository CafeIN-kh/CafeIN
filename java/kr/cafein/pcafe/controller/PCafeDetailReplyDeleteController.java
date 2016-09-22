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

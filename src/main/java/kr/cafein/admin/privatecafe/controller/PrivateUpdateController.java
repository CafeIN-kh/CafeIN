package kr.cafein.admin.privatecafe.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService privateService;
	
	@RequestMapping("/admin/modify.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		/*privateService.update(privateCafeMenu);*/
		
		return "redirect:/admin/adminPrivateCafe.do";
		
	}

}
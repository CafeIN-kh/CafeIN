package kr.cafein.admin.privatecafe.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService privateService;
	
	@RequestMapping("/admin/privatecafe/privatecafe-delete.do")
	public String submit(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
	/*	PrivateCommand privatecommand = privateService.selectBoard(pcafe_num);
		*/
		
		
		
		privateService.deletereply(pcafe_num);
		privateService.deleteallmenu(pcafe_num);
		privateService.delete(pcafe_num);
		
		return "redirect:/admin/privatecafe/privatecafe.do";
		
	}

}

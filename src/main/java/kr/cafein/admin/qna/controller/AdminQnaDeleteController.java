package kr.cafein.admin.qna.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.qna.service.AdminQnaService;

@Controller
public class AdminQnaDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminQnaService adminQnaService;
	
	@RequestMapping("/cafein_admin/qna/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		adminQnaService.delete(seq);
		
		return "redirect:/cafein_admin/qna/List.do";
		
	}

}

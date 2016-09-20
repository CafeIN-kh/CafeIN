package kr.cafein.admin.qna.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.qna.service.QnaService;

@Controller
public class QnaDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnaService qnaService;
	
	@RequestMapping("/cafein_admin/qna/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		qnaService.delete(seq);
		
		return "redirect:/cafein_admin/qna/List.do";
		
	}

}

package kr.cafein.admin.notice.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.notice.service.NoticeService;

@Controller
public class NoticeDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;

	@RequestMapping("/cafein_admin/notice/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		noticeService.delete(seq);
		
		return "redirect:/cafein_admin/notice/List.do";
		
	}
}

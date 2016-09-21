package kr.cafein.admin.notice.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.notice.service.AdminNoticeService;

@Controller
public class AdminNoticeDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;

	@RequestMapping("/cafein_admin/notice/delete.do")
	public String submit(@RequestParam("seq") int seq)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		adminNoticeService.delete(seq);
		
		return "redirect:/cafein_admin/notice/List.do";
		
	}
}

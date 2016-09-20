package kr.cafein.admin.notice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.notice.domain.NoticeCommand;
import kr.cafein.admin.notice.service.NoticeService;

@Controller
public class NoticeListController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@RequestMapping("/cafein_admin/notice/List.do")
	public ModelAndView process(){
		List<NoticeCommand> list = noticeService.getNoticeList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("noticeList");
		mav.addObject("list", list);
		return mav;
		
	}

}

package kr.cafein.admin.notice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.service.AdminNoticeService;

@Controller
public class AdminNoticeListController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="adminNoticeService")
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping("/cafein_admin/notice/List.do")
	public ModelAndView process(){
		List<AdminNoticeCommand> list = adminNoticeService.getNoticeList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("noticeList");
		mav.addObject("list", list);
		return mav;
		
	}

}

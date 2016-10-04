package kr.cafein.admin.notice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;
import kr.cafein.admin.notice.service.AdminNoticeService;

@Controller
public class AdminNoticeLogListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping(value="/cafein_admin/notice/AdminLogList.do")
	public ModelAndView process(){
		List<AdminNoticeLogCommand> list = adminNoticeService.getAdminNotice_LogList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("noticeLogList");
		mav.addObject("list",list);
		return mav;
		
		
	}

}

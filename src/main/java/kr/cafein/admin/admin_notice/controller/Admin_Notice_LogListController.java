package kr.cafein.admin.admin_notice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.admin_notice.service.Admin_NoticeService;

@Controller
public class Admin_Notice_LogListController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="admin_NoticeService")
	private Admin_NoticeService admin_NoticeService;
	
	@RequestMapping("/cafein_admin/admin_notice/LogList.do")
	public ModelAndView process(){
		List<Admin_Notice_LogCommand> list = admin_NoticeService.getAdmin_Notice_LogList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		ModelAndView mav = new ModelAndView("admin_notice_logList");
		mav.addObject("list",list);
		return mav;
		
	}

}

package kr.cafein.admin.admin_notice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.service.Admin_NoticeService;

@Controller
public class Admin_NoticeListController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="admin_NoticeService")
	private Admin_NoticeService admin_NoticeService;
	
	@RequestMapping("/cafein_admin/admin_notice/List.do")
	public ModelAndView process(){
		List<Admin_NoticeCommand> list = admin_NoticeService.getAdmin_NoticeList();
		System.out.println("111111111111111111");
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		System.out.println(list);
		System.out.println("22222222222222222");
		ModelAndView mav = new ModelAndView("admin_noticeList");
		mav.addObject("list", list);
		return mav;
		
	}
	

}
package kr.cafein.admin.notice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;
import kr.cafein.admin.notice.service.AdminNoticeService;

@Controller
public class AdminNoticeDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;

	@RequestMapping("/cafein_admin/notice/delete.do")
	public String submit(@RequestParam("seq") int seq, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		//=======================log남기기==================================
		AdminNoticeLogCommand adminNoticeLogCommand = new AdminNoticeLogCommand();
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		AdminNoticeCommand adminNoticeCommand = adminNoticeService.selectNotice(seq);
		
		adminNoticeLogCommand.setN_log_uid(u_uid);
		adminNoticeLogCommand.setN_log_change(2);
		adminNoticeLogCommand.setN_log_message("["+u_uid+"] 사용자가 Notice 게시판에 "+adminNoticeCommand.getNotice_title()+"글 을 삭제했습니다.");
		System.out.println("로그 : "+adminNoticeLogCommand);
		
		adminNoticeService.insertAdminNotice_Log(adminNoticeLogCommand);
		//===============================================================
		
		
		adminNoticeService.delete(seq);
		
		return "redirect:/cafein_admin/notice/List.do";
		
	}
}

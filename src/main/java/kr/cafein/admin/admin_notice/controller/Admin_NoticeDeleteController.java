package kr.cafein.admin.admin_notice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.admin_notice.service.Admin_NoticeService;

@Controller
public class Admin_NoticeDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="admin_NoticeService")
	private Admin_NoticeService admin_NoticeService;
	
	@RequestMapping("/cafein_admin/admin_notice/delete.do")
	public String submit(@RequestParam("admin_notice_num") int admin_notice_num, HttpSession session)throws Exception{
		if(log.isDebugEnabled()){
			log.debug("admin_notice_num : "+admin_notice_num);
		}
		
		//=======================log남기기==================================
		
		Admin_Notice_LogCommand admin_notice_LogCommand = new Admin_Notice_LogCommand();
		
		Admin_NoticeCommand admin_noticeCommnad = admin_NoticeService.selectAdmin_Notice(admin_notice_num);
		
		System.out.println("커맨드 : "+admin_noticeCommnad);
		
		String u_uid = (String)session.getAttribute("u_uid");
		System.out.println("u_id : "+u_uid);
		admin_notice_LogCommand.setAn_log_uid(u_uid);
		admin_notice_LogCommand.setAn_log_change(1);
		admin_notice_LogCommand.setAn_log_message("["+u_uid+"] 사용자가 Admin Notice에 "+admin_noticeCommnad.getAdmin_notice_title()+"글을 삭제했습니다");
		
		admin_NoticeService.inserAdmin_Notice_Log(admin_notice_LogCommand);
		//===============================================================
		
		admin_NoticeService.deleteAdmin_Notice(admin_notice_num);
		
		return "redirect:/cafein_admin/admin_notice/List.do";
	}

}

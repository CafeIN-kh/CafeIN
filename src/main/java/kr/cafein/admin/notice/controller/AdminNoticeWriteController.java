package kr.cafein.admin.notice.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;
import kr.cafein.admin.notice.service.AdminNoticeService;
import kr.cafein.util.FileUtil_adminNotice;

@Controller
@SessionAttributes("noticeCommand")
public class AdminNoticeWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping(value="/cafein_admin/notice/write.do", method=RequestMethod.GET)
	public String form(Model model,HttpSession session){
		AdminNoticeCommand noticeCommand = new AdminNoticeCommand();
		String u_uid = (String)session.getAttribute("u_uid");
		noticeCommand.setNotice_uid(u_uid);
		
		model.addAttribute("noticeCommand", noticeCommand);
		
		return "noticeWrite";
	}
	
	@RequestMapping(value="/cafein_admin/notice/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("noticeCommand") @Valid AdminNoticeCommand noticeCommand, BindingResult result, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("noticeCommand : " + noticeCommand);
		}
		
		String newName = "";
		
		if(!noticeCommand.getUpload().isEmpty()){
			newName = FileUtil_adminNotice.rename(noticeCommand.getUpload().getOriginalFilename());
			noticeCommand.setNotice_img(newName);
		}
		
		adminNoticeService.insertNotice(noticeCommand);
		
		if(!noticeCommand.getUpload().isEmpty()){
			File file = new File(FileUtil_adminNotice.UPLOAD_PATH+"/"+newName);
			noticeCommand.getUpload().transferTo(file);
		}
		
		//=======================log남기기==================================
		AdminNoticeLogCommand adminNoticeLogCommand = new AdminNoticeLogCommand();
		
		String u_uid = (String)session.getAttribute("u_uid");
		System.out.println("u_uid"+u_uid);
		
		adminNoticeLogCommand.setN_log_uid(u_uid);
		adminNoticeLogCommand.setN_log_change(0);
		adminNoticeLogCommand.setN_log_message("["+u_uid+"] 사용자가 Notice 게시판에 "+noticeCommand.getNotice_title()+"글 을 작성했습니다.");
		System.out.println("로그 : "+adminNoticeLogCommand);
		
		adminNoticeService.insertAdminNotice_Log(adminNoticeLogCommand);
		//===============================================================
		
		
		return "redirect:/cafein_admin/notice/List.do";
	}

}

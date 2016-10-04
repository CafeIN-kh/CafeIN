package kr.cafein.admin.admin_notice.controller;

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

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.admin_notice.service.Admin_NoticeService;
import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.util.FileUtil_admin_adminNotice;

@Controller
@SessionAttributes("admin_noticeCommand")
public class Admin_NoticeWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private Admin_NoticeService admin_NoticeService;
	
	@RequestMapping(value="/cafein_admin/admin_notice/write.do", method=RequestMethod.GET)
	public String form(Model model,HttpSession session){
		String admin_noticeUid = (String)session.getAttribute("u_uid");
		
		Admin_NoticeCommand admin_noticeCommand = new Admin_NoticeCommand();
		
		admin_noticeCommand.setU_uid(admin_noticeUid);
		model.addAttribute("admin_noticeCommand", admin_noticeCommand);
		System.out.println("아이디 : "+admin_noticeUid);
		
		return "admin_noticeWrite";
	}
	
	@RequestMapping(value="/cafein_admin/admin_notice/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("admin_noticeCommand") @Valid Admin_NoticeCommand admin_noticeCommand, BindingResult result, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("admin_noticeCommand : " + admin_noticeCommand);
		}
		
		String newName = "";
		
		if(!admin_noticeCommand.getUpload().isEmpty()){
			newName = FileUtil_admin_adminNotice.rename(admin_noticeCommand.getUpload().getOriginalFilename());
			admin_noticeCommand.setAdmin_notice_img(newName);
		}
		
		admin_NoticeService.insertAdmin_Notice(admin_noticeCommand);
		
		if(!admin_noticeCommand.getUpload().isEmpty()){
			File file = new File(FileUtil_admin_adminNotice.UPLOAD_PATH+"/"+newName);
			admin_noticeCommand.getUpload().transferTo(file);
		}
		
		Admin_Notice_LogCommand admin_notice_LogCommand = new Admin_Notice_LogCommand();
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		admin_notice_LogCommand.setAn_log_uid(u_uid);
		admin_notice_LogCommand.setAn_log_change(0);
		admin_notice_LogCommand.setAn_log_message("["+u_uid+"] 사용자가 Admin Notice에 "+admin_noticeCommand.getAdmin_notice_title()+"글을 등록했습니다");
		
		admin_NoticeService.inserAdmin_Notice_Log(admin_notice_LogCommand);
			
		
		
		return "redirect:/cafein_admin/admin_notice/List.do";
	}

}

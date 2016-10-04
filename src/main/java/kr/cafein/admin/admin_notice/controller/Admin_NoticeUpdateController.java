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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.admin_notice.service.Admin_NoticeService;
import kr.cafein.util.FileUtil_admin_adminNotice;

@Controller
@SessionAttributes("admin_noticeCommand")
public class Admin_NoticeUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private Admin_NoticeService admin_NoticeService;
	
	@RequestMapping(value="/cafein_admin/admin_notice/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("admin_notice_num") int admin_notice_num, Model model,HttpSession session){
		System.out.println("num : "+admin_notice_num);		
		Admin_NoticeCommand admin_noticeCommand = admin_NoticeService.selectAdmin_Notice(admin_notice_num);
		System.out.println(admin_noticeCommand);
		model.addAttribute("admin_noticeCommand", admin_noticeCommand);
		
		return "admin_noticeModify";
	}
	
	@RequestMapping(value="/cafein_admin/admin_notice/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("admin_noticeCommand") @Valid Admin_NoticeCommand admin_noticeCommand, BindingResult result,HttpSession session )throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("admin_noticeCommand (Post): "+admin_noticeCommand);
		}
		
		if(result.hasErrors()){
			return "admin_noticeModify"; 
		}
				
		Admin_NoticeCommand admin_notice = null;
		String oldFileName = "";
		
		admin_notice = admin_NoticeService.selectAdmin_Notice(admin_noticeCommand.getAdmin_notice_num());
		
		oldFileName = admin_notice.getAdmin_notice_img();
		
		if(!admin_noticeCommand.getUpload().isEmpty()){
			//전송된 파일이 있는 경우
			admin_noticeCommand.setAdmin_notice_img(FileUtil_admin_adminNotice.rename(admin_noticeCommand.getUpload().getOriginalFilename()));
		}else{
			//전송된 파일이 없는 경우
			admin_noticeCommand.setAdmin_notice_img(oldFileName);
		}
		
		admin_NoticeService.updateAdmin_Notice(admin_noticeCommand);
				
		if(!admin_noticeCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
			File file = new File(FileUtil_admin_adminNotice.UPLOAD_PATH+"/"+admin_noticeCommand.getAdmin_notice_img());
			admin_noticeCommand.getUpload().transferTo(file);
			if(oldFileName != null){
				//이전 파일 삭제
				FileUtil_admin_adminNotice.removeFile(oldFileName);
			}
		}
		
		Admin_Notice_LogCommand admin_notice_LogCommand = new Admin_Notice_LogCommand();
				
		String u_uid = (String)session.getAttribute("u_uid");
		
		admin_notice_LogCommand.setAn_log_uid(u_uid);
		admin_notice_LogCommand.setAn_log_change(2);
		admin_notice_LogCommand.setAn_log_message("["+u_uid+"] 사용자가 Admin Notice에 "+admin_noticeCommand.getAdmin_notice_title()+"글을 수정했습니다");
		
		admin_NoticeService.inserAdmin_Notice_Log(admin_notice_LogCommand);
		
		return "redirect:/cafein_admin/admin_notice/List.do";
		
	}
	
	
	

}

package kr.cafein.admin.notice.controller;

import java.io.File;

import javax.annotation.Resource;
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
import kr.cafein.admin.notice.service.AdminNoticeService;
import kr.cafein.util.FileUtil_adminNotice;

@Controller
@SessionAttributes("noticeCommand")
public class AdminNoticeWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping(value="/cafein_admin/notice/write.do", method=RequestMethod.GET)
	public String form(Model model){
		AdminNoticeCommand noticeCommand = new AdminNoticeCommand();
		model.addAttribute("noticeCommand", noticeCommand);
		
		return "noticeWrite";
	}
	
	@RequestMapping(value="/cafein_admin/notice/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("noticeCommand") @Valid AdminNoticeCommand noticeCommand, BindingResult result)throws Exception{
		
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
		
		return "redirect:/cafein_admin/notice/List.do";
	}

}

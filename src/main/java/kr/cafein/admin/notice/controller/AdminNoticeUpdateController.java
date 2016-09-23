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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.service.AdminNoticeService;
import kr.cafein.util.FileUtil_adminNotice;

@Controller
@SessionAttributes("noticeCommand")
public class AdminNoticeUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminNoticeService adminNoticeService;
	
	@RequestMapping(value="/cafein_admin/notice/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("seq") int seq, Model model){
		System.out.println(seq);
		AdminNoticeCommand noticeCommand = adminNoticeService.selectNotice(seq);
		System.out.println(noticeCommand);
		model.addAttribute("noticeCommand", noticeCommand);
		
		return "noticeModify";
	}
	
	@RequestMapping(value="/cafein_admin/notice/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("noticeCommand") @Valid AdminNoticeCommand noticeCommand, BindingResult result )throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("noticeCommand : "+noticeCommand);
		}
		
		if(result.hasErrors()){
			return "noticeModify"; 
		}
				
		AdminNoticeCommand notice = null;
		String oldFileName = "";
		
		notice = adminNoticeService.selectNotice(noticeCommand.getNotice_num());
		
		oldFileName = notice.getNotice_img();
		
		if(!noticeCommand.getUpload().isEmpty()){
			//전송된 파일이 있는 경우
			noticeCommand.setNotice_img(FileUtil_adminNotice.rename(noticeCommand.getUpload().getOriginalFilename()));
		}else{
			//전송된 파일이 없는 경우
			noticeCommand.setNotice_img(oldFileName);
		}
		
		adminNoticeService.updateNotice(noticeCommand);
		
		if(!noticeCommand.getUpload().isEmpty()){
			//전송된 파일이 있을 경우
			File file = new File(FileUtil_adminNotice.UPLOAD_PATH+"/"+noticeCommand.getNotice_img());
			noticeCommand.getUpload().transferTo(file);
			if(oldFileName != null){
				//이전 파일 삭제
				FileUtil_adminNotice.removeFile(oldFileName);
			}
		}
		
		return "redirect:/cafein_admin/notice/List.do";
		
	}
	

}

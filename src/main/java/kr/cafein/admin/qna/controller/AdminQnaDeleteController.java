package kr.cafein.admin.qna.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.qna.domain.AdminQnaCommand;
import kr.cafein.admin.qna.domain.AdminQnaLogCommand;
import kr.cafein.admin.qna.service.AdminQnaService;

@Controller
public class AdminQnaDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminQnaService adminQnaService;
	
	@RequestMapping("/cafein_admin/qna/delete.do")
	public String submit(@RequestParam("seq") int seq, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		//=======================log남기기==================================		
		AdminQnaLogCommand adminQnaLogCommand = new AdminQnaLogCommand();
		AdminQnaCommand adminQnaCommnad = adminQnaService.selectQna(seq);
		
		String u_uid = (String)session.getAttribute("u_uid");
		System.out.println("u_uid"+u_uid);
		
		String qa_email = adminQnaCommnad.getQa_email();
		int qa_num = adminQnaCommnad.getQa_num();
		
		
		adminQnaLogCommand.setQa_log_uid(u_uid);
		adminQnaLogCommand.setQa_log_change(1);
		adminQnaLogCommand.setQa_email(qa_email);
		adminQnaLogCommand.setQa_num(qa_num);
		adminQnaLogCommand.setQa_log_message("["+u_uid+"] 사용자가 Qna 게시판에 "+qa_email+"가 작성한"+qa_num+"글을 삭제했습니다.");
		
		System.out.println("로그 : "+adminQnaLogCommand);
		
		adminQnaService.insertAdminQna_Log(adminQnaLogCommand);
		//===============================================================
		
		adminQnaService.delete(seq);
		
		return "redirect:/cafein_admin/qna/List.do";
		
	}

}

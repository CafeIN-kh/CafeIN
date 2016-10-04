package kr.cafein.admin.qna.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;
import kr.cafein.admin.qna.domain.AdminQnaCommand;
import kr.cafein.admin.qna.domain.AdminQnaEmailCommand;
import kr.cafein.admin.qna.domain.AdminQnaLogCommand;
import kr.cafein.admin.qna.service.AdminQnaService;

@Controller
public class AdminQnaDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminQnaService")
	private AdminQnaService adminQnaService;
	
	@RequestMapping(value="/cafein_admin/qna/detail.do", method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("seq") int seq,Model model){
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		AdminQnaCommand qnaCommand = adminQnaService.selectQna(seq);
		AdminQnaEmailCommand emailCommand = new AdminQnaEmailCommand();
		
		model.addAttribute("emailCommand", emailCommand);
		
		ModelAndView mav = new ModelAndView("qnaDetail");
		mav.addObject("qnaCommand", qnaCommand);
		return mav;	
		
	}
	
	@RequestMapping(value="/cafein_admin/qna/detail.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("emailCommand") @Valid AdminQnaEmailCommand email, BindingResult result, HttpSession session2 )throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("QnaEmailCommand : " + email);
		}
		
		int seq=email.getQ_em_num();
		
		 // 메일 관련 정보
        String host = "smtp.gmail.com";
        String username = "cafein.secret@gmail.com";
        String password = "cafein@test1234";
         
        // 메일 내용
        String recipient = email.getQ_em_email();
        String subject = email.getQ_em_subject();
        String body = email.getQ_em_content();
         
        //properties 설정
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // 메일 세션
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // 메일 관련
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // 발송 처리
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();     	
        
        adminQnaService.updateQnaAnswer(seq);
        
		//=======================log남기기==================================		
		AdminQnaLogCommand adminQnaLogCommand = new AdminQnaLogCommand();
		
		String u_uid = (String)session2.getAttribute("u_uid");
		System.out.println("u_uid"+u_uid);
		String qa_email = email.getQ_em_email();
		int qa_num = email.getQ_em_num();
		
		
		adminQnaLogCommand.setQa_log_uid(u_uid);
		adminQnaLogCommand.setQa_log_change(0);
		adminQnaLogCommand.setQa_email(qa_email);
		adminQnaLogCommand.setQa_num(qa_num);
		adminQnaLogCommand.setQa_log_message("["+u_uid+"] 사용자가 Qna 게시판에 "+qa_email+"가 작성한"+qa_num+"글 에 답장했습니다..");
		
		System.out.println("로그 : "+adminQnaLogCommand);
		
		adminQnaService.insertAdminQna_Log(adminQnaLogCommand);
		//===============================================================
        
		
		return "redirect:/cafein_admin/qna/List.do";
	}

}

package kr.cafein.admin.qna.controller;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

import kr.cafein.admin.qna.domain.QnaCommand;
import kr.cafein.admin.qna.domain.QnaEmailCommand;
import kr.cafein.admin.qna.service.QnaService;

@Controller
public class QnaDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="qnaService")
	private QnaService qnaService;
	
	@RequestMapping(value="/cafein_admin/qna/detail.do", method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("seq") int seq,Model model){
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		QnaCommand qnaCommand = qnaService.selectQna(seq);
		QnaEmailCommand emailCommand = new QnaEmailCommand();
		
		model.addAttribute("emailCommand", emailCommand);
		
		ModelAndView mav = new ModelAndView("qnaDetail");
		mav.addObject("qnaCommand", qnaCommand);
		return mav;	
		
	}
	
	@RequestMapping(value="/cafein_admin/qna/detail.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("emailCommand") @Valid QnaEmailCommand email, BindingResult result )throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("QnaEmailCommand : " + email);
		}
		int seq=email.getQ_em_num();
		 // ���� ���� ����
        String host = "smtp.gmail.com";
        String username = "cafein.secret@gmail.com";
        String password = "cafein@test1234";
         
        // ���� ����
        String recipient = email.getQ_em_email();
        String subject = email.getQ_em_subject();
        String body = email.getQ_em_content();
         
        //properties ����
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // ���� ����
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // ���� ����
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // �߼� ó��
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();     	
        
        qnaService.updateQnaAnswer(seq);
        
		
		return "redirect:/cafein_admin/qna/List.do";
	}

}

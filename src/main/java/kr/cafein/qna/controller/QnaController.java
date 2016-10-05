package kr.cafein.qna.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.qna.domain.QnaCommand;
import kr.cafein.qna.service.QnaService;

@Controller
@SessionAttributes("command")
public class QnaController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnaService qnaService;

	//Ŀ�ǵ� ��ü(�ڹٺ�)�ʱ�ȭ
	@ModelAttribute("command")
	private QnaCommand initCommand(){
		return new QnaCommand();
	}
	
	@RequestMapping(value="/cafein_user/qna/qna.do", method = RequestMethod.GET)
	public String qna() {
		
		//�������� ī��Ʈ, ���� ��¥�� ���� �������� �ο� ����(insert)�� ������Ʈ(update)
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
        userCountLogCommand = qnaService.selectQnAUserCountLogByDate();	//���� ��¥�� db�� ����� ��¥�� ��ġ�ϴ� row ã�� 
        if(userCountLogCommand == null) {
        	log.debug("�ڡڡڿ��ó�¥ �������� �ο� �����Ƿ� insert");
        	qnaService.insertQnAUserCountLog();
        }else {
        	log.debug("�ڡڡڿ��ó��� �������� �ο� �����Ƿ� update, ��üī��Ʈ�� ���� ī��Ʈ+1");
        	qnaService.updateQnAUserCountLog();
        }
		
		return "qna";
	}
	
	@RequestMapping(value="/cafein_user/qna/qna.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")	@Valid QnaCommand qnaCommand,
													BindingResult result,
													SessionStatus status) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("qnaCommand : " + qnaCommand);
		}
		
		//qa_answer : ���忩�� ����-0 ������� 1 ������
		qnaCommand.setQa_answer(0);
		
		//�۾���
		qnaService.insert(qnaCommand);
		status.setComplete();
		
		//QnA ��� �α�, umenu_name=0, umenu_log_state=1 ����
		//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���] 5[Qna]
		//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid("Guest");
		userMenuLogCommand.setUmenu_name(5);
		userMenuLogCommand.setUmenu_log_state(0);
		//String u_email = qnaService.selectUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + qnaCommand.getEmail() + "] Guest�� Qna���� ���� ��� �Ͽ����ϴ�."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		qnaService.insertQnaUserLog(userMenuLogCommand);
		log.debug("[QnA �α�] userMenuLogCommand : " + userMenuLogCommand);
	    
		return "redirect:/cafein_user/qna/qna.do";
	}
	
}

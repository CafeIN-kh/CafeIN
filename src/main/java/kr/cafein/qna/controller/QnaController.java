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

	//커맨드 객체(자바빈)초기화
	@ModelAttribute("command")
	private QnaCommand initCommand(){
		return new QnaCommand();
	}
	
	@RequestMapping(value="/cafein_user/qna/qna.do", method = RequestMethod.GET)
	public String qna() {
		
		//페이지뷰 카운트, 오늘 날짜에 따라 페이지뷰 로우 생성(insert)과 업데이트(update)
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
        userCountLogCommand = qnaService.selectQnAUserCountLogByDate();	//오늘 날짜와 db에 저장된 날짜가 일치하는 row 찾기 
        if(userCountLogCommand == null) {
        	log.debug("★★★오늘날짜 페이지뷰 로우 없으므로 insert");
        	qnaService.insertQnAUserCountLog();
        }else {
        	log.debug("★★★오늘날자 페이지뷰 로우 있으므로 update, 전체카운트와 매인 카운트+1");
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
		
		//qa_answer : 답장여부 고정-0 답장안함 1 답장함
		qnaCommand.setQa_answer(0);
		
		//글쓰기
		qnaService.insert(qnaCommand);
		status.setComplete();
		
		//QnA 등록 로그, umenu_name=0, umenu_log_state=1 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글] 5[Qna]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid("Guest");
		userMenuLogCommand.setUmenu_name(5);
		userMenuLogCommand.setUmenu_log_state(0);
		//String u_email = qnaService.selectUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + qnaCommand.getEmail() + "] Guest가 Qna에서 글을 등록 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		qnaService.insertQnaUserLog(userMenuLogCommand);
		log.debug("[QnA 로그] userMenuLogCommand : " + userMenuLogCommand);
	    
		return "redirect:/cafein_user/qna/qna.do";
	}
	
}

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
		System.out.println("efefef");
		return "qna";
	}
	
	@RequestMapping(value="/cafein_user/qna/qna.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	@Valid QnaCommand qnaCommand,BindingResult result,SessionStatus status)
			throws Exception{

		if(log.isDebugEnabled()){
			log.debug("qnaCommand : " + qnaCommand);
		}
		//글쓰기
		qnaService.insert(qnaCommand);
		status.setComplete();
	    
		return "qna";
	}
	
}

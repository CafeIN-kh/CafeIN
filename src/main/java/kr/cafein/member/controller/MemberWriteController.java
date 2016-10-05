package kr.cafein.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;
import kr.cafein.member.service.MemberService;


@Controller
public class MemberWriteController {

	private Logger log= Logger.getLogger(this.getClass());
	
	//@Resource(name="memberService")
	//아래와 같은 이름이명 name 명시 안해줘도 됨
	@Resource
	private MemberService memberService;
	
	//커맨드 객체(자바빈) 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/cafein_user/user/register.do",method=RequestMethod.GET)
	public String form() {
		//타일스 설정
		return "register";
	}
	
	@RequestMapping(value="/cafein_user/user/register.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		
		
		if(result.hasFieldErrors("u_email") || result.hasFieldErrors("u_password")||result.hasFieldErrors("u_name") || result.hasFieldErrors("Confirmpassword")) {
			log.debug("회원등록 실패! 리턴 ");
			return form();
			
		}
		
		
		if(!memberCommand.isConfirmPasswd()){
			
			log.debug("비번 불일치!");
			result.rejectValue("u_password", "messageCode","비밀번호와 비밀번호 확인이 일치하지 않습니다");
			
			return form();
		}
		
		
		log.debug("회원등록 문제없음! 등록시작 ");
		//회원 가입
		memberService.insert(memberCommand);
		
		//회원가입   로그, u_log_change=0 고정
		//u_log_change - 0[회원가입] 1[로그인] 2[수정] 3[탈퇴]
		String u_email = memberCommand.getU_email();
		String u_uid = memberService.selectUid(u_email);
		UserLogCommand userLogCommand = new UserLogCommand();
		userLogCommand.setU_uid(u_uid);
		userLogCommand.setU_log_change(0);
		String logMessage = "";
		logMessage = "[" + u_email + "] 사용자가 회원가입을 하였습니다."; 
		userLogCommand.setU_log_message(logMessage);
		memberService.insertMemberUserLog(userLogCommand);
		log.debug("[회원가입 로그] userLogCommand : " + userLogCommand);
		
		return "redirect:/cafein_user/main/main.do";
	}
	
}

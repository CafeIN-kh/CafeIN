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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

@Controller
public class MemberLeaveTxtController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/cafein_user/mypage/mypage_user_leave.do",method=RequestMethod.GET)
	public String form(){
		
		//System.out.println("탈퇴 요청 페이지 mypage_user_leave.do 진입 username : " + username);
		//탈퇴사유 세션에 넣어주고 탈퇴하면 세션 삭제
		//session.setAttribute("username", username);
		
		return "mypage_user_leave";
	}
	
	@RequestMapping(value="/cafein_user/mypage/mypage_user_leave.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid MemberCommand memberCommand,
						 //@RequestParam String username,
						 BindingResult result,
						 SessionStatus status,
						 HttpSession session){
			
		log.debug("탈퇴 요청 페이지 mypage_user_leave.do 진입  memberCommand : " + memberCommand);
		
		return "mypage_user_leave_check";
		//return "redirect:/cafein_user/mypage/mypage_user_leave_check.do?username=" + username;
		
	
	}
	
}

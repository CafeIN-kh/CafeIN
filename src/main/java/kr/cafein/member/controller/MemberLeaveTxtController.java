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
		
		//System.out.println("Ż�� ��û ������ mypage_user_leave.do ���� username : " + username);
		//Ż����� ���ǿ� �־��ְ� Ż���ϸ� ���� ����
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
			
		log.debug("Ż�� ��û ������ mypage_user_leave.do ����  memberCommand : " + memberCommand);
		
		return "mypage_user_leave_check";
		//return "redirect:/cafein_user/mypage/mypage_user_leave_check.do?username=" + username;
		
	
	}
	
}

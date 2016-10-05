package kr.cafein.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;
import kr.cafein.member.service.MemberService;

@Controller
public class MemberDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//커맨드 객체(자바빈) 초기화
	@ModelAttribute("command")
	private MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/cafein_user/mypage/mypage_user_leave_check.do",method=RequestMethod.GET)
	public String form(){
		
		return "mypage_user_leave_check";
	}
	@RequestMapping(value="/cafein_user/mypage/mypage_user_leave_check.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid MemberCommand memberCommand,
						 //@ModelAttribute String username,
						 BindingResult result,
						 SessionStatus status,
						 HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("memberCommand : " + memberCommand);
		}
		
		//System.out.println("탈퇴 요청 페이지 mypage_user_leave.do 진입 username : " + username);
		//탈퇴사유 세션에 넣어주고 탈퇴하면 세션 삭제
		//session.setAttribute("username", username);
		
		//passwd 필드의 에러만 체크
		if(result.hasFieldErrors("u_password")){
			return "mypage_user_leave_check";
		}
		
		

		String id = (String)session.getAttribute("u_uid");
		log.debug("memberDelete__check에서 가져온 uid : " + id);
		
		
		try{
			MemberCommand member = memberService.selectMember(id);
			boolean check = false;
			
			if(member !=null){
				// 비밀번호 체크
				check = member.isCheckedPasswd(memberCommand.getU_password());
			
				// 로그아웃
				
			}
			if(check){
				//String username = memberCommand.getUsername();
				//String username = (String)session.getAttribute("username");
				//username = (String)session.getAttribute("username");
				//System.out.println("username" + username);
				//회원탈퇴  로그, u_log_change=3 고정
				//u_log_change - 0[회원가입] 1[로그인] 2[수정] 3[탈퇴]
				String u_uid = (String)session.getAttribute("u_uid");
				String u_email = memberService.selectMemberUserLogByUid(u_uid).getU_email();
				UserLogCommand userLogCommand = new UserLogCommand();
				userLogCommand.setU_uid(u_uid);
				userLogCommand.setU_log_change(3);
				String logMessage = "";
				logMessage = "[" + u_email + "] 사용자가 회원탈퇴를 하였습니다."; 
				//logMessage = "[" + u_email + "] 사용자가 회원탈퇴를 하였습니다. [탈퇴사유: " + username + "]"; 
				userLogCommand.setU_log_message(logMessage);
				memberService.insertMemberUserLog(userLogCommand);
				log.debug("[회원탈퇴 로그] userLogCommand : " + userLogCommand);

	            // 인증성공, 회원정보 삭제
	            memberService.deleteLevel(id);  // u_level=3 로 변경  _ 정지 계정
	            log.debug("회원정지 성공!! ");
				
				// 로그아웃, 세션삭제
				session.invalidate();
				return "redirect:/cafein_user/main/main.do";
			}else{
				// 인증실패
				throw new Exception();
			}
			
		}catch(Exception e){
			
			result.rejectValue("u_password", "invalidPassword");
			
			return "mypage_user_leave_check";
		}
		
	
	}
	
}

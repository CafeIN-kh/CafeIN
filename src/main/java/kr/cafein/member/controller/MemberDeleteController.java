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
import kr.cafein.member.service.MemberService;

@Controller
public class MemberDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
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
						 BindingResult result,
						 SessionStatus status,
						 HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("memberCommand : " + memberCommand);
		}
		
		//passwd �ʵ��� ������ üũ
		if(result.hasFieldErrors("u_password")){
			return "mypage_user_leave_check";
		}
		
		

		String id = (String)session.getAttribute("u_uid");
		log.debug("memberDelete__check���� ������ uid : " + id);
		
		
		try{
			MemberCommand member = memberService.selectMember(id);
			boolean check = false;
			
			if(member !=null){
				// ��й�ȣ üũ
				check = member.isCheckedPasswd(memberCommand.getU_password());
			
				// �α׾ƿ�
				
			}
			if(check){
				// ��������, ȸ������ ����
				memberService.delete(id);
				log.debug("ȸ��Ż�� ����!! ");
				// �α׾ƿ�
				session.invalidate();
				return "redirect:/cafein_user/main/main.do";
			}else{
				// ��������
				throw new Exception();
			}
			
		}catch(Exception e){
			
			result.rejectValue("u_password", "invalidPassword");
			
			return "mypage_user_leave_check";
		}
		
	
	}
	
}

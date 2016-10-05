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
@SessionAttributes("command")
public class MemberUpdateController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/cafein_user/mypage/mypage_user_modify.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		// Model -  �信 ������ ��ü ������ ��� �ִ� Model�� �����Ѵ�. �̶� �� �̸��� ��û URL�κ��� �����ȴ�.
		
		String id = (String)session.getAttribute("u_uid");
		
		MemberCommand member = memberService.selectMember(id);
		log.debug("update������ member : " + member);
		//�𵨿� ����� ������ @SessionAttribute("command")�� ���� ���ǿ� ����
		//jsp���� command��� ������ �� ����
		model.addAttribute("command",member);
		
		return "mypage_user_modify";
	}
	
	@RequestMapping(value="/cafein_user/mypage/mypage_user_modify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result, SessionStatus status, HttpSession session) {
		
		// SessionStatus  - �� ó���� �Ϸ� ������ ó���ϱ� ���� ���. @SessionAttribute�� ����� session �Ӽ��� �����ϵ��� �̺�Ʈ�� �߻���Ų��.
		
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		
		if(result.hasErrors()) {
			return "mypage_user_modify";
		}
		
		if(!memberCommand.isConfirmPasswd()){
			
			log.debug("��� ����ġ!");
			result.rejectValue("u_password", "messageCode","��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�");
			
			return "mypage_user_modify";
		}
		
		
		//ȸ����������
		memberService.update(memberCommand);
		//session�� ����� model�� �����ϴ� �̺�Ʈ �߻�
		status.setComplete();
		
		//ȸ������   �α�, u_log_change=2 ����
		//u_log_change - 0[ȸ������] 1[�α���] 2[����] 3[Ż��]
		String u_uid = (String)session.getAttribute("u_uid");
		String u_email = memberService.selectMemberUserLogByUid(u_uid).getU_email();
		UserLogCommand userLogCommand = new UserLogCommand();
		userLogCommand.setU_uid(u_uid);
		userLogCommand.setU_log_change(2);
		String logMessage = "";
		logMessage = "[" + u_email + "] ����ڰ� ȸ�������� �Ͽ����ϴ�."; 
		userLogCommand.setU_log_message(logMessage);
		memberService.insertMemberUserLog(userLogCommand);
		log.debug("[ȸ������ �α�] userLogCommand : " + userLogCommand);
		
		return "redirect:/cafein_user/main/main.do";
	}
}

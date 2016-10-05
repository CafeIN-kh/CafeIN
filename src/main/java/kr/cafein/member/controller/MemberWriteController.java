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
	//�Ʒ��� ���� �̸��̸� name ��� �����൵ ��
	@Resource
	private MemberService memberService;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/cafein_user/user/register.do",method=RequestMethod.GET)
	public String form() {
		//Ÿ�Ͻ� ����
		return "register";
	}
	
	@RequestMapping(value="/cafein_user/user/register.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		
		
		if(result.hasFieldErrors("u_email") || result.hasFieldErrors("u_password")||result.hasFieldErrors("u_name") || result.hasFieldErrors("Confirmpassword")) {
			log.debug("ȸ����� ����! ���� ");
			return form();
			
		}
		
		
		if(!memberCommand.isConfirmPasswd()){
			
			log.debug("��� ����ġ!");
			result.rejectValue("u_password", "messageCode","��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�");
			
			return form();
		}
		
		
		log.debug("ȸ����� ��������! ��Ͻ��� ");
		//ȸ�� ����
		memberService.insert(memberCommand);
		
		//ȸ������   �α�, u_log_change=0 ����
		//u_log_change - 0[ȸ������] 1[�α���] 2[����] 3[Ż��]
		String u_email = memberCommand.getU_email();
		String u_uid = memberService.selectUid(u_email);
		UserLogCommand userLogCommand = new UserLogCommand();
		userLogCommand.setU_uid(u_uid);
		userLogCommand.setU_log_change(0);
		String logMessage = "";
		logMessage = "[" + u_email + "] ����ڰ� ȸ�������� �Ͽ����ϴ�."; 
		userLogCommand.setU_log_message(logMessage);
		memberService.insertMemberUserLog(userLogCommand);
		log.debug("[ȸ������ �α�] userLogCommand : " + userLogCommand);
		
		return "redirect:/cafein_user/main/main.do";
	}
	
}

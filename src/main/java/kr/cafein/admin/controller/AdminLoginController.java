package kr.cafein.admin.controller;

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
import kr.cafein.member.service.MemberService;

@Controller
public class AdminLoginController {

private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("command")
	private MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/cafein_admin/member/adminLogin.do",method=RequestMethod.GET)
	public String form() {
		return "admin_login";
	}
	
	@RequestMapping(value="/cafein_admin/member/adminLogin.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		
		//id�� passwd �ʵ常 üũ
		if(result.hasFieldErrors("u_email") || result.hasFieldErrors("u_password")) {
			
			return form();
		}
		
	
		
		String uid = memberService.selectUid(memberCommand.getU_email());
		log.debug("������ uid �� : " + uid);
		
		if(uid == null || uid.isEmpty()){
			result.rejectValue("u_email", "NonexistentId"); 
			
			return form();
		}
		
		//�α��� üũ (id �Ǵ� ��й�ȣ ��ġ ���� üũ)
		try {
			
			MemberCommand member = memberService.selectMember(uid);
		
			
			boolean check = false;
			
			if(member != null) {
				
				//��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(memberCommand.getU_password());
			
			}
			
			if(check) {
				
				if(member.getU_level()!=2){ // ������ ����(2)�� �ƴϸ� �α��� ���� 
					result.rejectValue("u_password", "invalidId");
					
					return form();
				}
				
				
				//��������, �α��� ó��
				session.setAttribute("u_uid", member.getU_uid());
				session.setAttribute("u_level", member.getU_level());
				log.debug("�������� ");
				return "redirect:/admin/main.do";
			}else {
				//��������
				log.debug("��������");
				throw new Exception();
			}
			
		} catch(Exception e) {
			//���� ���з� �� ȣ��
			result.rejectValue("u_password", "invalidPassword");
			
			return form();
		}
		
	}
	
}

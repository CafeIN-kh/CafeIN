package kr.cafein.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

@Controller //@Controller��°� �������� ���� �� ����
public class MemberLoginController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ _�ؾ߸� command�� ã�� �� ����
	@ModelAttribute("command")
	private MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/cafein_user/user/login.do",method=RequestMethod.GET) //submit�� ó�� ȭ��(form) �ε�
	public String form() {
		return "login";
	}
	
	@RequestMapping(value="/cafein_user/user/login.do",method=RequestMethod.POST) // submit������
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result, HttpSession session) {
															// command��� �̸��� �ڹٺ� Ŭ������ ������ MemberCommand�� �Ӽ���� �ϳ��� ��Ī,���� �� 
															// BindingResult��  memberCommand�� �ش� �Ӽ� �ʵ��� @NotEmpty�� ���� ����� ������
														 	// HttpSession �� �α��� �������� ������ �����ϱ� ���� ���
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
			// ������ command �� ���� Ȯ��
		}
		
		//id�� passwd �ʵ常 üũ -> ������ ������ �ٽ� form ���� �������� ���� �޽����� error ������ ǥ��
		if(result.hasFieldErrors("u_email") || result.hasFieldErrors("u_password")) {
			
			return form();
		}
		
	
		// memberService�� �ִ� selectUid �޼��带 �̿��� ������(����ڰ� �Է���) �̸��� �� ȸ���� u_uid(seq��)�� ������
		String uid = memberService.selectUid(memberCommand.getU_email());
		log.debug("������ uid �� : " + uid);
		
		if(uid == null || uid.isEmpty()){
			result.rejectValue("u_password", "NonexistentId"); // �������� �ʴ� ���̵�(�̸���)
			
			return form();
		}
		
		
		
		//�α��� üũ (id �Ǵ� ��й�ȣ ��ġ ���� üũ)
		try {
			
			MemberCommand member = memberService.selectMember(uid); // ������ u_uid������ �ش� ȸ���� ��ü ������ ������
		
			
			boolean check = false;
			
			if(member != null) { // ������ ȸ���� ������ null �̸� �������� �ʴ� ���̵�
								// null �� �ƴ϶�� (������ �ִٸ� ) ��й�ȣ ��ġ���� üũ
				//��й�ȣ ��ġ ���� üũ
				check = member.isCheckedPasswd(memberCommand.getU_password());
			}
			
			if(member.getU_level() ==2){
				result.rejectValue("u_email", "messageCode", "ȸ���� �̸����� ����� �ּ���.");
					return form();
			}
			
			if(check) {
				//��������, �α��� ó�� ���ǿ� u_uid(seq)���� ���� ����
				session.setAttribute("u_uid", member.getU_uid());
				session.setAttribute("u_level", member.getU_level());
				session.setAttribute("u_name", member.getU_name());
				log.debug("�������� ");
				return "redirect:/cafein_user/main/main.do"; // ���������ϸ� ��������
			}else {
				//��������
				log.debug("��������");
				throw new Exception(); // ���������ϸ� ���ܸ� ������
			}
			
		} catch(Exception e) {
			//���� ���з� �� ȣ��
			result.reject("invalidIdOrPassword"); // ���ܸ� ��Ƽ� src/main/resources/messages/validation.properties���ִ�
												// invalidIdOrPassword �޽����� result ����� ������. error�� ǥ��
			
			return form();
		}
		
	}
	
}




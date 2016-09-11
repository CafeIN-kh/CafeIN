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
import kr.cafein.member.service.MemberService;

@Controller
public class MemberModifyCheckPasswordController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;

	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ
	@ModelAttribute("command")
	private MemberCommand initCommand() {
		return new MemberCommand();
	}


	@RequestMapping(value = "/cafein_user/mypage/mypage_user_modify_check.do", method = RequestMethod.GET)
	public String form() {
		// Ÿ�Ͻ� ����
		return "mypage_user_modify_check";
	}

	@RequestMapping(value = "/cafein_user/mypage/mypage_user_modify_check.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result,
			HttpSession session) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}

		if (result.hasFieldErrors("confirmpassword")) {
			log.debug("ȸ������ ���üũ ����! ���� ");
			return form();

		}

		String id = (String)session.getAttribute("u_uid");
		log.debug("check���� ������ uid : " + id);
		
		
		try {
			

			MemberCommand member = memberService.selectMember(memberCommand.getU_uid());

			if (!memberCommand.getConfirmpassword().equals(member.getU_password())) {
				log.debug("��� ����ġ!");
				result.rejectValue("confirmpassword", "messageCode", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return form();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/cafein_user/mypage/mypage_user_modify.do";
	}

}

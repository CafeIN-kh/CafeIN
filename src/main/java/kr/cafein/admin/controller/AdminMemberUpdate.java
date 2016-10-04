package kr.cafein.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

@Controller
public class AdminMemberUpdate {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	
	//Ŀ�ǵ� ��ü(�ڹٺ�) �ʱ�ȭ _�ؾ߸� command�� ã�� �� ����
		@ModelAttribute("command")
		private MemberCommand initCommand() {
			return new MemberCommand();
		}
		
	
	
	// ������ ȸ������ ���� ��� ajax (ó�� �� ������)
	@RequestMapping(value="/cafein_admin/member/admin_memberModify.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> process(@RequestParam("u_email") String u_email) {
		
		
		  if(log.isDebugEnabled()) {
		         
		         log.debug("u_email" + u_email);
		      }
		
		  
		  
		  HashMap<String,Object> map = new HashMap<String,Object>();
	      
	      map.put("u_email",u_email);
	      
		  
	  	String uid = memberService.selectUid(u_email);  // �̸����� �̿��� ȸ�� seq(u_uid) ã�ƿ�
		MemberCommand member = memberService.selectMember(uid); // seq (u_uid) �� ȸ������ ã�ƿ�
		log.debug("AdminMemberUpdate������ member : " + member);
		
		   Map<String,Object> mapJson = new HashMap<String,Object> ();
		      mapJson.put("u_email", member.getU_email());
		      mapJson.put("u_name", member.getU_name());
		      mapJson.put("u_password", member.getU_password());
		      mapJson.put("u_level", member.getU_level());
		      
		      
		      return mapJson;	
	}
	
	
	@RequestMapping(value="/cafein_admin/member/admin_memberModify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute @Valid MemberCommand memberCommand) {
		
		
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		
		//ȸ����������
		memberService.update(memberCommand);
		
		return "redirect:/cafein_admin/member/memberlist.do";
	}
}
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
	
	
	//커맨드 객체(자바빈) 초기화 _해야만 command를 찾을 수 있음
		@ModelAttribute("command")
		private MemberCommand initCommand() {
			return new MemberCommand();
		}
		
	
	
	// 관리자 회원정보 수정 모달 ajax (처음 값 보내기)
	@RequestMapping(value="/cafein_admin/member/admin_memberModify.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> process(@RequestParam("u_email") String u_email) {
		
		
		  if(log.isDebugEnabled()) {
		         
		         log.debug("u_email" + u_email);
		      }
		
		  
		  
		  HashMap<String,Object> map = new HashMap<String,Object>();
	      
	      map.put("u_email",u_email);
	      
		  
	  	String uid = memberService.selectUid(u_email);  // 이메일을 이용해 회원 seq(u_uid) 찾아옴
		MemberCommand member = memberService.selectMember(uid); // seq (u_uid) 로 회원정보 찾아옴
		log.debug("AdminMemberUpdate에서의 member : " + member);
		
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
		
		//회원정보수정
		memberService.update(memberCommand);
		
		return "redirect:/cafein_admin/member/memberlist.do";
	}
}
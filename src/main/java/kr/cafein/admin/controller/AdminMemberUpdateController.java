package kr.cafein.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.service.MemberService;

@Controller
@SessionAttributes("command")  // u_uid 값이 꼭 있어야 함
public class AdminMemberUpdateController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	

	// 관리자 회원정보 수정 모달 ajax (처음 값 보내기)
	@RequestMapping(value="/cafein_admin/member/admin_memberModify.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> process(@RequestParam("u_email") String u_email,Model model) {  // ajax 로 emali 값을 받으면 나머지 값 구하가
		
		
		  if(log.isDebugEnabled()) {
		         
		         log.debug("u_email" + u_email);
		      }
		
		  
		  
		  HashMap<String,Object> map = new HashMap<String,Object>();
	      
	      map.put("u_email",u_email);
	      
		  
	  	String uid = memberService.selectUid(u_email);  // 이메일을 이용해 회원 seq(u_uid) 찾아옴
		MemberCommand member = memberService.selectMember(uid); // seq (u_uid) 로 회원정보 찾아옴
		
		model.addAttribute("command", member);  // session 에 구해온 u_uid 값을 유지시키기 위해 만듬.  
													// -> 밑의 post에 u_uid 가 전송되지 않기 때문에! session 에 값 안 유지시키면 에러남!!
		
		log.debug("get에서의 memberCommand : " + member);
		
		   Map<String,Object> mapJson = new HashMap<String,Object> ();
		      mapJson.put("u_email", member.getU_email());
		      mapJson.put("u_name", member.getU_name());
		      mapJson.put("u_password", member.getU_password());
		      mapJson.put("u_level", member.getU_level());
		      
		      
		      return mapJson;	
	}
	
	
	@RequestMapping(value="/cafein_admin/member/admin_memberModify.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, SessionStatus status) {
	
		
		if(log.isDebugEnabled()) {
			log.debug("Post에서의 memberCommand : " + memberCommand);
		}
		
		//회원정보수정
		memberService.update(memberCommand);
		status.setComplete(); // 저장된 session 삭제

		   Map<String,Object> map = new HashMap<String,Object> ();
		      map.put("result", "success");
		      return map;
		
		      
	}
}
package kr.cafein.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.member.service.MemberService;

@Controller
public class AdminMemberDeleteController {

	
	
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	

	// 관리자 회원정보 수정 모달 ajax (처음 값 보내기)
	@RequestMapping(value="/cafein_admin/member/admin_memberDelete.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> process(@RequestParam("u_email") String u_email) {  // ajax 로 emali 값을 받으면 나머지 값 구하가
		
		
		  if(log.isDebugEnabled()) {
		         
		         log.debug("u_email" + u_email);
		      }
		
		  
		  
		  HashMap<String,Object> map = new HashMap<String,Object>();
	      
	      map.put("u_email",u_email);
	      
		  
	  	String uid = memberService.selectUid(u_email);  // 이메일을 이용해 회원 seq(u_uid) 찾아옴
		//memberService.deleteAll(uid);
		
	    Map<String,Object> mapJson = new HashMap<String,Object> ();
	    map.put("result", "success");
	      
	      return mapJson;
		      
		   
	}
	
	
}

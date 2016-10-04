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
	

	// ������ ȸ������ ���� ��� ajax (ó�� �� ������)
	@RequestMapping(value="/cafein_admin/member/admin_memberDelete.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> process(@RequestParam("u_email") String u_email) {  // ajax �� emali ���� ������ ������ �� ���ϰ�
		
		
		  if(log.isDebugEnabled()) {
		         
		         log.debug("u_email" + u_email);
		      }
		
		  
		  
		  HashMap<String,Object> map = new HashMap<String,Object>();
	      
	      map.put("u_email",u_email);
	      
		  
	  	String uid = memberService.selectUid(u_email);  // �̸����� �̿��� ȸ�� seq(u_uid) ã�ƿ�
		//memberService.deleteAll(uid);
		
	    Map<String,Object> mapJson = new HashMap<String,Object> ();
	    map.put("result", "success");
	      
	      return mapJson;
		      
		   
	}
	
	
}

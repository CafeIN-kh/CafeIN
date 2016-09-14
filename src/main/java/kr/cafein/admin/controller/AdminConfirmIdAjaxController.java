package kr.cafein.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.member.service.MemberService;

@Controller
public class AdminConfirmIdAjaxController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	
	/*
	 * 클라이언트에 JSON 형식의 값을 응답할 때 유용하다. 
	 * 메서드에 @ResponseBody를 적용한 후 문자열을 리턴하면 그 값은 HTTP response header가 아니라 HTTP response body에 쓰여진다. 
	 * 객체를 넘길경우 스프링에 내장된 JACKSON에 의해 문자열로 변환될 것이다.

또한 @ResponseBody가 적용된 컨트롤러는 context에 설정된 resolver를 무시한다.
	 * */
	
	@RequestMapping("/admin/confirmId.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("u_email") String u_email){
		
		if(log.isDebugEnabled()){
			log.debug("u_email : " + u_email);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		log.debug("map 확인중 ");

		
		try{
		
			String uid = memberService.selectUid(u_email);
			if(uid != null){

				log.debug("가져온 uid 값 : " + uid);
				
				// 아이디 중복
				map.put("result", "idDuplicated");
			}else{
				// 아이디 미 중복
				log.debug("u_uid값 없음. 가입 가능!");
				map.put("result", "idNotFound");
			}
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}

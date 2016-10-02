package kr.cafein.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.admin.service.DeclaredService;
import kr.cafein.member.service.MemberService;

@Controller
public class D_selectPickerAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private DeclaredService declaredService;
	
	
	/*
	 * 클라이언트에 JSON 형식의 값을 응답할 때 유용하다. 
	 * 메서드에 @ResponseBody를 적용한 후 문자열을 리턴하면 그 값은 HTTP response header가 아니라 HTTP response body에 쓰여진다. 
	 * 객체를 넘길경우 스프링에 내장된 JACKSON에 의해 문자열로 변환될 것이다.

또한 @ResponseBody가 적용된 컨트롤러는 context에 설정된 resolver를 무시한다.
	 * */
	
	@RequestMapping("/admin/d_selectPickerAjax.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("d_seq") int d_seq,
										@RequestParam("d_state") int d_state) throws Exception {
		
		if(log.isDebugEnabled()){
			log.debug("d_seq :" + d_seq +", d_state :" + d_state);
		}
		
		Map<String,String> map = new HashMap<String,String>();  //ajax return map
		log.debug("map 확인중 ");

		
		 HashMap<String,Object> mapM = new HashMap<String,Object>(); // mapper send map
	      
		 mapM.put("d_seq", d_seq);
		 mapM.put("d_state", d_state);
		 
		try{
			declaredService.updateState(mapM);
			log.debug("처리상태 변경 성공! ");
			
			map.put("result", "success");
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}

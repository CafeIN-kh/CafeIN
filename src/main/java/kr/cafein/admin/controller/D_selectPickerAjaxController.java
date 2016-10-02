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
	 * Ŭ���̾�Ʈ�� JSON ������ ���� ������ �� �����ϴ�. 
	 * �޼��忡 @ResponseBody�� ������ �� ���ڿ��� �����ϸ� �� ���� HTTP response header�� �ƴ϶� HTTP response body�� ��������. 
	 * ��ü�� �ѱ��� �������� ����� JACKSON�� ���� ���ڿ��� ��ȯ�� ���̴�.

���� @ResponseBody�� ����� ��Ʈ�ѷ��� context�� ������ resolver�� �����Ѵ�.
	 * */
	
	@RequestMapping("/admin/d_selectPickerAjax.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("d_seq") int d_seq,
										@RequestParam("d_state") int d_state) throws Exception {
		
		if(log.isDebugEnabled()){
			log.debug("d_seq :" + d_seq +", d_state :" + d_state);
		}
		
		Map<String,String> map = new HashMap<String,String>();  //ajax return map
		log.debug("map Ȯ���� ");

		
		 HashMap<String,Object> mapM = new HashMap<String,Object>(); // mapper send map
	      
		 mapM.put("d_seq", d_seq);
		 mapM.put("d_state", d_state);
		 
		try{
			declaredService.updateState(mapM);
			log.debug("ó������ ���� ����! ");
			
			map.put("result", "success");
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}

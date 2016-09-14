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
	 * Ŭ���̾�Ʈ�� JSON ������ ���� ������ �� �����ϴ�. 
	 * �޼��忡 @ResponseBody�� ������ �� ���ڿ��� �����ϸ� �� ���� HTTP response header�� �ƴ϶� HTTP response body�� ��������. 
	 * ��ü�� �ѱ��� �������� ����� JACKSON�� ���� ���ڿ��� ��ȯ�� ���̴�.

���� @ResponseBody�� ����� ��Ʈ�ѷ��� context�� ������ resolver�� �����Ѵ�.
	 * */
	
	@RequestMapping("/admin/confirmId.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("u_email") String u_email){
		
		if(log.isDebugEnabled()){
			log.debug("u_email : " + u_email);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		log.debug("map Ȯ���� ");

		
		try{
		
			String uid = memberService.selectUid(u_email);
			if(uid != null){

				log.debug("������ uid �� : " + uid);
				
				// ���̵� �ߺ�
				map.put("result", "idDuplicated");
			}else{
				// ���̵� �� �ߺ�
				log.debug("u_uid�� ����. ���� ����!");
				map.put("result", "idNotFound");
			}
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}

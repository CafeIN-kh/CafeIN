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

@Controller
public class D_commentAjaxController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private DeclaredService declaredService;
	
	
	@RequestMapping("/cafein_admin/member/d_commentAjax.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("d_seq") int d_seq,
										@RequestParam("d_comment") String d_comment) throws Exception {
		
		if(log.isDebugEnabled()){
			log.debug("d_seq :" + d_seq +", d_comment :" + d_comment);
		}
		
		Map<String,String> map = new HashMap<String,String>();  //ajax return map
		log.debug("map 확인중 ");

		
		 HashMap<String,Object> mapM = new HashMap<String,Object>(); // mapper send map
	      
		 mapM.put("d_seq", d_seq);
		 mapM.put("d_comment", d_comment);
		 
		try{
			declaredService.updateComment(mapM);
			log.debug("코멘트 변경 성공! ");
			
			map.put("result", "success");
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
		return map;
	}
}

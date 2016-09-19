package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.DeclaredCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.service.PCafeService;

@Controller
public class PCafeDetailReplyDeclaredController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	//신고 모달창에 신고자/피신고자 정보 넘겨주기
	@RequestMapping("/cafein_user/private/private_detailReplyDeclared_ajax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam("preply_num") int preply_num
									  ,@RequestParam("u_uid") String u_uid_declared
									  ,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("신고당한 댓글 preply_num : " + preply_num);
			log.debug("신고당한 u_id : " + u_uid_declared);
		} 
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			//현재 로그인한 사용자의 u_uid
			String u_uid = (String) session.getAttribute("u_uid");
			
			if(u_uid == null) {
				map.put("result", "logout");
				
				
			}else {
				
				//신고당한 댓글의 시퀀스로 댓글 정보 모두 select 해오기
				PCafeReplyCommand declaredReply = pcafeService.selectDeclaredReply(preply_num);
				map.put("declaredReply", declaredReply);
				
				//신고당한 회원의 닉네임을 알기위해 select
				if(!u_uid_declared.equals("Guest")) {
					MemberCommand declaredMember = pcafeService.selectDeclaredMember(u_uid_declared);
					map.put("declaredMember_u_uid", declaredMember.getU_uid());
					map.put("declaredMember_u_name", declaredMember.getU_name());
				}else {
					map.put("declaredMember_u_uid", "Guest");
					map.put("declaredMember_u_name", "Guest");
				}

				map.put("result","success");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}
		
		return map;
	}
	
	//댓글 신고 insert
	@RequestMapping(value="/cafein_user/private/private_detailReplyDeclaredRegister.do", method=RequestMethod.POST)
	//@ResponseBody 써주면 에이작스로 인식해서 string 형태로 return 시킴
	public String submit(@ModelAttribute DeclaredCommand declaredCommand,
						 int pcafe_num,
						 HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("declaredCommand : " + declaredCommand);
			log.debug("pcafe_num : " + pcafe_num);
		}
		System.out.println("private_detailReplyDeclaredRegister_ajax 진입");
		
		//d_state[처리상태] = 0.처리 전, 1.처리 중,2.처리 완료, 3처리 보류, 4. 처리 취소
		int d_state = 0;
		declaredCommand.setD_state(d_state);
		
		//댓글 신고
		pcafeService.insertDeclaredReply(declaredCommand);
		
		//login과 js를 같이 쓰고 있는데  login에서 page_registration.js 에이작스를 안쓰므로 신고도 map으로 return 시키지 않음
		return "redirect:/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num;
	}

}

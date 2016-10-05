package kr.cafein.customizing.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomizingDetailReplyDeclaredController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private CustomizingDetailService customizingDetailService;
	private CustomizingDetailReplyCommand customizingDetailReplyCommand;
	private CustomizingDetailController customizingDetailController;
	private FranchiseCommand franchiseCommand;

	//신고 모달창에 신고자/피신고자 정보 넘겨주기
	@RequestMapping("/cafein_user/customizing/customizing_detailReplyDeclared_ajax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam("creply_num") int creply_num,
			@RequestParam("u_uid") String u_uid_declared,
			@RequestParam("custom_num") int custom_num,
			@RequestParam("franchise_num") int franchise_num,
			HttpSession session) {

		log.debug("★★★  댓글 신고 컨트롤러 진입 *");

		if(log.isDebugEnabled()) {
			log.debug("creply_num : " + creply_num);
			log.debug("u_id : " + u_uid_declared);
			log.debug("custom_num : " + custom_num);
			log.debug("franchise_num : " + franchise_num);
		} 

		Map<String,Object> map = new HashMap<String,Object>();

		try {
			//현재 로그인한 사용자의 u_uid
			//String u_uid = (String) session.getAttribute("u_uid");

			/*
			 * 로그인 연결 안되어 있으므로
			 * 
			 * if(u_uid_declared == null) {
	            map.put("result", "logout");


	         }else {*/

			//신고당한 댓글의 시퀀스로 댓글 정보 모두 select 해오기
			CustomizingDetailReplyCommand declaredCustomizingReply = customizingDetailService.selectDeclaredCustomizingReply(creply_num);
			map.put("declaredCustomizingReply", declaredCustomizingReply);

			//신고당한 회원의 닉네임을 알기위해 select
			if(!u_uid_declared.equals("Guest")) {
				MemberCommand declaredMember = customizingDetailService.selectDeclaredMember(u_uid_declared);
				map.put("declaredMember_u_uid", declaredMember.getU_uid());
				map.put("declaredMember_u_name", declaredMember.getU_name());
			}else {
				map.put("declaredMember_u_uid", "Guest");
				map.put("declaredMember_u_name", "Guest");

			}
			map.put("result","success");
			//System.out.println("12345");

			//}

		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}

		return map;
	}

	//댓글 신고 insert
	@RequestMapping(value="/cafein_user/customizing/customizing_ReplyDeclaredRegister.do", method=RequestMethod.POST)
	//@ResponseBody 써주면 에이작스로 인식해서 string 형태로 return 시킴
	public String submit(@ModelAttribute UserDeclaredCommand declaredCommand,
			@RequestParam("session_u_uid") String u_uid,
			@RequestParam("franchise_num") int franchise_num,
			HttpSession session ) throws Exception{

		log.debug("★★★  customizing_ReplyDeclaredRegister 진입");

		if(log.isDebugEnabled()){
			log.debug("declaredCommand : " + declaredCommand);
			log.debug("u_uid : " + u_uid);
			//log.debug("custom_num : " + custom_num);
			log.debug("franchise_num : " + franchise_num);
		}

		//d_state[처리상태] = 0.처리 전, 1.처리 중,2.처리 완료, 3처리 보류, 4. 처리 취소
		int d_state = 0;
		declaredCommand.setD_state(d_state);
		//출력할 메시지
		declaredCommand.setD_comment("커스텀마이징 댓글에서 신고가 들어왔으며 처리 전 상태입니다.");
		
		//댓글 신고
		customizingDetailService.insertDeclaredReply(declaredCommand);
		
		System.out.println("declaredCommand : " + declaredCommand.toString());
		
		//커스텀메뉴 댓글신고 로그, umenu_name=4, umenu_log_state=3 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(4);
		userMenuLogCommand.setUmenu_log_state(3);
		String u_email = customizingDetailService.selectDeclaredMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴에서 댓글을 신고 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);


		//login과 js를 같이 쓰고 있는데  login에서 page_registration.js 에이작스를 안쓰므로 신고도 map으로 return 시키지 않음
		return "redirect:/cafein_user/customizing/customizing_detail.do?custom_num="+declaredCommand.getD_target_num()+"&franchise_num="+franchise_num+"&u_uid="+u_uid;
	}

}

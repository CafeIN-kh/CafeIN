package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.MemberCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseDeclaredCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;
import kr.cafein.franchise.service.FranchiseService;
import kr.cafein.util.StringUtil;

@Controller
public class FranchiseDeclaredController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/franchise_replyDeclared_ajax.do")
	@ResponseBody
	public Map<String, Object> selectDeclared(@RequestParam("freply_num") int freply_num, @RequestParam("u_uid_declared") String u_uid_declared, 
			HttpSession session){
		if(log.isDebugEnabled()){
			 log.debug("신고당한 댓글 preply_num : " + freply_num);
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
	            FC_FranchiseReplyCommand declaredReply = franchiseService.selectReply(freply_num);
	            map.put("declaredReply", declaredReply);
	            
	            //신고당한 회원의 닉네임을 알기위해 select
	            if(!u_uid_declared.equals("Guest")) {
	               MemberCommand declaredMember = franchiseService.selectDeclaredMember(u_uid_declared);
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
	
	@RequestMapping(value="/cafein_user/franchise/franchise_detailReplyDeclaredRegister.do", method=RequestMethod.POST)
	   //@ResponseBody 써주면 에이작스로 인식해서 string 형태로 return 시킴
	   public String submit(@ModelAttribute FC_FranchiseDeclaredCommand declaredCommand,
	                   int franchise_num,
	                   HttpSession session ) throws Exception{
	      
	      if(log.isDebugEnabled()){
	         log.debug("declaredCommand : " + declaredCommand);
	         log.debug("pcafe_num : " + franchise_num);
	      }
	      
	      String u_name = (String)session.getAttribute("u_name");
	     
	      FC_FranchiseCommand franchiseCommand = franchiseService.selectFranchise(franchise_num);
	      String franchise = franchiseCommand.getFranchise_name() + " 댓글에서 신고가 들어왔으며 처리 전 상태입니다."; 
	      //String logMessage = "[" + u_name + "] 사용자가 프랜차이즈 페이지에서 댓글을 신고 하였습니다."; 
	      
	      //d_state[처리상태] = 0.처리 전, 1.처리 중,2.처리 완료, 3처리 보류, 4. 처리 취소
	      int d_state = 0;
	      declaredCommand.setD_state(d_state);
	      declaredCommand.setD_target_num(franchise_num);
	      declaredCommand.setD_comment(franchise);
	      //declaredCommand.setD_comment(logMessage);
	      
	      //줄바꿈 처리
	      declaredCommand.setD_content(StringUtil.useBrNoHtml(declaredCommand.getD_content()));
	      
	      //댓글 신고
	      franchiseService.insertDeclared(declaredCommand);
	      
	      //login과 js를 같이 쓰고 있는데  login에서 page_registration.js 에이작스를 안쓰므로 신고도 map으로 return 시키지 않음
	      return "redirect:/cafein_user/franchise/franchise_detail.do?franchise_num="+franchise_num;
	   }

}

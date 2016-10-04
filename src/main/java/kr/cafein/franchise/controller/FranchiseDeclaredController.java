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
			 log.debug("�Ű���� ��� preply_num : " + freply_num);
	         log.debug("�Ű���� u_id : " + u_uid_declared);

		}
		Map<String,Object> map = new HashMap<String,Object>();
		
		 try {
	         //���� �α����� ������� u_uid
	         String u_uid = (String) session.getAttribute("u_uid");
	         
	         if(u_uid == null) {
	            map.put("result", "logout");

	         }else {	            
	            //�Ű���� ����� �������� ��� ���� ��� select �ؿ���
	            FC_FranchiseReplyCommand declaredReply = franchiseService.selectReply(freply_num);
	            map.put("declaredReply", declaredReply);
	            
	            //�Ű���� ȸ���� �г����� �˱����� select
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
	   //@ResponseBody ���ָ� �����۽��� �ν��ؼ� string ���·� return ��Ŵ
	   public String submit(@ModelAttribute FC_FranchiseDeclaredCommand declaredCommand,
	                   int franchise_num,
	                   HttpSession session ) throws Exception{
	      
	      if(log.isDebugEnabled()){
	         log.debug("declaredCommand : " + declaredCommand);
	         log.debug("pcafe_num : " + franchise_num);
	      }
	      
	      String u_name = (String)session.getAttribute("u_name");
	     
	      FC_FranchiseCommand franchiseCommand = franchiseService.selectFranchise(franchise_num);
	      String franchise = franchiseCommand.getFranchise_name() + " ��ۿ��� �Ű� �������� ó�� �� �����Դϴ�."; 
	      //String logMessage = "[" + u_name + "] ����ڰ� ���������� ���������� ����� �Ű� �Ͽ����ϴ�."; 
	      
	      //d_state[ó������] = 0.ó�� ��, 1.ó�� ��,2.ó�� �Ϸ�, 3ó�� ����, 4. ó�� ���
	      int d_state = 0;
	      declaredCommand.setD_state(d_state);
	      declaredCommand.setD_target_num(franchise_num);
	      declaredCommand.setD_comment(franchise);
	      //declaredCommand.setD_comment(logMessage);
	      
	      //�ٹٲ� ó��
	      declaredCommand.setD_content(StringUtil.useBrNoHtml(declaredCommand.getD_content()));
	      
	      //��� �Ű�
	      franchiseService.insertDeclared(declaredCommand);
	      
	      //login�� js�� ���� ���� �ִµ�  login���� page_registration.js �����۽��� �Ⱦ��Ƿ� �Ű� map���� return ��Ű�� ����
	      return "redirect:/cafein_user/franchise/franchise_detail.do?franchise_num="+franchise_num;
	   }

}

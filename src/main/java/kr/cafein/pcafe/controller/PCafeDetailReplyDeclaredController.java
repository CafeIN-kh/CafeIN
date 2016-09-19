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
	
	//�Ű� ���â�� �Ű���/�ǽŰ��� ���� �Ѱ��ֱ�
	@RequestMapping("/cafein_user/private/private_detailReplyDeclared_ajax.do")
	@ResponseBody
	public Map<String,Object> process(@RequestParam("preply_num") int preply_num
									  ,@RequestParam("u_uid") String u_uid_declared
									  ,HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("�Ű���� ��� preply_num : " + preply_num);
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
				PCafeReplyCommand declaredReply = pcafeService.selectDeclaredReply(preply_num);
				map.put("declaredReply", declaredReply);
				
				//�Ű���� ȸ���� �г����� �˱����� select
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
	
	//��� �Ű� insert
	@RequestMapping(value="/cafein_user/private/private_detailReplyDeclaredRegister.do", method=RequestMethod.POST)
	//@ResponseBody ���ָ� �����۽��� �ν��ؼ� string ���·� return ��Ŵ
	public String submit(@ModelAttribute DeclaredCommand declaredCommand,
						 int pcafe_num,
						 HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("declaredCommand : " + declaredCommand);
			log.debug("pcafe_num : " + pcafe_num);
		}
		System.out.println("private_detailReplyDeclaredRegister_ajax ����");
		
		//d_state[ó������] = 0.ó�� ��, 1.ó�� ��,2.ó�� �Ϸ�, 3ó�� ����, 4. ó�� ���
		int d_state = 0;
		declaredCommand.setD_state(d_state);
		
		//��� �Ű�
		pcafeService.insertDeclaredReply(declaredCommand);
		
		//login�� js�� ���� ���� �ִµ�  login���� page_registration.js �����۽��� �Ⱦ��Ƿ� �Ű� map���� return ��Ű�� ����
		return "redirect:/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num;
	}

}

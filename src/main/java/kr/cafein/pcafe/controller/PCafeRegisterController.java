package kr.cafein.pcafe.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.FileUtil_Private;

@Controller
/*@SessionAttributes("command")*/
public class PCafeRegisterController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping(value="/cafein_user/private/pcafe/register.do", method=RequestMethod.POST)
	@ResponseBody
	//@Transactional(rollbackFor=Exception.class)
	public Map<String,String> submit(@ModelAttribute
							@Valid PCafeCommand pcafeCommand,
							HttpSession session ) throws Exception{
		/*
		BindingResult result,
		SessionStatus status,
	    HttpSession session, Model model*/

		if(log.isDebugEnabled()){
			log.debug("pcafeCommand : " + pcafeCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		//try {
			String u_uid = (String)session.getAttribute("u_uid"); 
			pcafeCommand.setU_uid(u_uid);
	
			//�����
			String newName="";
			if(!pcafeCommand.getUpload().isEmpty() ) {
				System.out.println("�����̸� ����");
				newName = FileUtil_Private.rename(pcafeCommand.getUpload().getOriginalFilename());
				//�̸��տ� ��ǥ�̹��� �ĺ��� *ǥ ���̱�
				pcafeCommand.setPcafe_img("*"+newName);
			}
			
			//�����ð� ���۽ð�+�����ð� ���ļ� pcafe_time�� ���
			pcafeCommand.setPcafe_time(pcafeCommand.getPcafe_time_start() + " ~ " + pcafeCommand.getPcafe_time_end());
	
			//ī����
			pcafeService.insert(pcafeCommand);
	
			//������ upload ������ ����
			if(!pcafeCommand.getUpload().isEmpty()) {
				File file = new File (FileUtil_Private.UPLOAD_PATH + "/" +newName);
				pcafeCommand.getUpload().transferTo(file);
				FileUtil_Private.createThumbnail(newName, newName, 720, 455);
			}
	
			//����ī�� ��� �α�, umenu_name=0, umenu_log_state=1 ����
			//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
			//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
			UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
			userMenuLogCommand.setUmenu_log_u_uid(u_uid);
			userMenuLogCommand.setUmenu_name(0);
			userMenuLogCommand.setUmenu_log_state(0);
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			String logMessage = "[" + u_email + "] ����ڰ� ����ī�信�� ī������ �Ͽ����ϴ�."; 
			userMenuLogCommand.setUmenu_log_message(logMessage);
			pcafeService.insertUserLog(userMenuLogCommand);
			log.debug("[����ī�� �α�] userMenuLogCommand : " + userMenuLogCommand);
			
			map.put("result", "success");
		
		/*}catch(Exception e) {
			e.printStackTrace();
			//�ѹ�
			log.debug("=======�ѹ�========" );
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//throw new Exception(e.getMessage());
			map.put("result", "failure");
		}*/
		
		return map;
	}
	
}

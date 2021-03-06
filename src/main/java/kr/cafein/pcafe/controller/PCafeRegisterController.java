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
	
			//사업자
			String newName="";
			if(!pcafeCommand.getUpload().isEmpty() ) {
				System.out.println("파일이름 새로");
				newName = FileUtil_Private.rename(pcafeCommand.getUpload().getOriginalFilename());
				//이름앞에 대표이미지 식별할 *표 붙이기
				pcafeCommand.setPcafe_img("*"+newName);
			}
			
			//영업시간 시작시간+마감시간 합쳐서 pcafe_time에 담기
			pcafeCommand.setPcafe_time(pcafeCommand.getPcafe_time_start() + " ~ " + pcafeCommand.getPcafe_time_end());
	
			//카페등록
			pcafeService.insert(pcafeCommand);
	
			//파일을 upload 폴더에 저장
			if(!pcafeCommand.getUpload().isEmpty()) {
				File file = new File (FileUtil_Private.UPLOAD_PATH + "/" +newName);
				pcafeCommand.getUpload().transferTo(file);
				FileUtil_Private.createThumbnail(newName, newName, 720, 455);
			}
	
			//개인카페 등록 로그, umenu_name=0, umenu_log_state=1 고정
			//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
			//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
			UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
			userMenuLogCommand.setUmenu_log_u_uid(u_uid);
			userMenuLogCommand.setUmenu_name(0);
			userMenuLogCommand.setUmenu_log_state(0);
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			String logMessage = "[" + u_email + "] 사용자가 개인카페에서 카페등록을 하였습니다."; 
			userMenuLogCommand.setUmenu_log_message(logMessage);
			pcafeService.insertUserLog(userMenuLogCommand);
			log.debug("[개인카페 로그] userMenuLogCommand : " + userMenuLogCommand);
			
			map.put("result", "success");
		
		/*}catch(Exception e) {
			e.printStackTrace();
			//롤백
			log.debug("=======롤백========" );
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//throw new Exception(e.getMessage());
			map.put("result", "failure");
		}*/
		
		return map;
	}
	
}

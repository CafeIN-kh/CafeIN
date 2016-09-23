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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.FileUtil_Private;

@Controller
public class PCafeDetailModifyController {
	
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping(value="/cafein_user/private/pcafe/modify.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute
							@Valid PCafeCommand pcafeCommand,
							HttpSession session,
							MultipartFile upload_modify) throws Exception{
							//PCafeCommand에 담아오지 않고 MultipartFile upload_modify로 따로 받는 이유 
							//-> contact.js에서 multifile이 비어있으면 null로 변환해서 보내서 그런거 같음.
							//-> PCafeRegisterController에서는 MultipartFile upload는 무조건 파일이 들어가야 하므로 PCafeCommand에 담아와도 됨
		
		if(log.isDebugEnabled()){
			log.debug("pcafeCommand : " + pcafeCommand);
			log.debug("upload_modify : " + upload_modify);
		}
		
		//해당 카페의 정보 찾아오기(기존 파일 이름 얻어오기 위해서)
		PCafeCommand pcafe_info = pcafeService.selectPCafe(pcafeCommand.getPcafe_num());

		//사업자
		String newName="";
		if(upload_modify != null && !upload_modify.isEmpty() ) {
			System.out.println("첨부파일 있을 경우 파일이름 새로");
			newName = FileUtil_Private.rename(upload_modify.getOriginalFilename());
			//기존에 *표시 붙어있는 대표이미지 이름뒤에 ,를 붙이고 새로운 파일 이름 저장(나중에 js에서 split 후 이미지 가져갈것임)
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img() + "," +newName);
			System.out.println("첨부파일 있을 경우 파일 이름 저장 : " + pcafe_info.getPcafe_img() + "," + newName);
		}else {
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img());
			System.out.println("첨부파일 없을 경우 : " + pcafe_info.getPcafe_img());
		}
		
		//영업시간 시작시간+마감시간 합쳐서 pcafe_time에 담기
		pcafeCommand.setPcafe_time(pcafeCommand.getPcafe_time_start() + " ~ " + pcafeCommand.getPcafe_time_end());

		//카페수정
		pcafeService.update(pcafeCommand);
		System.out.println("수정내용 : " + pcafeCommand.toString());
		
		//파일을 upload 폴더에 저장
		if(upload_modify != null && !upload_modify.isEmpty()) {
			System.out.println("첨부파일 있을 경우 파일 업로드에 저장");
			File file = new File (FileUtil_Private.UPLOAD_PATH + "/" +newName);
			upload_modify.transferTo(file);
			FileUtil_Private.createThumbnail(newName, newName, 720, 455);
		}/*else if(pcafeCommand.getUpload() == null){
			
		}*/
		
		String u_uid = (String)session.getAttribute("u_uid"); 
		//개인카페 수정 로그, umenu_name=0, umenu_log_state=1 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(0);
		userMenuLogCommand.setUmenu_log_state(1);
		String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 개인카페에서 카페수정을 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		pcafeService.insertUserLog(userMenuLogCommand);
		log.debug("[개인카페 로그] userMenuLogCommand : " + userMenuLogCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
	}
	
}

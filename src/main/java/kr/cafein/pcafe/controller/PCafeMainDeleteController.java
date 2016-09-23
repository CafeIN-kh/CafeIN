package kr.cafein.pcafe.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.FileUtil_Private;
import kr.cafein.util.FileUtil_PrivateMenu;

@Controller
public class PCafeMainDeleteController {

private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping("/cafein_user/private/pcafeDelete_ajax.do")
	@ResponseBody
	public Map<String,String> detailMenuDelete(@RequestParam("pcafe_num") int pcafe_num,
											   @RequestParam("u_uid") String register_u_uid,
								   			   HttpSession session) {
		
		System.out.println("pcafeDelete_ajax.do 진입");

		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
			log.debug("카페 등록한 register_u_uid : " + register_u_uid);
		} 
		
		Map<String,String> map = new HashMap<String,String>();
		
		//로그인 중인 사용자 u_uid
		String u_uid = (String)session.getAttribute("u_uid");
		log.debug("로그인 중인 u_uid : " + u_uid);
		
		//세션아이디와 카페 등록자 아이디가 같으면 삭제
		//개인카페 삭제 순서
		if(u_uid.equals(register_u_uid)){
			log.debug("삭제 하는 if문 안으로 진입");
			
			//private_cafe에 눌려있는 좋아요 모두 삭제
			pcafeService.deleteLikeByPCafe(pcafe_num);
			log.debug("개인카페의 좋아요 삭제 완료");
			//private_cafe에 눌려있는 즐겨찾기 모두 삭제
			pcafeService.deleteBookmarkByPCafe(pcafe_num);
			log.debug("개인카페의 즐겨찾기 삭제 완료");
			//private_cafe에 달려있는 댓글 모두 삭제
			pcafeService.deletePCafeReplyByPCafe(pcafe_num);
			log.debug("개인카페의 댓글 삭제 완료");
			
			//private_cafe안의 모든 메뉴 찾기(메뉴의 좋아요 지워주기 위해서)
			List<PCafeMenuCommand> pcafeMenuCommand = null;
			pcafeMenuCommand = pcafeService.selectPCafeMenuByPCafe(pcafe_num);
			
			//private_cafe_menu에 눌려있는 좋아요 모두 삭제
			for(int i=0; i<pcafeMenuCommand.size(); i++) {
				int pmenu_num = pcafeMenuCommand.get(i).getPmenu_num();
				pcafeService.deletePCafeMenuLikekByPCafe(pmenu_num);
				log.debug("개인카페 메뉴의 좋아요 삭제 완료");
				
				//해당 pmenu_num에 업로드된 이미지 지우기
				String saveMenuName = pcafeMenuCommand.get(i).getPmenu_img();
				File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" + saveMenuName);
				if(file.exists()){		//파일이 존재한다면
					if(file.delete()) {	//해당 이미지or디렉토리 삭제
						log.debug("개인카페 메뉴의 이미지 삭제 완료 : " + saveMenuName);
					}else {
						log.debug("개인카페 메뉴의 이미지 삭제 실패 : " + saveMenuName);
					}
				}
				
			}
			
			//private_cafe안의 해당 메뉴 모두 삭제
			pcafeService.deleteMenuByPCafe(pcafe_num);
			log.debug("메뉴 삭제 완료");
			
			//개인카페의 이미지들을 지우기 위해 개인카페 정보 찾기
			PCafeCommand pcafeCommand = pcafeService.selectPCafe(pcafe_num);
			String pcafeImgName = pcafeCommand.getPcafe_img();
		    String[] pcafeImgNameArray;
		    
		    //문자열에 ,가 있다면 쪼개서 배열에 담기
		    pcafeImgNameArray = pcafeImgName.split(",");
		    for (int i = 0; i < pcafeImgNameArray.length; i++) {
				//pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
				if(pcafeImgNameArray[i].indexOf("*") != -1){
					//*이 있다는 것이므로 *표를 빈값으로 대체
					//대표이미지 찾아서 *표시 없애주기
					pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*","");
				}
			}
		    
		    //개인카페에 업로드된 이미지 지우기
		    File pcafeFile;
		    for(int j = 0; j < pcafeImgNameArray.length; j++) {
				pcafeFile = new File (FileUtil_Private.UPLOAD_PATH + "/" + pcafeImgNameArray[j]);
				if(pcafeFile.exists()){		//파일이 존재한다면
					if(pcafeFile.delete()) {	//해당 이미지or디렉토리 삭제
						log.debug("개인카페의 이미지 삭제 완료 : " + pcafeImgNameArray[j]);
					}else {
						log.debug("개인카페의 이미지 삭제 실패 : " + pcafeImgNameArray[j]);
					}
				}
		    }
		    
			//해당 private_cafe 정보 삭제
		    //파라미터 두개를 mapper에 넘길 수 없으므로 map 형식으로 넘김
		    HashMap<String,Object> deleteMap = new HashMap<String,Object>();
		    deleteMap.put("pcafe_num", pcafe_num);
		    deleteMap.put("u_uid", u_uid);
			pcafeService.deletePCafe(deleteMap);
			log.debug("개인카페 정보 삭제 완료");
			
			//개인카페 삭제 로그, umenu_name=0, umenu_log_state=2 고정
			//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
			//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
			UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
			userMenuLogCommand.setUmenu_log_u_uid(u_uid);
			userMenuLogCommand.setUmenu_name(0);
			userMenuLogCommand.setUmenu_log_state(2);
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			String logMessage = "[" + u_email + "] 사용자가 개인카페에서 카페삭제를 하였습니다."; 
			userMenuLogCommand.setUmenu_log_message(logMessage);
			pcafeService.insertUserLog(userMenuLogCommand);
			log.debug("[개인카페 로그] userMenuLogCommand : " + userMenuLogCommand);
			
			map.put("result","success");
			
		}else {
			map.put("result","fail");
		}
		
		return map;
	}
}

package kr.cafein.customizing.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.service.CustomizingDetailService;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.util.CustomFileUtil;
import kr.cafein.util.FileUtilCus;
import kr.cafein.util.StringUtil;

@Controller
public class CustomizingDetailUpdateController {

	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private CustomizingDetailService customizingDetailService;
	
	@RequestMapping(value="/cafein_user/customizing/custom/register.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> submit(@ModelAttribute
										@Valid CustomizingDetailCommand customizingDetailCommand,
										BindingResult result,
										HttpSession session)throws Exception{
		
		
		CustomizingDetailCommand customDetail = customizingDetailService.selectImg(customizingDetailCommand.getCustom_num());
		
		System.out.println("CustomizingDetailUpdateController吏꾩엯");
		
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		/*String u_uid = "1";
		customizingDetailCommand.setU_uid(u_uid);*/
		//System.out.println("�젒洹�");
		//System.out.println("�씠誘몄� �긽�깭 : " + customizingDetailCommand.getUpload().isEmpty());
		String newName="";
		if(customizingDetailCommand.getUpload()!=null && !customizingDetailCommand.getUpload().isEmpty() ) {
			//System.out.println("�젒洹�");
			newName = CustomFileUtil.rename(customizingDetailCommand.getUpload().getOriginalFilename());
			customizingDetailCommand.setCustom_img(newName);
		}else{
			System.out.println("而ㅼ뒪�� �씠誘몄� 異쒕젰 : " + customDetail.getCustom_img());
			customizingDetailCommand.setCustom_img(customDetail.getCustom_img());
			
		}
		
		customizingDetailCommand.setU_uid(u_uid);
		
		if(log.isDebugEnabled()){
			log.debug("CustomizingDetailCommand : " + customizingDetailCommand);
		}
		//줄바꿈 허용
		customizingDetailCommand.setCustom_introduce(StringUtil.useBrNoHtml(customizingDetailCommand.getCustom_introduce()));
		customizingDetailCommand.setCustom_recipe(StringUtil.useBrNoHtml(customizingDetailCommand.getCustom_recipe()));
		
		customizingDetailService.updateCustomMenu(customizingDetailCommand);
		
		//System.out.println("�봽�옖李⑥씠利덈꽕�엫"+customizingDetailCommand.getFranchise_num());

		if(customizingDetailCommand.getUpload()!=null && !customizingDetailCommand.getUpload().isEmpty()) {
			File file = new File (CustomFileUtil.UPLOAD_PATH + "/" +newName);
			customizingDetailCommand.getUpload().transferTo(file);
			FileUtilCus.createThumbnail(newName, newName, 720, 455);
			//CustomFileUtil.createThumbnail(newName, newName, 336, 252);
		}
		
		//커스텀메뉴  로그, umenu_name=1, umenu_log_state=1 고정
		//umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
		//umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
		UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
		userMenuLogCommand.setUmenu_log_u_uid(u_uid);
		userMenuLogCommand.setUmenu_name(1);
		userMenuLogCommand.setUmenu_log_state(1);
		String u_email = customizingDetailService.selectCustomUserLogByMember(u_uid).getU_email();
		String logMessage = "[" + u_email + "] 사용자가 커스텀 메뉴를 수정 하였습니다."; 
		userMenuLogCommand.setUmenu_log_message(logMessage);
		customizingDetailService.insertCustomUserLog(userMenuLogCommand);
		log.debug("[커스텀 로그] userMenuLogCommand : " + userMenuLogCommand);

		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");

		return map;
		
	}
}

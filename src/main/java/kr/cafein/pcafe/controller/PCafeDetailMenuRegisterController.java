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

import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.FileUtil_PrivateMenu;

@Controller
public class PCafeDetailMenuRegisterController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping(value="/cafein_user/private/pcafe/menuRegister.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> submit(@ModelAttribute
							@Valid PCafeMenuCommand pcafeMenuCommand,
							HttpSession session ) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pcafeMenuCommand : " + pcafeMenuCommand);
		}
		
		String newName="";
		if(!pcafeMenuCommand.getUpload_menu().isEmpty() ) {
			System.out.println("첨부파일 있을 경우 파일 메뉴이름 새로");
			newName = FileUtil_PrivateMenu.rename(pcafeMenuCommand.getUpload_menu().getOriginalFilename());
			//이름앞에 대표이미지 식별할 *표 붙이기
			pcafeMenuCommand.setPmenu_img(newName);
			System.out.println("첨부파일 있을 경우 파일 메뉴이름 저장 : " + newName);
		}
		
		//카페메뉴등록
		pcafeService.insertMenu(pcafeMenuCommand);

		//파일을 upload 폴더에 저장
		if(!pcafeMenuCommand.getUpload_menu().isEmpty()) {
			System.out.println("첨부파일 있을 경우 파일 메뉴업로드에 저장");
			File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" +newName);
			pcafeMenuCommand.getUpload_menu().transferTo(file);
			FileUtil_PrivateMenu.createThumbnail(newName, newName, 720, 720);
		}

		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
		
	}
}

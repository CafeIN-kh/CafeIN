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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.util.FileUtilCus;

@Controller
public class CustomizingInsertAjaxController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingService customizingService; 

	
	@RequestMapping("/cafein_user/customizing/customizingInsert_ajax.do")
	@ResponseBody
	public Map<String,String> process(@ModelAttribute("command")
								     @Valid CustomizingCommand customizingCommand,BindingResult result,
									        SessionStatus status,
									        HttpSession session)
			throws Exception{
		
		String u_uid = (String)session.getAttribute("u_uid");
		customizingCommand.setU_uid(u_uid);
		
		
		if(log.isDebugEnabled()){
			log.debug("customizingCommand : " + customizingCommand);
		}
		
		String newName = "";
		
		if(customizingCommand.getUpload()!=null && !customizingCommand.getUpload().isEmpty()){
			newName = FileUtilCus.rename(customizingCommand.getUpload().getOriginalFilename());
		  customizingCommand.setCustom_img(newName);
		}
		
	      
		
		//글쓰기
		customizingService.insert(customizingCommand);
		status.setComplete();
		
		
		
		//파일을 upload 폴더에 저장
		if(customizingCommand.getUpload()!=null && !customizingCommand.getUpload().isEmpty()){
			File file =
			new File(FileUtilCus.UPLOAD_PATH+"/"+newName);
			customizingCommand.getUpload().transferTo(file);
			FileUtilCus.createThumbnail(newName, newName, 720, 455);
		}
		
		System.out.println("command : "+customizingCommand.toString());
		
		
		Map<String,String> mapJson = new HashMap<String,String> ();
		mapJson.put("result", "success");
		
		return mapJson;
	}

}

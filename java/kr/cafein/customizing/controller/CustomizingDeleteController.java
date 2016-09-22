package kr.cafein.customizing.controller;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.util.FileUtilCus;;


@Controller
public class CustomizingDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CustomizingService customizingService;
	
	@RequestMapping("/cafein_user/customizing/customizing_delete.do")
	public String submit(
			@RequestParam(value="custom_num",defaultValue="") int custom_num, 
			HttpSession session) throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("custom_num : " + custom_num);
		}
		
		CustomizingCommand customizingCommand = customizingService.selectBoard(custom_num);
		
		System.out.println("customizingCommand안에다가 customizingService.selectBoard(custom_num)을 넣어주면 : " +customizingCommand.toString());
		String u_uid = (String)session.getAttribute("u_uid");
		
		if(!u_uid.equals(customizingCommand.getU_uid())) {
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		customizingService.deleteCboard(custom_num);
		
		//파일 삭제 여부 체크
		if(customizingCommand.getCustom_img() != null) {
			FileUtilCus.removeFile(customizingCommand.getCustom_img());
		}
		return "redirect:/cafein_user/customizing/customizing_list.do";
	}
}

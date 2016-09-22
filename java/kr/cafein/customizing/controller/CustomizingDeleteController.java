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
		
		System.out.println("customizingCommand�ȿ��ٰ� customizingService.selectBoard(custom_num)�� �־��ָ� : " +customizingCommand.toString());
		String u_uid = (String)session.getAttribute("u_uid");
		
		if(!u_uid.equals(customizingCommand.getU_uid())) {
			throw new Exception("�α����� ���̵�� �ۼ��� ���� �ƴϱ� ������ ������ �� �����ϴ�.");
		}
		
		//�� ����
		customizingService.deleteCboard(custom_num);
		
		//���� ���� ���� üũ
		if(customizingCommand.getCustom_img() != null) {
			FileUtilCus.removeFile(customizingCommand.getCustom_img());
		}
		return "redirect:/cafein_user/customizing/customizing_list.do";
	}
}

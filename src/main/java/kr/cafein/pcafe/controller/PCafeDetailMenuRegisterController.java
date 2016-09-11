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
			System.out.println("÷������ ���� ��� ���� �޴��̸� ����");
			newName = FileUtil_PrivateMenu.rename(pcafeMenuCommand.getUpload_menu().getOriginalFilename());
			//�̸��տ� ��ǥ�̹��� �ĺ��� *ǥ ���̱�
			pcafeMenuCommand.setPmenu_img(newName);
			System.out.println("÷������ ���� ��� ���� �޴��̸� ���� : " + newName);
		}
		
		//ī��޴����
		pcafeService.insertMenu(pcafeMenuCommand);

		//������ upload ������ ����
		if(!pcafeMenuCommand.getUpload_menu().isEmpty()) {
			System.out.println("÷������ ���� ��� ���� �޴����ε忡 ����");
			File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" +newName);
			pcafeMenuCommand.getUpload_menu().transferTo(file);
			FileUtil_PrivateMenu.createThumbnail(newName, newName, 720, 720);
		}

		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
		
	}
}

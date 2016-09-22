package kr.cafein.pcafe.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.FileUtil_PrivateMenu;

@Controller
public class PCafeDetailMenuDeleteController {

private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	@RequestMapping("/cafein_user/private/private_detailMenuDelete.do")
	@ResponseBody
	public Map<String,String> detailMenuDelete(@RequestParam("pmenu_num") int pmenu_num,
								   int pcafe_num,
								   HttpSession session) {
		
		System.out.println("private_detailMenuDelete.do ����");

		if(log.isDebugEnabled()) {
			log.debug("pmenu_num : " + pmenu_num);
		} 
		
		//�̹��� ���� �����
		PCafeMenuCommand pcafeMenuCommand;
		pcafeMenuCommand = pcafeService.selectMenuDetail(pmenu_num);
		
		String saveName = pcafeMenuCommand.getPmenu_img();
		File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" + saveName);
		if(file.exists()){
			if(file.delete()) {
				System.out.println("�̹����� ���������� �������ϴ�: " + saveName);
			}else {
				System.err.println("�̹��� ����� ����: " + saveName);
			}
		}
		//�ش�޴���  ���ƿ� ��� ����
		pcafeService.deleteLikeByPCafeMenu(pmenu_num);
		//�ش� �޴� ���� 
		pcafeService.deleteMenu(pmenu_num);
		
		
		log.debug("�޴� ���� �Ϸ�");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("result","success");
		//return "redirect:/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num;
		return map;
	}
}

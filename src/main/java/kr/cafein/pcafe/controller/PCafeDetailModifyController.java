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
							//PCafeCommand�� ��ƿ��� �ʰ� MultipartFile upload_modify�� ���� �޴� ���� 
							//-> contact.js���� multifile�� ��������� null�� ��ȯ�ؼ� ������ �׷��� ����.
							//-> PCafeRegisterController������ MultipartFile upload�� ������ ������ ���� �ϹǷ� PCafeCommand�� ��ƿ͵� ��
		
		if(log.isDebugEnabled()){
			log.debug("pcafeCommand : " + pcafeCommand);
			log.debug("upload_modify : " + upload_modify);
		}
		
		//�ش� ī���� ���� ã�ƿ���(���� ���� �̸� ������ ���ؼ�)
		PCafeCommand pcafe_info = pcafeService.selectPCafe(pcafeCommand.getPcafe_num());

		//�����
		String newName="";
		if(upload_modify != null && !upload_modify.isEmpty() ) {
			System.out.println("÷������ ���� ��� �����̸� ����");
			newName = FileUtil_Private.rename(upload_modify.getOriginalFilename());
			//������ *ǥ�� �پ��ִ� ��ǥ�̹��� �̸��ڿ� ,�� ���̰� ���ο� ���� �̸� ����(���߿� js���� split �� �̹��� ����������)
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img() + "," +newName);
			System.out.println("÷������ ���� ��� ���� �̸� ���� : " + pcafe_info.getPcafe_img() + "," + newName);
		}/*else if(pcafeCommand.getUpload() == null){
			
		}*/else {
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img());
			System.out.println("÷������ ���� ��� : " + pcafe_info.getPcafe_img());
		}
		
		//�����ð� ���۽ð�+�����ð� ���ļ� pcafe_time�� ���
		pcafeCommand.setPcafe_time(pcafeCommand.getPcafe_time_start() + " ~ " + pcafeCommand.getPcafe_time_end());

		//ī�����
		pcafeService.update(pcafeCommand);
		System.out.println("�������� : " + pcafeCommand.toString());
		
		//������ upload ������ ����
		if(upload_modify != null && !upload_modify.isEmpty()) {
			System.out.println("÷������ ���� ��� ���� ���ε忡 ����");
			File file = new File (FileUtil_Private.UPLOAD_PATH + "/" +newName);
			upload_modify.transferTo(file);
			FileUtil_Private.createThumbnail(newName, newName, 720, 455);
		}/*else if(pcafeCommand.getUpload() == null){
			
		}*/
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("result", "success");
		
		return map;
	}
	
/*	@RequestMapping(value="/cafein_user/private/pcafe/modify.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute
							@Valid PCafeCommand pcafeCommand,
							HttpSession session ) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("pcafeCommand : " + pcafeCommand);
		}
		
		//�ش� ī���� ���� ã�ƿ���(���� ���� �̸� ������ ���ؼ�)
		PCafeCommand pcafe_info = pcafeService.selectPCafe(pcafeCommand.getPcafe_num());

		//�����
		String newName="";
		if(!pcafeCommand.getUpload().isEmpty() ) {
			System.out.println("÷������ ���� ��� �����̸� ����");
			newName = FileUtil_Private.rename(pcafeCommand.getUpload().getOriginalFilename());
			//������ *ǥ�� �پ��ִ� ��ǥ�̹��� �̸��ڿ� ,�� ���̰� ���ο� ���� �̸� ����(���߿� js���� split �� �̹��� ����������)
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img() + "," +newName);
			System.out.println("÷������ ���� ��� ���� �̸� ���� : " + pcafe_info.getPcafe_img() + "," + newName);
		}else {
			pcafeCommand.setPcafe_img(pcafe_info.getPcafe_img());
			System.out.println("÷������ ���� ��� : " + pcafe_info.getPcafe_img());
		}
		
		//�����ð� ���۽ð�+�����ð� ���ļ� pcafe_time�� ���
		pcafeCommand.setPcafe_time(pcafeCommand.getPcafe_time_start() + " ~ " + pcafeCommand.getPcafe_time_end());

		//ī�����
		pcafeService.update(pcafeCommand);
		System.out.println("�������� : " + pcafeCommand.toString());
		
		//������ upload ������ ����
		if(!pcafeCommand.getUpload().isEmpty()) {
			File file = new File (FileUtil_Private.UPLOAD_PATH + "/" +newName);
			pcafeCommand.getUpload().transferTo(file);
			FileUtil_Private.createThumbnail(newName, newName, 720, 455);
		}
		
		return "redirect:/cafein_user/private/private_detail.do?pcafe_num=" + pcafeCommand.getPcafe_num();
	}*/

}

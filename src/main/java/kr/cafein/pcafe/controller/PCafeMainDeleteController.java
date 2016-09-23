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
		
		System.out.println("pcafeDelete_ajax.do ����");

		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
			log.debug("ī�� ����� register_u_uid : " + register_u_uid);
		} 
		
		Map<String,String> map = new HashMap<String,String>();
		
		//�α��� ���� ����� u_uid
		String u_uid = (String)session.getAttribute("u_uid");
		log.debug("�α��� ���� u_uid : " + u_uid);
		
		//���Ǿ��̵�� ī�� ����� ���̵� ������ ����
		//����ī�� ���� ����
		if(u_uid.equals(register_u_uid)){
			log.debug("���� �ϴ� if�� ������ ����");
			
			//private_cafe�� �����ִ� ���ƿ� ��� ����
			pcafeService.deleteLikeByPCafe(pcafe_num);
			log.debug("����ī���� ���ƿ� ���� �Ϸ�");
			//private_cafe�� �����ִ� ���ã�� ��� ����
			pcafeService.deleteBookmarkByPCafe(pcafe_num);
			log.debug("����ī���� ���ã�� ���� �Ϸ�");
			//private_cafe�� �޷��ִ� ��� ��� ����
			pcafeService.deletePCafeReplyByPCafe(pcafe_num);
			log.debug("����ī���� ��� ���� �Ϸ�");
			
			//private_cafe���� ��� �޴� ã��(�޴��� ���ƿ� �����ֱ� ���ؼ�)
			List<PCafeMenuCommand> pcafeMenuCommand = null;
			pcafeMenuCommand = pcafeService.selectPCafeMenuByPCafe(pcafe_num);
			
			//private_cafe_menu�� �����ִ� ���ƿ� ��� ����
			for(int i=0; i<pcafeMenuCommand.size(); i++) {
				int pmenu_num = pcafeMenuCommand.get(i).getPmenu_num();
				pcafeService.deletePCafeMenuLikekByPCafe(pmenu_num);
				log.debug("����ī�� �޴��� ���ƿ� ���� �Ϸ�");
				
				//�ش� pmenu_num�� ���ε�� �̹��� �����
				String saveMenuName = pcafeMenuCommand.get(i).getPmenu_img();
				File file = new File (FileUtil_PrivateMenu.UPLOAD_PATH + "/" + saveMenuName);
				if(file.exists()){		//������ �����Ѵٸ�
					if(file.delete()) {	//�ش� �̹���or���丮 ����
						log.debug("����ī�� �޴��� �̹��� ���� �Ϸ� : " + saveMenuName);
					}else {
						log.debug("����ī�� �޴��� �̹��� ���� ���� : " + saveMenuName);
					}
				}
				
			}
			
			//private_cafe���� �ش� �޴� ��� ����
			pcafeService.deleteMenuByPCafe(pcafe_num);
			log.debug("�޴� ���� �Ϸ�");
			
			//����ī���� �̹������� ����� ���� ����ī�� ���� ã��
			PCafeCommand pcafeCommand = pcafeService.selectPCafe(pcafe_num);
			String pcafeImgName = pcafeCommand.getPcafe_img();
		    String[] pcafeImgNameArray;
		    
		    //���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
		    pcafeImgNameArray = pcafeImgName.split(",");
		    for (int i = 0; i < pcafeImgNameArray.length; i++) {
				//pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
				if(pcafeImgNameArray[i].indexOf("*") != -1){
					//*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
					//��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
					pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*","");
				}
			}
		    
		    //����ī�信 ���ε�� �̹��� �����
		    File pcafeFile;
		    for(int j = 0; j < pcafeImgNameArray.length; j++) {
				pcafeFile = new File (FileUtil_Private.UPLOAD_PATH + "/" + pcafeImgNameArray[j]);
				if(pcafeFile.exists()){		//������ �����Ѵٸ�
					if(pcafeFile.delete()) {	//�ش� �̹���or���丮 ����
						log.debug("����ī���� �̹��� ���� �Ϸ� : " + pcafeImgNameArray[j]);
					}else {
						log.debug("����ī���� �̹��� ���� ���� : " + pcafeImgNameArray[j]);
					}
				}
		    }
		    
			//�ش� private_cafe ���� ����
		    //�Ķ���� �ΰ��� mapper�� �ѱ� �� �����Ƿ� map �������� �ѱ�
		    HashMap<String,Object> deleteMap = new HashMap<String,Object>();
		    deleteMap.put("pcafe_num", pcafe_num);
		    deleteMap.put("u_uid", u_uid);
			pcafeService.deletePCafe(deleteMap);
			log.debug("����ī�� ���� ���� �Ϸ�");
			
			//����ī�� ���� �α�, umenu_name=0, umenu_log_state=2 ����
			//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
			//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
			UserMenuLogCommand userMenuLogCommand = new UserMenuLogCommand();
			userMenuLogCommand.setUmenu_log_u_uid(u_uid);
			userMenuLogCommand.setUmenu_name(0);
			userMenuLogCommand.setUmenu_log_state(2);
			String u_email = pcafeService.selectUserLogByMember(u_uid).getU_email();
			String logMessage = "[" + u_email + "] ����ڰ� ����ī�信�� ī������� �Ͽ����ϴ�."; 
			userMenuLogCommand.setUmenu_log_message(logMessage);
			pcafeService.insertUserLog(userMenuLogCommand);
			log.debug("[����ī�� �α�] userMenuLogCommand : " + userMenuLogCommand);
			
			map.put("result","success");
			
		}else {
			map.put("result","fail");
		}
		
		return map;
	}
}

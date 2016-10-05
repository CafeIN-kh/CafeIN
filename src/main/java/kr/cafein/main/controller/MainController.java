package kr.cafein.main.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.main.service.MainService;



@Controller
public class MainController {
  
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="mainService") //�ʿ�� �ϴ� �ڿ��� �ڵ� ����
	private MainService mainService;
	
	@RequestMapping("/cafein_user/main/main.do") //�޼��尡 ó���� ��û ��� ����
	public ModelAndView process(){//�� ��û�� ó���� �޼���
		
		//Ŀ���Ҹ���¡ �޴� ���ƿ� 
		List<ULikeCommand> cLikeCommand = null;
		List<CustomizingCommand> customizingCommand = null;
		
		cLikeCommand = mainService.selectCLike();
		customizingCommand = mainService.selectLikeCustomizing();

		System.out.println("uLikeCommand.size() : " + cLikeCommand.size());
		System.out.println("customizingCommand.size() : " + customizingCommand.size());
		System.out.println("customizingCommand.toString() : " + customizingCommand.toString());
		
		/*for(int i=0; i<uLikeCommand.size(); i++) {
			int custom_num = uLikeCommand.get(i).getCustom_num();	
			System.out.println("custom_num :" + custom_num);
			System.out.println("customizingCommandNum:" + mainService.selectLikeCustomizing());
			customizingCommand.add(mainService.selectLikeCustomizing());
		}*/
		/*for(int i=0; i<uLikeCommand.size(); i++) {
			int custom_num = uLikeCommand.get(i).getCustom_num();
			int count = uLikeCommand.get(i).getCount();
			
			System.out.println("custom_num :" + custom_num);
			System.out.println("customizingCommand:" + mainService.selectLikeCustomizing());
			customizingCommand.add((CustomizingCommand) mainService.selectLikeCustomizing());
			
			System.out.println("customizingCommand : " + customizingCommand.get(i).toString());
		}*/
		
		//���������� ���ã��
		FranchiseCommand franchiseCommandB;
		
		franchiseCommandB = mainService.selectBookmarkFranchise();
		
		if(franchiseCommandB != null) {
			System.out.println("franchiseCommand name :" + franchiseCommandB.getFranchise_name());
			System.out.println("franchiseCommand Fnum : " + franchiseCommandB.getFranchise_num());
		}
		
		//����ī�� ���ã��
		List<PrivateCafeCommand> privateCafeCommand = null;
		privateCafeCommand = mainService.selectBookmarkPrivateCafe();
		
		//����ī���� �̹����� ��ǥ�̹��� *�� ,�������ִ� �� �ɰ���
		for(int i = 0; i < privateCafeCommand.size(); i++) {
			String pcafeImgName = privateCafeCommand.get(i).getPcafe_img();
		    String[] pcafeImgNameArray;
		    
		  //���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
		    pcafeImgNameArray = pcafeImgName.split(",");
		    for (int j = 0; j < pcafeImgNameArray.length; j++) {
				//pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
				if(pcafeImgNameArray[j].indexOf("*") != -1){
					//*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü	//��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
					pcafeImgNameArray[j] = pcafeImgNameArray[j].replace("*","");
					privateCafeCommand.get(i).setPcafe_img(pcafeImgNameArray[j]);
				}
			}
		}
		
		List<ULikeCommand> selectFMLike = null;
		//���������� �޴� ���ƿ�
		List<ULikeCommand> fmenuLikeCommand = null;
		List<FranchiseMenuCommand> fmenuCommandL;
		//fmenuLikeCommand = mainService.selectFMLike();
		fmenuLikeCommand = selectFMLike;
		fmenuCommandL = mainService.selectLikeFmenu();
		
		
		System.out.println("fmenuCommandL.size() : " + fmenuCommandL.size());
		System.out.println("fmenuCommandL.toString() : " + fmenuCommandL.toString());
		
		List<ULikeCommand> selectPMLike = null;
		//����ī�� �޴� ���ƿ�
		List<ULikeCommand> pmenuLikeCommand = null;
		List<PrivateCafeMenuCommand> pmenuCommandL;
		//pmenuLikeCommand = mainService.selectPMLike();
		pmenuLikeCommand = selectPMLike;
		pmenuCommandL = mainService.selectLikePmenu();
		
		System.out.println("pmenuCommandL.size() : " + pmenuCommandL.size());
		System.out.println("pmenuCommandL.toString() : " + pmenuCommandL.toString());
		
		
		//�������� ī��Ʈ, ���� ��¥�� ���� �������� �ο� ����(insert)�� ������Ʈ(update)
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
        userCountLogCommand = mainService.selectMainUserCountLogByDate();	//���� ��¥�� db�� ����� ��¥�� ��ġ�ϴ� row ã�� 
        if(userCountLogCommand == null) {
        	log.debug("�ڡڡڿ��ó�¥ �������� �ο� �����Ƿ� insert");
        	mainService.insertMainUserCountLog();
        }else {
        	log.debug("�ڡڡڿ��ó��� �������� �ο� �����Ƿ� update, ��üī��Ʈ�� ���� ī��Ʈ+1");
        	mainService.updateMainUserCountLog();
        }

		ModelAndView mav = new ModelAndView();
		//������ ��Ī
		mav.setViewName("main");
		
		mav.addObject("cLikeCommand",cLikeCommand);
		mav.addObject("customizingCommand",customizingCommand);
		
		mav.addObject("franchiseCommandB",franchiseCommandB);
		
		mav.addObject("privateCafeCommand", privateCafeCommand);
		
		mav.addObject("fmenuLikeCommand", fmenuLikeCommand);
		mav.addObject("fmenuCommandL", fmenuCommandL);
		
		mav.addObject("pmenuLikeCommand", pmenuLikeCommand);
		mav.addObject("pmenuCommandL", pmenuCommandL);
		
		return mav;
	}
	
}

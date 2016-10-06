package kr.cafein.admin.privatecafe.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.domain.LikeCommand;
import kr.cafein.util.FileUtil_Private;

@Controller
@SessionAttributes("commandMenu")
public class PrivateListDetailController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "privateService")
	private PrivateService privateService;

	@RequestMapping(value = "/admin/privatecafe/privatecafe-detail.do", method = RequestMethod.GET)
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num) throws Exception {

		System.out.println("==============");

		/*
		 * List<PrivateCommand> list1 =
		 * privateService.getPrivateDetailList(seq);
		 */
		if (log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
		}

		PrivateCommand commandMenu = privateService.selectBoard(pcafe_num);
		ModelAndView mav = new ModelAndView("adminPrivateDetail");

		List<LikeCommand> getLikeUser = privateService.getLikeUser(pcafe_num);

		// ����ī���� �̹������� ����� ���� ����ī�� ���� ã��
		String pcafeImgName = commandMenu.getPcafe_img();
		String[] pcafeImgNameArray;

		// ���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
		pcafeImgNameArray = pcafeImgName.split(",");
		for (int i = 0; i < pcafeImgNameArray.length; i++) {
			// pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
			if (pcafeImgNameArray[i].indexOf("*") != -1) {
				// *�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
				// ��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
				pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*", "");
				commandMenu.setPcafe_img(pcafeImgNameArray[i]);
			}
		}

		// �ؽ��±�
		String hashTag = commandMenu.getPcafe_hash_tag();
		// ���� , ����� �ؽ��±� �信 ��ȯ
		String hashTagOriginal = commandMenu.getPcafe_hash_tag();
		// �ʱ�ȭ
		commandMenu.setPcafe_hash_tag("");
		String[] hashTagArray = hashTag.split(",");
		for (int i = 0; i < hashTagArray.length; i++) {
			// �ε��� �ȿ� , ���� ������ -1 ��ȯ
			if (hashTagArray[i].indexOf(",") != -1) {
				// *�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
				// ,ǥ�� �����ֱ�
				hashTagArray[i] = hashTagArray[i].replace(",", "");
			}
			commandMenu.setPcafe_hash_tag(commandMenu.getPcafe_hash_tag() + "#" + hashTagArray[i] + " ");
		}

		/* mav.addObject("list1", list1); */
		mav.addObject("commandMenu", commandMenu);
		mav.addObject("hashTagOriginal", hashTagOriginal);
		mav.addObject("getLikeUser", getLikeUser);
		/* System.out.println(list1); */
		return mav;

	}

	@RequestMapping(value = "/admin/privatecafe/privatecafe-detail.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("commandMenu") @Valid PrivateCommand commandMenu, BindingResult result,HttpSession session)
			throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("commandMenu : " + commandMenu);
		}

		if (result.hasErrors()) {
			return "adminPrivateDetail";
		}

		PrivateCommand pcommand = null;
		String oldFileName = "";

		pcommand = privateService.selectBoard(commandMenu.getPcafe_num());

		oldFileName = pcommand.getPcafe_img();

		//�����
		String newName="";
		newName = commandMenu.getPcafe_img();

		
		if (!commandMenu.getUpload().isEmpty()) {
			// ���۵� ������ �ִ� ���
			commandMenu.setPcafe_img(FileUtil_Private.rename(commandMenu.getUpload().getOriginalFilename()));
			newName = commandMenu.getPcafe_img();

		} else {
			// ���۵� ������ �ִ� ���
			commandMenu.setPcafe_img(newName);
			newName = commandMenu.getPcafe_img();

		}

		privateService.update(commandMenu);

		String u_uid = (String)session.getAttribute("u_uid");
		int pcafenum = commandMenu.getPcafe_num();
		
		PrivateLogCommand privateLogCommand = new PrivateLogCommand();
		
		privateLogCommand.setPcafe_num(pcafenum);
		privateLogCommand.setU_uid(u_uid);
		privateLogCommand.setP_log_change(2);
		privateLogCommand.setP_log_message("["+u_uid+"] ����ڰ� ["+pcafenum+"]�� Private Cafe ���� �����߽��ϴ�");
		
		privateService.insertLog(privateLogCommand);

		if (!commandMenu.getUpload().isEmpty()) {
			// ���۵� ������ ���� ���
			//File file = new File(FileUtil_Private.UPLOAD_PATH + "/" + commandMenu.getPcafe_img());
			
			File file = new File(FileUtil_Private.UPLOAD_PATH + "/" + newName);
			commandMenu.getUpload().transferTo(file);
			FileUtil_Private.createThumbnail(newName, newName, 720, 455);

			if (oldFileName != null) {
				// ���� ���� ����
				FileUtil_Private.removeFile(oldFileName);
			}

		}

		return "redirect:/admin/privatecafe/privatecafe-detail.do?pcafe_num=" + commandMenu.getPcafe_num();
	}

}

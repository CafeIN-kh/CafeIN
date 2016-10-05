package kr.cafein.admin.privatecafe.controller;



import java.util.List;

import javax.annotation.Resource;
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

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.domain.PrivateReplyCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.domain.LikeCommand;

@Controller
@SessionAttributes("adminprivatereply")
public class PrivateCafeReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-reply.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		System.out.println("==============");
		
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
		
		
		List<PrivateReplyCommand> selectReplyp = null;
		selectReplyp = privateService.selectReplyp(pcafe_num);	
		
		
		
		
		
		PrivateCommand adminprivatereply = privateService.selectBoard(pcafe_num);
		ModelAndView mav = new ModelAndView("adminPrivateReply");

		List<LikeCommand> getLikeUser = privateService.getLikeUser(pcafe_num);

		// ����ī���� �̹������� ����� ���� ����ī�� ���� ã��
		String pcafeImgName = adminprivatereply.getPcafe_img();
		String[] pcafeImgNameArray;

		// ���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
		pcafeImgNameArray = pcafeImgName.split(",");
		for (int i = 0; i < pcafeImgNameArray.length; i++) {
			// pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
			if (pcafeImgNameArray[i].indexOf("*") != -1) {
				// *�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
				// ��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
				pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*", "");
				adminprivatereply.setPcafe_img(pcafeImgNameArray[i]);
			}
		}

		// �ؽ��±�
		String hashTag = adminprivatereply.getPcafe_hash_tag();
		// ���� , ����� �ؽ��±� �信 ��ȯ
		String hashTagOriginal = adminprivatereply.getPcafe_hash_tag();
		// �ʱ�ȭ
		adminprivatereply.setPcafe_hash_tag("");
		String[] hashTagArray = hashTag.split(",");
		for (int i = 0; i < hashTagArray.length; i++) {
			// �ε��� �ȿ� , ���� ������ -1 ��ȯ
			if (hashTagArray[i].indexOf(",") != -1) {
				// *�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
				// ,ǥ�� �����ֱ�
				hashTagArray[i] = hashTagArray[i].replace(",", "");
			}
			adminprivatereply.setPcafe_hash_tag(adminprivatereply.getPcafe_hash_tag() + "#" + hashTagArray[i] + " ");
		}

		/* mav.addObject("list1", list1); */
		mav.addObject("adminprivatereply", adminprivatereply);
		mav.addObject("hashTagOriginal", hashTagOriginal);
		mav.addObject("getLikeUser", getLikeUser);
		mav.addObject("selectReplyp", selectReplyp);

		/* System.out.println(list1); */
		return mav;

	}
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-reply.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("adminprivatereply") @Valid PrivateCommand adminprivatereply, BindingResult result )throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("adminprivatereply : "+adminprivatereply);
		}
		
		if(result.hasErrors()){
			return "adminPrivateReply";
		}
		
		//adminCustomizingDetail
		
		
		
		
		
		PrivateCommand ccommand = null;
		
		
		ccommand = privateService.selectBoard(adminprivatereply.getPcafe_num());
	
				
		return "redirect:/admin/private/privatecafe-reply.do?pcafe_num=" + adminprivatereply.getPcafe_num();
	}
	
	
	
	
	

}

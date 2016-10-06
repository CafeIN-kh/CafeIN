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

		// 개인카페의 이미지들을 지우기 위해 개인카페 정보 찾기
		String pcafeImgName = adminprivatereply.getPcafe_img();
		String[] pcafeImgNameArray;

		// 문자열에 ,가 있다면 쪼개서 배열에 담기
		pcafeImgNameArray = pcafeImgName.split(",");
		for (int i = 0; i < pcafeImgNameArray.length; i++) {
			// pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
			if (pcafeImgNameArray[i].indexOf("*") != -1) {
				// *이 있다는 것이므로 *표를 빈값으로 대체
				// 대표이미지 찾아서 *표시 없애주기
				pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*", "");
				adminprivatereply.setPcafe_img(pcafeImgNameArray[i]);
			}
		}

		// 해쉬태그
		String hashTag = adminprivatereply.getPcafe_hash_tag();
		// 원래 , 적용된 해쉬태그 뷰에 반환
		String hashTagOriginal = adminprivatereply.getPcafe_hash_tag();
		// 초기화
		adminprivatereply.setPcafe_hash_tag("");
		String[] hashTagArray = hashTag.split(",");
		for (int i = 0; i < hashTagArray.length; i++) {
			// 인덱스 안에 , 값이 없으면 -1 반환
			if (hashTagArray[i].indexOf(",") != -1) {
				// *이 있다는 것이므로 *표를 빈값으로 대체
				// ,표시 없애주기
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

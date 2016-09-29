package kr.cafein.admin.customizingcafe.controller;



import java.io.File;
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

import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.domain.LikeCommand;
import kr.cafein.util.FileUtil_Private;

@Controller
@SessionAttributes("commandMenu")
public class AdminCustomizingListDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		System.out.println("==============");
		
		/*List<PrivateCommand> list1 = privateService.getPrivateDetailList(seq);*/
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
		PrivateCommand commandMenu = admincustomizingService.selectBoard(pcafe_num);
		ModelAndView mav = new ModelAndView("adminCustomizingDetail");
		
	
		
		
		
		List<LikeCommand> getLikeUser=admincustomizingService.getLikeUser(pcafe_num);
		
		
		
		
		
		
		//개인카페의 이미지들을 지우기 위해 개인카페 정보 찾기
        String pcafeImgName = commandMenu.getPcafe_img();
         String[] pcafeImgNameArray;
         
         //문자열에 ,가 있다면 쪼개서 배열에 담기
         pcafeImgNameArray = pcafeImgName.split(",");
         for (int i = 0; i < pcafeImgNameArray.length; i++) {
           //pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
           if(pcafeImgNameArray[i].indexOf("*") != -1){
              //*이 있다는 것이므로 *표를 빈값으로 대체
              //대표이미지 찾아서 *표시 없애주기
              pcafeImgNameArray[i] = pcafeImgNameArray[i].replace("*","");
              commandMenu.setPcafe_img(pcafeImgNameArray[i]);
           }
        }
         
         //해쉬태그
         String hashTag = commandMenu.getPcafe_hash_tag();
         //원래 , 적용된 해쉬태그 뷰에 반환
         String hashTagOriginal = commandMenu.getPcafe_hash_tag();
         //초기화
         commandMenu.setPcafe_hash_tag("");
         String[] hashTagArray = hashTag.split(",");
         for (int i = 0; i < hashTagArray.length; i++) {
           //인덱스 안에 , 값이 없으면 -1 반환
           if(hashTagArray[i].indexOf(",") != -1){
              //*이 있다는 것이므로 *표를 빈값으로 대체
              //,표시 없애주기
        	  hashTagArray[i] = hashTagArray[i].replace(",","");
           }
           commandMenu.setPcafe_hash_tag(commandMenu.getPcafe_hash_tag() + "#"+hashTagArray[i] + " ");
        }
         
		/*mav.addObject("list1", list1);*/
		mav.addObject("commandMenu", commandMenu);
		mav.addObject("hashTagOriginal", hashTagOriginal);
		mav.addObject("getLikeUser", getLikeUser);
		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandMenu") @Valid PrivateCommand commandMenu, BindingResult result )throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("commandMenu : "+commandMenu);
		}
		
		if(result.hasErrors()){
			return "adminCustomizingDetail";
		}
		
		PrivateCommand pcommand = null;
		String oldFileName = "";
		
		pcommand = admincustomizingService.selectBoard(commandMenu.getPcafe_num());
		
		oldFileName = pcommand.getPcafe_img();
		
		if(!commandMenu.getUpload().isEmpty()){
			//전송될 파일이 있는 경우
			commandMenu.setPcafe_img(FileUtil_Private.rename(commandMenu.getUpload().getOriginalFilename()));
			
		}else{
			//전송된 파일이 있는 경우
			commandMenu.setPcafe_img(oldFileName);
			
			
		}
		
		admincustomizingService.update(commandMenu);
		 
		 if(!commandMenu.getUpload().isEmpty()){
			 //전송된 파일이 있을 경우
			 File file = new File(FileUtil_Private.UPLOAD_PATH+"/"+commandMenu.getPcafe_img());
			 commandMenu.getUpload().transferTo(file);
			 
			 if(oldFileName != null){
				 //이전 파일 삭제
				 FileUtil_Private.removeFile(oldFileName);
			 }
			 
			 
		 }
				
		return "redirect:/admin/customizing/customizing-detail.do?pcafe_num=" + commandMenu.getPcafe_num();
	}
	
	
	
	
	

}

package kr.cafein.admin.customizingcafe.controller;



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

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingLogCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.domain.LikeCommand;
import kr.cafein.util.FileUtilCus;
import kr.cafein.util.FileUtil_Customizing;

@Controller
@SessionAttributes("admincustomizing")
public class AdminCustomizingListDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("custom_num") int custom_num)throws Exception{
		
		System.out.println("==============");
		
		/*List<PrivateCommand> list1 = privateService.getPrivateDetailList(seq);*/
		if(log.isDebugEnabled()){
			log.debug("custom_num : "+custom_num);
		}
		
		AdminCustomizingCommand admincustomizing = admincustomizingService.getCustomizing(custom_num);
		ModelAndView mav = new ModelAndView("adminCustomizingDetail");
		
	
		
		
		
		List<LikeCommand> getLikeUser1= admincustomizingService.getLikeUser(custom_num);
		
List<AdminCustomizingDetailCafeNameCommand> customizingDetailCafeNameCommand = null;
		
		customizingDetailCafeNameCommand = admincustomizingService.selectCafeMenu_Admin();
		
		
		
		
		
		
	
/*		AdminCustomizingDetailCommand  selectid =  admincustomizingService.selectCafeName_Admin();*/
		
		
		
		
		/*
		//개인카페의 이미지들을 지우기 위해 개인카페 정보 찾기
        String customImgName = admincustomizing.getCustom_img();
         String[] customImgNameArray;
         
         //문자열에 ,가 있다면 쪼개서 배열에 담기
         customImgNameArray = customImgName.split(",");
         for (int i = 0; i < customImgNameArray.length; i++) {
           //pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
           if(customImgNameArray[i].indexOf("*") != -1){
              //*이 있다는 것이므로 *표를 빈값으로 대체
              //대표이미지 찾아서 *표시 없애주기
        	   customImgNameArray[i] = customImgNameArray[i].replace("*","");
        	   admincustomizing.setCustom_img(customImgNameArray[i]);
           }
        }*/
         
		
         //해쉬태그
         String hashTag = admincustomizing.getCustom_hash_tag();
         //원래 , 적용된 해쉬태그 뷰에 반환
         String hashTagOriginal1 = admincustomizing.getCustom_hash_tag();
         //초기화
         admincustomizing.setCustom_hash_tag("");
         String[] hashTagArray = hashTag.split(",");
         for (int i = 0; i < hashTagArray.length; i++) {
           //인덱스 안에 , 값이 없으면 -1 반환
           if(hashTagArray[i].indexOf(",") != -1){
              //*이 있다는 것이므로 *표를 빈값으로 대체
              //,표시 없애주기
        	  hashTagArray[i] = hashTagArray[i].replace(",","");
           }
           admincustomizing.setCustom_hash_tag(admincustomizing.getCustom_hash_tag() + "#"+hashTagArray[i] + " ");
        }
        
        Integer franchise_num = admincustomizingService.selectFranchise_num(custom_num);
        
        String franchise_name = admincustomizingService.selectCafeName_Admin(franchise_num);
         
		/*mav.addObject("list1", list1);*/
		mav.addObject("admincustomizing", admincustomizing);
		mav.addObject("hashTagOriginal1", hashTagOriginal1);
		mav.addObject("getLikeUser1", getLikeUser1);
//		mav.addObject("selectid", selectid);
		mav.addObject("customizingDetailCafeNameCommand", customizingDetailCafeNameCommand);
		mav.addObject("franchise_name", franchise_name);

		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("admincustomizing") @Valid AdminCustomizingCommand admincustomizing, BindingResult result ,HttpSession session)throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("admincustomizing : "+admincustomizing);
		}
		
		if(result.hasErrors()){
			return "adminCustomizingDetail";
		}
		
		
		AdminCustomizingCommand ccommand = null;
		String oldFileName = "";
		
		ccommand = admincustomizingService.getCustomizing(admincustomizing.getCustom_num());
		
		oldFileName = ccommand.getCustom_img();
		
		String newName="";
		newName = admincustomizing.getCustom_img();
		
		if(!admincustomizing.getUpload().isEmpty()){
			//전송될 파일이 있는 경우
			admincustomizing.setCustom_img(FileUtilCus.rename(admincustomizing.getUpload().getOriginalFilename()));
			newName = admincustomizing.getCustom_img();
			
		}else{
			//전송된 파일이 있는 경우
			admincustomizing.setCustom_img(newName);
			newName = admincustomizing.getCustom_img();
			
		}
		
		admincustomizingService.update(admincustomizing);
		
		String u_uid = (String)session.getAttribute("u_uid");
		int custom_num = admincustomizing.getCustom_num();
		
		AdminCustomizingLogCommand adminCustomizingLogCommand = new AdminCustomizingLogCommand();
		
		adminCustomizingLogCommand.setCustom_num(custom_num);
		adminCustomizingLogCommand.setU_uid(u_uid);
		adminCustomizingLogCommand.setC_log_change(2);
		adminCustomizingLogCommand.setC_log_message("["+u_uid+"] 사용자가 ["+custom_num+"]의 Customizing 글을 수정했습니다");
		
		admincustomizingService.insertLog(adminCustomizingLogCommand);
		
		 if(!admincustomizing.getUpload().isEmpty()){
			 //전송된 파일이 있을 경우
			 //File file = new File(FileUtil_Customizing.UPLOAD_PATH+"/"+admincustomizing.getCustom_img());
			 File file = new File(FileUtilCus.UPLOAD_PATH+"/"+newName);
			 admincustomizing.getUpload().transferTo(file);
			 FileUtilCus.createThumbnail(newName, newName, 720, 455);
			 
			 if(oldFileName != null){
				 //이전 파일 삭제
				 FileUtil_Customizing.removeFile(oldFileName);
			 }
			 
			 
		 }
				
		return "redirect:/admin/customizing/customizing-detail.do?custom_num=" + admincustomizing.getCustom_num();
	}
	
	
	
	
	

}

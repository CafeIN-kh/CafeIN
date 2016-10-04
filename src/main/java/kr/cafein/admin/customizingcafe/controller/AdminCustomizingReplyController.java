package kr.cafein.admin.customizingcafe.controller;



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
import kr.cafein.domain.LikeCommand;

@Controller
@SessionAttributes("admincustomizingreply")
public class AdminCustomizingReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="admincustomizingService")
	private AdminCustomizingService admincustomizingService;
	
	
	@RequestMapping(value="/admin/customizing/customizing-reply.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("custom_num") int custom_num)throws Exception{
		
		System.out.println("==============");
		
		if(log.isDebugEnabled()){
			log.debug("custom_num : "+custom_num);
		}
		
		
		
		AdminCustomizingCommand admincustomizingreply = admincustomizingService.getCustomizing(custom_num);
		ModelAndView mav = new ModelAndView("adminCustomizingReply");
		//adminCustomizingDetail
		List<LikeCommand> getLikeUser1= admincustomizingService.getLikeUser(custom_num);
List<AdminCustomizingDetailCafeNameCommand> customizingDetailCafeNameCommand = null;	
		customizingDetailCafeNameCommand = admincustomizingService.selectCafeMenu_Admin();
		List<AdminCustomizingReplyCommand> admincustomizingre = null;
		admincustomizingre = admincustomizingService.selectReplyc(custom_num);	
	
         //해쉬태그
         String hashTag = admincustomizingreply.getCustom_hash_tag();
         //원래 , 적용된 해쉬태그 뷰에 반환
         String hashTagOriginal1 = admincustomizingreply.getCustom_hash_tag();
         //초기화
         admincustomizingreply.setCustom_hash_tag("");
         String[] hashTagArray = hashTag.split(",");
         for (int i = 0; i < hashTagArray.length; i++) {
           //인덱스 안에 , 값이 없으면 -1 반환
           if(hashTagArray[i].indexOf(",") != -1){
              //*이 있다는 것이므로 *표를 빈값으로 대체
              //,표시 없애주기
        	  hashTagArray[i] = hashTagArray[i].replace(",","");
           }
           admincustomizingreply.setCustom_hash_tag(admincustomizingreply.getCustom_hash_tag() + "#"+hashTagArray[i] + " ");
        }
        
        Integer franchise_num = admincustomizingService.selectFranchise_num(custom_num);
        
        String franchise_name = admincustomizingService.selectCafeName_Admin(franchise_num);
         
		mav.addObject("admincustomizingreply", admincustomizingreply);
		mav.addObject("hashTagOriginal1", hashTagOriginal1);
		mav.addObject("getLikeUser1", getLikeUser1);
		mav.addObject("customizingDetailCafeNameCommand", customizingDetailCafeNameCommand);
		mav.addObject("franchise_name", franchise_name);
		mav.addObject("admincustomizingre", admincustomizingre);
		

		return mav;

		
	}
	
	@RequestMapping(value="/admin/customizing/customizing-reply.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("admincustomizingreply") @Valid AdminCustomizingCommand admincustomizingreply, BindingResult result )throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("admincustomizingreply : "+admincustomizingreply);
		}
		
		if(result.hasErrors()){
			return "adminCustomizingReply";
		}
		
		//adminCustomizingDetail
		
		
		
		
		
		AdminCustomizingCommand ccommand = null;
		
		ccommand = admincustomizingService.getCustomizing(admincustomizingreply.getCustom_num());
		
		
		
		 
	
				
		return "redirect:/admin/customizing/customizing-reply.do?custom_num=" + admincustomizingreply.getCustom_num();
	}
	
	
	
	
	

}

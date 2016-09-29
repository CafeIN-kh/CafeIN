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

import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.domain.LikeCommand;
import kr.cafein.util.FileUtil_Private;

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
		
		AdminCustomizingCommand admincustomizing = admincustomizingService.selectCustomizing(custom_num);
		ModelAndView mav = new ModelAndView("adminCustomizingDetail");
		
	
		
		
		
		List<LikeCommand> getLikeUser=admincustomizingService.getLikeUser(custom_num);
		
		
		
		
		
		
		//����ī���� �̹������� ����� ���� ����ī�� ���� ã��
        String customImgName = admincustomizing.getCustom_img();
         String[] customImgNameArray;
         
         //���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
         customImgNameArray = customImgName.split(",");
         for (int i = 0; i < customImgNameArray.length; i++) {
           //pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
           if(customImgNameArray[i].indexOf("*") != -1){
              //*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
              //��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
        	   customImgNameArray[i] = customImgNameArray[i].replace("*","");
        	   admincustomizing.setCustom_img(customImgNameArray[i]);
           }
        }
         
         //�ؽ��±�
         String hashTag = admincustomizing.getCustom_hash_tag();
         //���� , ����� �ؽ��±� �信 ��ȯ
         String hashTagOriginal = admincustomizing.getCustom_hash_tag();
         //�ʱ�ȭ
         admincustomizing.setCustom_hash_tag("");
         String[] hashTagArray = hashTag.split(",");
         for (int i = 0; i < hashTagArray.length; i++) {
           //�ε��� �ȿ� , ���� ������ -1 ��ȯ
           if(hashTagArray[i].indexOf(",") != -1){
              //*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
              //,ǥ�� �����ֱ�
        	  hashTagArray[i] = hashTagArray[i].replace(",","");
           }
           admincustomizing.setCustom_hash_tag(admincustomizing.getCustom_hash_tag() + "#"+hashTagArray[i] + " ");
        }
         
		/*mav.addObject("list1", list1);*/
		mav.addObject("commandMenu", admincustomizing);
		mav.addObject("hashTagOriginal", hashTagOriginal);
		mav.addObject("getLikeUser", getLikeUser);
		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandMenu") @Valid AdminCustomizingCommand commandMenu, BindingResult result )throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("commandMenu : "+commandMenu);
		}
		
		if(result.hasErrors()){
			return "adminCustomizingDetail";
		}
		
		AdminCustomizingCommand ccommand = null;
		String oldFileName = "";
		
		ccommand = admincustomizingService.selectCustomizing(commandMenu.getCustom_num());
		
		oldFileName = ccommand.getCustom_img();
		
		if(!commandMenu.getUpload().isEmpty()){
			//���۵� ������ �ִ� ���
			commandMenu.setCustom_img(FileUtil_Private.rename(commandMenu.getUpload().getOriginalFilename()));
			
		}else{
			//���۵� ������ �ִ� ���
			commandMenu.setCustom_img(oldFileName);
			
			
		}
		
		admincustomizingService.update(commandMenu);
		 
		 if(!commandMenu.getUpload().isEmpty()){
			 //���۵� ������ ���� ���
			 File file = new File(FileUtil_Private.UPLOAD_PATH+"/"+commandMenu.getCustom_img());
			 commandMenu.getUpload().transferTo(file);
			 
			 if(oldFileName != null){
				 //���� ���� ����
				 FileUtil_Private.removeFile(oldFileName);
			 }
			 
			 
		 }
				
		return "redirect:/admin/customizing/customizing-detail.do?custom_num=" + commandMenu.getCustom_num();
	}
	
	
	
	
	

}

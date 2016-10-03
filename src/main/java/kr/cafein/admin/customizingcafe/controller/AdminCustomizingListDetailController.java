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
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.service.AdminCustomizingService;
import kr.cafein.domain.LikeCommand;
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
		
		
		
		
		
		
		
		/*
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
        }*/
         
		
         //�ؽ��±�
         String hashTag = admincustomizing.getCustom_hash_tag();
         //���� , ����� �ؽ��±� �信 ��ȯ
         String hashTagOriginal1 = admincustomizing.getCustom_hash_tag();
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
		mav.addObject("admincustomizing", admincustomizing);
		mav.addObject("hashTagOriginal1", hashTagOriginal1);
		mav.addObject("getLikeUser1", getLikeUser1);
		mav.addObject("customizingDetailCafeNameCommand", customizingDetailCafeNameCommand);

		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/customizing/customizing-detail.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("admincustomizing") @Valid AdminCustomizingCommand admincustomizing, BindingResult result )throws Exception{
	
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
		
		if(!admincustomizing.getUpload().isEmpty()){
			//���۵� ������ �ִ� ���
			admincustomizing.setCustom_img(FileUtil_Customizing.rename(admincustomizing.getUpload().getOriginalFilename()));
			
		}else{
			//���۵� ������ �ִ� ���
			admincustomizing.setCustom_img(oldFileName);
			
			
		}
		
		admincustomizingService.update(admincustomizing);
		 
		 if(!admincustomizing.getUpload().isEmpty()){
			 //���۵� ������ ���� ���
			 File file = new File(FileUtil_Customizing.UPLOAD_PATH+"/"+admincustomizing.getCustom_img());
			 admincustomizing.getUpload().transferTo(file);
			 
			 if(oldFileName != null){
				 //���� ���� ����
				 FileUtil_Customizing.removeFile(oldFileName);
			 }
			 
			 
		 }
				
		return "redirect:/admin/customizing/customizing-detail.do?custom_num=" + admincustomizing.getCustom_num();
	}
	
	
	
	
	

}

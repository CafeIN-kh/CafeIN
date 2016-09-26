package kr.cafein.admin.privatecafe.controller;



import java.io.File;

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

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.util.FileUtil_Private;

@Controller
@SessionAttributes("commandMenu")
public class PrivateListDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-detail.do",method=RequestMethod.GET)
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		System.out.println("==============");
		
		/*List<PrivateCommand> list1 = privateService.getPrivateDetailList(seq);*/
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
		PrivateCommand commandMenu = privateService.selectBoard(pcafe_num);
		ModelAndView mav = new ModelAndView("adminPrivateDetail");
		/*mav.addObject("list1", list1);*/
		mav.addObject("commandMenu", commandMenu);
		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-detail.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandMenu") @Valid PrivateCommand commandMenu, BindingResult result )throws Exception{
	
		if(log.isDebugEnabled()){
			log.debug("commandMenu : "+commandMenu);
		}
		
		if(result.hasErrors()){
			return "adminPrivateDetail";
		}
		
		
		PrivateCommand pcommand = null;
		String oldFileName = "";
		
		pcommand = privateService.selectBoard(commandMenu.getPcafe_num());
		
		oldFileName = pcommand.getPcafe_img();
		
		if(!commandMenu.getUpload().isEmpty()){
			//전송될 파일이 있는 경우
			commandMenu.setPcafe_img(FileUtil_Private.rename(commandMenu.getUpload().getOriginalFilename()));
			
		}else{
			//전송된 파일이 있는 경우
			commandMenu.setPcafe_img(oldFileName);
			
			
		}
		
		 privateService.update(commandMenu);
		 
		 if(!commandMenu.getUpload().isEmpty()){
			 //전송된 파일이 있을 경우
			 File file = new File(FileUtil_Private.UPLOAD_PATH+"/"+commandMenu.getPcafe_img());
			 commandMenu.getUpload().transferTo(file);
			 
			 if(oldFileName != null){
				 //이전 파일 삭제
				 FileUtil_Private.removeFile(oldFileName);
			 }
			 
			 
		 }
				
		return "redirect:/admin/privatecafe/privatecafe-detail.do?pcafe_num=" + commandMenu.getPcafe_num();
	}
	
	
	
	
	

}

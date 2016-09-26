/*package kr.cafein.admin.privatecafe.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;
import kr.cafein.util.FileUtil;

@Controller
@SessionAttributes("commandMenu")
public class PrivateUpdateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService privateService;
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-modify.do",method=RequestMethod.GET)
	public String form(@RequestParam("pcafe_num") int pcafe_num, Model model){
		System.out.println(pcafe_num);
		PrivateCommand privateCommand = privateService.selectBoard(pcafe_num);
		System.out.println(privateCommand);
		model.addAttribute("privateCommand", privateCommand);
	
		return "adminPrivateDetail";
	}	
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-modify.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("commandMenu") @Valid PrivateCommand privateCommand, BindingResult result )throws Exception{
	
	if(log.isDebugEnabled()){
		log.debug("privateCommand : "+privateCommand);
	}
	
	if(result.hasErrors()){
		return "adminPrivateDetail";
	}
	
	PrivateCommand pcommand = null;
	String oldFileName = "";
	
	pcommand = privateService.selectBoard(privateCommand.getPcafe_num());
	
	oldFileName = pcommand.getPcafe_img();
	
	if(!privateCommand.getUpload().isEmpty()){
		//전송될 파일이 있는 경우
		privateCommand.setPcafe_img(FileUtil.rename(privateCommand.getUpload().getOriginalFilename()));
	}else{
		//전송된 파일이 있는 경우
		privateCommand.setPcafe_img(oldFileName);
		
		
	}
	
	 privateService.update(privateCommand);
	 
	 if(!privateCommand.getUpload().isEmpty()){
		 //전송된 파일이 있을 경우
		 File file = new File(FileUtil.UPLOAD_PATH+"/"+privateCommand.getPcafe_img());
		 privateCommand.getUpload().transferTo(file);
		 if(oldFileName != null){
			 //이전 파일 삭제
			 FileUtil.removeFile(oldFileName);
		 }
		 
		 
	 }
		
	
	
	
	
	
	
	
	
	
	
	
		
		return "redirect:/admin/private/privatecafe-detail.do?pcafe_num=" + privateCommand.getPcafe_num();
		
	}

}*/
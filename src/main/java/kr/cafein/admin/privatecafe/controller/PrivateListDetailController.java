package kr.cafein.admin.privatecafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
@SessionAttributes("commandMenu")
public class PrivateListDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	
	@RequestMapping("/admin/privatecafe/privatecafe-detail.do")
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		System.out.println("==============");
		
		/*List<PrivateCommand> list1 = privateService.getPrivateDetailList(seq);*/
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
		PrivateCommand privateCommand = privateService.selectBoard(pcafe_num);
		ModelAndView mav = new ModelAndView("adminPrivateDetail");
		/*mav.addObject("list1", list1);*/
		mav.addObject("privateCommand", privateCommand);
		System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		/*System.out.println(list1);*/
		return mav;

		
	}
	
	@RequestMapping(value="/admin/privatecafe/privatecafe-detail.do",method=RequestMethod.POST)
	public String submit(){
		return "redirect:/privatecafe/privatecafe-detail.do";
	}

}

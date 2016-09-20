package kr.cafein.admin.privatecafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateCafeMenuListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="privateService")
	private PrivateService privateService;
	
	
	@RequestMapping("/admin/privatecafe/privatecafemenu.do")
	public ModelAndView process(@RequestParam("pcafe_num") int pcafe_num)throws Exception{
		
		System.out.println("==============");
		
		List<PrivateMenuCommand> listmenu = privateService.getPrivateCafeMenuList(pcafe_num);
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
		
		
		PrivateCommand privateCommandmenu = privateService.selectBoard(pcafe_num);
		
		
		ModelAndView mav = new ModelAndView("adminPrivateCafeMenu");
		mav.addObject("listmenu", listmenu);
		
		mav.addObject("privateCommandmenu", privateCommandmenu);
		
		System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		/*System.out.println(list1);*/
		return mav;

		
	}

}

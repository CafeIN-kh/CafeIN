package kr.cafein.admin.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.main.domain.AdminMainCountCommand;
import kr.cafein.admin.main.domain.AdminMainCustomizingCommand;
import kr.cafein.admin.main.domain.AdminMainFranchiseCommand;
import kr.cafein.admin.main.domain.AdminMainNoticeCommand;
import kr.cafein.admin.main.domain.AdminMainPrivateCommand;
import kr.cafein.admin.main.service.AdminMainService;

@Controller
public class AdminMainController {
	
	private Logger log = Logger.getLogger(getClass());

	@Resource 
	private AdminMainService adminMainService;

	@RequestMapping("/admin/main.do")
	public ModelAndView adminMain() {
		
		List<AdminMainNoticeCommand> noticeList = null;
		
		noticeList = adminMainService.selectNotice();
		
		if(log.isDebugEnabled()){
			log.debug("noticeList : " + noticeList);
		}
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("adminMain");
	      mav.addObject("noticeList",noticeList);
	     
	      return mav;
	}
	
	@RequestMapping(value="/admin/franchiseTotalCount.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> franchiseTotalCount()throws Exception{
	
		System.out.println("franchiseTotalCount.do ¡¯¿‘");
		
		List<AdminMainFranchiseCommand> adminMainFranchiseCommand = null;
		
		adminMainFranchiseCommand = adminMainService.franchiseTotalCount();
		
		if(log.isDebugEnabled()){
			log.debug("adminMainCommand : " + adminMainFranchiseCommand);
		}
		
		List<AdminMainPrivateCommand> adminMainPrivateCommand = null;
		
		adminMainPrivateCommand = adminMainService.privateTotalCount();
		
		if(log.isDebugEnabled()){
			log.debug("adminMainPrivateCommand : " + adminMainPrivateCommand);
		}
		
		List<AdminMainCustomizingCommand> adminMainCustomizingCommand = null;
		adminMainCustomizingCommand = adminMainService.customTotalCount();

		if(log.isDebugEnabled()){
			log.debug("adminMainCustomizingCommand : " + adminMainCustomizingCommand);
		}
		
		int pageTotal = adminMainService.pageTotal();
		int franchiseTotal = adminMainService.franchiseTotal();
		int privateTotal = adminMainService.privateTotal();
		int customTotal = adminMainService.customizingTotal();
		
		List<AdminMainCountCommand> franchiseCountCommand = null;
		
		franchiseCountCommand = adminMainService.franchiseCount();
		
		if(log.isDebugEnabled()){
			log.debug("franchiseCountCommand : " + franchiseCountCommand);
		}
		
		if(log.isDebugEnabled()){
			log.debug("franchiseTotal : " + franchiseTotal);
		}
		
		List<AdminMainCountCommand> privateCountCommand = null;
		
		privateCountCommand = adminMainService.privateCount();
		
		if(log.isDebugEnabled()){
			log.debug("privateCountCommand : " + privateCountCommand);
		}
		
		List<AdminMainCountCommand> customCountCommand = null;
		
		customCountCommand = adminMainService.customCount();
		
		if(log.isDebugEnabled()){
			log.debug("customCountCommand : " + customCountCommand);
		}

		List<AdminMainCountCommand> pmenuCountCommand = null;
		
		pmenuCountCommand = adminMainService.pmenuCount();
		
		if(log.isDebugEnabled()){
			log.debug("pmenuCountCommand : " + pmenuCountCommand);
		}
		
		List<AdminMainCountCommand> fmenuCountCommand = null;
		
		fmenuCountCommand = adminMainService.fmenuCount();
		
		if(log.isDebugEnabled()){
			log.debug("fmenuCountCommand : " + fmenuCountCommand);
		}

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("adminMainFranchiseCommand", adminMainFranchiseCommand);
		map.put("adminMainPrivateCommand", adminMainPrivateCommand);
		map.put("adminMainCustomizingCommand", adminMainCustomizingCommand);
		map.put("franchiseCountCommand", franchiseCountCommand);
		map.put("privateCountCommand", privateCountCommand);
		map.put("customCountCommand", customCountCommand);
		map.put("pmenuCountCommand", pmenuCountCommand);
		map.put("fmenuCountCommand", fmenuCountCommand);
		map.put("pageTotal", pageTotal);
		map.put("franchiseTotal", franchiseTotal);
		map.put("privateTotal", privateTotal);
		map.put("customTotal", customTotal);
		
		return map;
	}

}

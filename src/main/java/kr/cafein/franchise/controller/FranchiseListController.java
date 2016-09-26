package kr.cafein.franchise.controller;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.service.FranchiseService;


@Controller
public class FranchiseListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/franchise_main.do")
	public ModelAndView process(){
		List<FC_FranchiseCommand> list = franchiseService.list();
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
	    userCountLogCommand = franchiseService.selectFCafeUserCountLogByDate(); 
	    if(userCountLogCommand == null) {
	       log.debug("★★★오늘날짜 페이지뷰 로우 없으므로 insert");
	       franchiseService.insertFCafeUserCountLog();
	    }else {
	       log.debug("★★★오늘날자 페이지뷰 로우 있으므로 update, 전체카운트와 개인카페 카운트+1");
	       franchiseService.updateFCafeUserCountLog();
	    }
		ModelAndView mav = new ModelAndView("franchise_main");
		mav.addObject("list", list);
		return mav;  
	}
}
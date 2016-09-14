package kr.cafein.franchise.controller;


import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.service.FranchiseService;


@Controller
public class FranchiseListController {
	
	@Resource
	private FranchiseService franchiseService;
	
	@RequestMapping("/cafein_user/franchise/franchise_main.do")
	public ModelAndView process(){
		List<FC_FranchiseCommand> list = franchiseService.list();
		ModelAndView mav = new ModelAndView("franchise_main");
		mav.addObject("list", list);
		return mav;  
	}
}
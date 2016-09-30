package kr.cafein.admin.franchise.chart.controller;



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

import kr.cafein.admin.franchise.chart.domain.AdminFranchiseBookmarkCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseChartCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseDeClaredCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseLikeCommand;
import kr.cafein.admin.franchise.chart.service.AdminFranchiseChartService;



@Controller
public class AdminFranchiseChartController {
	private Logger log = Logger.getLogger(getClass());
	
	@Resource
	private AdminFranchiseChartService adminfranchiseChartService;
	
	@RequestMapping("/admin/franchise_charts.do")
	public ModelAndView franchiseChart() {
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("franchisechart");
	      //mav.addObject("fpvCount",fpvCount);
	      return mav;
	}
	
	@RequestMapping(value="/admin/franchise_pageCount.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> franchiseTotalCount()throws Exception{
		
		System.out.println("franchiseTotalCount.do ¡¯¿‘");
		
		int fpvCount = adminfranchiseChartService.franchisePageViewTotal();
		
		List<AdminFranchiseChartCommand> franchisePV = null;
		
		franchisePV = adminfranchiseChartService.pageViewCount();

		if(log.isDebugEnabled()){
			log.debug("franchisePV : " + franchisePV);
		}
		
		
		if(log.isDebugEnabled()){
			log.debug("fpvCount : " + fpvCount);
		}

		List<AdminFranchiseLikeCommand> fLikeDayCount = null;
		
		fLikeDayCount = adminfranchiseChartService.franchiseLikeDayCount();
		
		
		if(log.isDebugEnabled()){
			log.debug("fLikeDayCount : " + fLikeDayCount);
		}
		
		List<AdminFranchiseLikeCommand> fmenuLikeDayCount = null;
		
		fmenuLikeDayCount = adminfranchiseChartService.franchiseMenuLikeDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("fmenuLikeDayCount : " + fmenuLikeDayCount);
		}
		
		List<AdminFranchiseLikeCommand> fLikeWeekCount = null;
		
		fLikeWeekCount = adminfranchiseChartService.franchiseLikeMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("fLikeWeekCount : " + fLikeWeekCount);
		}
		
		List<AdminFranchiseLikeCommand> fmenuLikeWeekCount = null;
		
		fmenuLikeWeekCount = adminfranchiseChartService.franchiseLikeMenuMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("fmenuLikeWeekCount : " + fmenuLikeWeekCount);
		}
		
		List<AdminFranchiseBookmarkCommand> fbookmarkDayCount = null;
		
		fbookmarkDayCount = adminfranchiseChartService.franchiseBookmarkDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("fbookmarkDayCount : " + fbookmarkDayCount);
		}
		
		List<AdminFranchiseBookmarkCommand> fbookmarkWeekCount = null;
		
		fbookmarkWeekCount = adminfranchiseChartService.franchiseBookmarkMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("fbookmarkWeekCount : " + fbookmarkWeekCount);
		}
		List<AdminFranchiseDeClaredCommand> fDeclaredCount = null;
		
		fDeclaredCount = adminfranchiseChartService.franchiseDeClaredCount();
		
		if(log.isDebugEnabled()){
			log.debug("fDeclaredCount : " + fDeclaredCount);
		}
		
		int fDeClaredTotal = adminfranchiseChartService.fDeClaredCountToTal();
		
		if(log.isDebugEnabled()){
			log.debug("fDeClaredTotal : " + fDeClaredTotal);
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("franchisePV", franchisePV);
		map.put("fpvCount", fpvCount);
		map.put("fLikeDayCount", fLikeDayCount);
		map.put("fmenuLikeDayCount", fmenuLikeDayCount);
		map.put("fLikeWeekCount", fLikeWeekCount);
		map.put("fmenuLikeWeekCount", fmenuLikeWeekCount);
		map.put("fbookmarkDayCount", fbookmarkDayCount);
		map.put("fbookmarkWeekCount", fbookmarkWeekCount);
		map.put("fDeclaredCount", fDeclaredCount);
		map.put("fDeClaredTotal", fDeClaredTotal);
		return map;
	}
}

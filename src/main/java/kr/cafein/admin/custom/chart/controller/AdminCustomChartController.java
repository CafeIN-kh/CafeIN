package kr.cafein.admin.custom.chart.controller;

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

import kr.cafein.admin.custom.chart.domain.AdminCustomBookmarkCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomChartCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomDeClaredCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomLikeCommand;
import kr.cafein.admin.custom.chart.service.AdminCustomChartService;

@Controller
public class AdminCustomChartController {
	private Logger log = Logger.getLogger(getClass());
	
	@Resource
	private AdminCustomChartService adminCustomChartService;
	
	@RequestMapping("/admin/custom_charts.do")
	public ModelAndView customChart() {
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("customchart");
	      //mav.addObject("fpvCount",fpvCount);
	      return mav;
	}
	@RequestMapping(value="/admin/custom_Count.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> customTotalCount() throws Exception{
		
		System.out.println("customTotalCount ¡¯¿‘");
		
		int cpvCount = adminCustomChartService.customPageViewTotal();
		
		List<AdminCustomChartCommand> customPV = null;
		
		customPV = adminCustomChartService.pageViewCustomCount();
	
		if(log.isDebugEnabled()){
			log.debug("cpvCount : " + cpvCount);
		}
		
		
		if(log.isDebugEnabled()){
			log.debug("customPV : " + customPV);
		}
		
		List<AdminCustomLikeCommand> cLikeDayCount = null;
		
		cLikeDayCount = adminCustomChartService.customLikeDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("cLikeDayCount : " + cLikeDayCount);
		}
		
		List<AdminCustomLikeCommand> cLikeMonthCount = null;
		
		cLikeMonthCount = adminCustomChartService.customLikeMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("cLikeMonthCount : " + cLikeMonthCount);
		}
		
		List<AdminCustomBookmarkCommand> cBookmarkDayCount = null;
		
		cBookmarkDayCount = adminCustomChartService.customBookmarkDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("cBookmarkDayCount : " + cBookmarkDayCount);
		}
		
		List<AdminCustomBookmarkCommand> cBookmarkMonthCount = null;
		
		cBookmarkMonthCount = adminCustomChartService.customBookmarkMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("cBookmarkMonthCount : " + cBookmarkMonthCount);
		}
		
		List<AdminCustomDeClaredCommand> cDeClaredCount = null;
		
		cDeClaredCount = adminCustomChartService.cDeClaredCount();
		
		if(log.isDebugEnabled()){
			log.debug("cDeClaredCount : " + cDeClaredCount);
		}
		
		int cDeClaredTotal = adminCustomChartService.cDeClaredCountToTal();
		
		if(log.isDebugEnabled()){
			log.debug("cDeClaredTotal : " + cDeClaredTotal);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cpvCount", cpvCount);
		map.put("customPV", customPV);
		map.put("cLikeDayCount", cLikeDayCount);
		map.put("cLikeMonthCount", cLikeMonthCount);
		map.put("cBookmarkDayCount", cBookmarkDayCount);
		map.put("cBookmarkMonthCount", cBookmarkMonthCount);
		map.put("cDeClaredCount", cDeClaredCount);
		map.put("cDeClaredTotal", cDeClaredTotal);
		return map;
	}
}

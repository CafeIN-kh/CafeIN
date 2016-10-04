package kr.cafein.admin.pcafe.chart.controller;



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

import kr.cafein.admin.pcafe.chart.dao.AdminPcafeChartMapper;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeBookmarkCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeChartCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeDeClaredCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeLikeCommand;
import kr.cafein.admin.pcafe.chart.service.AdminPcafeChartService;



@Controller
public class AdminPCafeChartController {

	private Logger log = Logger.getLogger(getClass());
	
	@Resource
	private AdminPcafeChartService adminPcafeChartService;	
	
	@RequestMapping("/admin/private_charts.do")
	public ModelAndView privateChart() {
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("privatechart");
	      //mav.addObject("fpvCount",fpvCount);
	      return mav;
	}
	
	@RequestMapping(value="/admin/pcafe_Count.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pCafeTotalCount()throws Exception{
		System.out.println("pcafeTotaclCount ¡¯¿‘");
		
		int ppvCount = adminPcafeChartService.pcafePageViewTotal();
		
		List<AdminPcafeChartCommand> pCafePV = null;
		
		pCafePV = adminPcafeChartService.pageViewPcafeCount();
		
		if(log.isDebugEnabled()){
			log.debug("pCafePV : " + pCafePV);
		}
		
		
		if(log.isDebugEnabled()){
			log.debug("ppvCount : " + ppvCount);
		}

		List<AdminPcafeLikeCommand> pLikeDayCount = null;
		
		pLikeDayCount = adminPcafeChartService.pCafeLikeDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("pLikeDayCount : " + pLikeDayCount);
		}
		
		List<AdminPcafeLikeCommand> pmenuLikeDayCount = null;
		
		pmenuLikeDayCount = adminPcafeChartService.pCafeMenuLikeDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("pmenuLikeDayCount : " + pmenuLikeDayCount);
		}
		
		
		List<AdminPcafeLikeCommand> pLikeMonthCount = null;
		
		pLikeMonthCount = adminPcafeChartService.pCafeLikeMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("pLikeMonthCount : " + pLikeMonthCount);
		}
		
		
		
		List<AdminPcafeLikeCommand> pmenuLikeMonthCount = null;
		
		pmenuLikeMonthCount = adminPcafeChartService.pCafeLikeMenuMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("pmenuLikeMonthCount : " + pmenuLikeMonthCount);
		}
		
		List<AdminPcafeBookmarkCommand> pBookmarkDayCount = null;
		
		pBookmarkDayCount = adminPcafeChartService.pcafeBookmarkDayCount();
		
		if(log.isDebugEnabled()){
			log.debug("pBookmarkDayCount : " + pBookmarkDayCount);
		}
		
		List<AdminPcafeBookmarkCommand> pBookmarkMonthCount = null;
		
		pBookmarkMonthCount = adminPcafeChartService.pcafeBookmarkMonthCount();
		
		if(log.isDebugEnabled()){
			log.debug("pBookmarkMonthCount : " + pBookmarkMonthCount);
		}
		
		List<AdminPcafeDeClaredCommand> pDeClaredCount = null;
		
		pDeClaredCount = adminPcafeChartService.pcafeDeClaredCount();
		
		if(log.isDebugEnabled()){
			log.debug("pDeClaredCount : " + pDeClaredCount);
		}
		
		int pDeClaredTotal = adminPcafeChartService.pDeClaredCountToTal();
		
		if(log.isDebugEnabled()){
			log.debug("pDeClaredTotal : " + pDeClaredTotal);
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pCafePV", pCafePV);
		map.put("ppvCount", ppvCount);
		map.put("pLikeDayCount", pLikeDayCount);
		map.put("pmenuLikeDayCount", pmenuLikeDayCount);
		map.put("pLikeMonthCount", pLikeMonthCount);
		map.put("pmenuLikeMonthCount", pmenuLikeMonthCount);
		map.put("pBookmarkDayCount", pBookmarkDayCount);
		map.put("pBookmarkMonthCount", pBookmarkMonthCount);
		map.put("pDeClaredCount", pDeClaredCount);
		map.put("pDeClaredTotal", pDeClaredTotal);
		return map;
	}
}

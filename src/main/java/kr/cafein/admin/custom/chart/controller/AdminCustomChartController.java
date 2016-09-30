package kr.cafein.admin.custom.chart.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminCustomChartController {
	private Logger log = Logger.getLogger(getClass());
	
	
	@RequestMapping("/admin/custom_charts.do")
	public ModelAndView customChart() {
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("customchart");
	      //mav.addObject("fpvCount",fpvCount);
	      return mav;
	}
}

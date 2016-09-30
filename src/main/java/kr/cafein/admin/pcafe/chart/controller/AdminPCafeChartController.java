package kr.cafein.admin.pcafe.chart.controller;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminPCafeChartController {

	private Logger log = Logger.getLogger(getClass());
	
	
	@RequestMapping("/admin/private_charts.do")
	public ModelAndView privateChart() {
		
		ModelAndView mav = new ModelAndView();
	      mav.setViewName("privatechart");
	      //mav.addObject("fpvCount",fpvCount);
	      return mav;
	}
}

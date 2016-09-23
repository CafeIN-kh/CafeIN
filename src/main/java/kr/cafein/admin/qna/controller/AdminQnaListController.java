package kr.cafein.admin.qna.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.qna.domain.AdminQnaCommand;
import kr.cafein.admin.qna.service.AdminQnaService;

@Controller
public class AdminQnaListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminQnaService")
	private AdminQnaService adminQnaService;
	
	@RequestMapping("/cafein_admin/qna/List.do")
	public ModelAndView process(){
		List<AdminQnaCommand> list = adminQnaService.getQaList();
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		System.out.println("list"+list);
		ModelAndView mav = new ModelAndView("qnaList");
		mav.addObject("list", list);
		return mav;

		
	}

}

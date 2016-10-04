package kr.cafein.admin.qna.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.qna.domain.AdminQnaLogCommand;
import kr.cafein.admin.qna.service.AdminQnaService;

@Controller
public class AdminQnaLogListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="adminQnaService")
	private AdminQnaService adminQnaService;
	
	@RequestMapping(value="/cafein_admin/qna/AdminLogList.do")
	public ModelAndView process(){
		List<AdminQnaLogCommand> list = adminQnaService.getAdminQna_LogList();
		
		if(log.isDebugEnabled()){
			log.debug("list : "+list);
		}
		
		System.out.println("===============list============="+list);
		
		ModelAndView mav = new ModelAndView("qnaLogList");
		mav.addObject("list",list);
		return mav;
		
	}

}

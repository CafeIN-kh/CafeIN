package kr.cafein.admin.event.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.domain.AdminEventLogCommand;
import kr.cafein.admin.event.service.AdminEventService;

@Controller
public class AdminEventDeleteController {
	
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private AdminEventService adminEventService;

	@RequestMapping("/cafein_admin/event/delete.do")
	public String submit(@RequestParam("seq") int seq, HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("seq : "+seq);
		}
		
		//=======================log�����==================================
		AdminEventLogCommand adminEventLogCommand = new AdminEventLogCommand();
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		AdminEventCommand adminEventCommand = adminEventService.selectEvent(seq);
		System.out.println("eventCommand"+adminEventCommand);
		
		adminEventLogCommand.setE_log_uid(u_uid);
		adminEventLogCommand.setE_log_change(1);
		adminEventLogCommand.setE_log_message("["+u_uid+"] ����ڰ� Event �Խ��ǿ� "+adminEventCommand.getEvent_title()+"�� �� �����߽��ϴ�.");
		System.out.println("�α� : "+adminEventLogCommand);
		
		adminEventService.insertAdminEvent_Log(adminEventLogCommand);
		//===============================================================
		
		adminEventService.deletEvente(seq);
		
		return "redirect:/cafein_admin/event/List.do";
		
	}
}

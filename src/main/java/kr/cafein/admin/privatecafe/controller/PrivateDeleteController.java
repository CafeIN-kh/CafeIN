package kr.cafein.admin.privatecafe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService privateService;
	
	@RequestMapping("/admin/privatecafe/privatecafe-delete.do")
	public String submit(@RequestParam("pcafe_num") int pcafe_num ,HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pcafe_num : "+pcafe_num);
		}
		
	/*	PrivateCommand privatecommand = privateService.selectBoard(pcafe_num);
		*/
		
		
		
		privateService.deletereply(pcafe_num);
		privateService.deleteallmenu(pcafe_num);
		privateService.delete(pcafe_num);
		

		String u_uid = (String)session.getAttribute("u_uid");
	
		
		PrivateLogCommand privateLogCommand = new PrivateLogCommand();
		
		privateLogCommand.setPcafe_num(pcafe_num);
		privateLogCommand.setU_uid(u_uid);
		privateLogCommand.setP_log_change(1);
		privateLogCommand.setP_log_message("["+u_uid+"] 사용자가 ["+pcafe_num+"]의 Private Cafe Menu, Private Cafe , Private Reply 글을 삭제했습니다");
		
		privateService.insertLog(privateLogCommand);
		
		return "redirect:/admin/privatecafe/privatecafe.do";
		
	}

}

package kr.cafein.admin.privatecafe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;
import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.service.PrivateService;

@Controller
public class PrivateCafeMenuDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PrivateService adminprivateService;
	
	@RequestMapping("/admin/privatecafe/privatecafemenu-delete.do")
	public String submit(@RequestParam("pmenu_num") int pmenu_num, @ModelAttribute PrivateMenuCommand privateCafeMenuCommand ,HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("pmenu_num : " + pmenu_num);
			log.debug("privateCafeMenuCommand : " +  privateCafeMenuCommand);
		}
		
	
		String u_uid = (String)session.getAttribute("u_uid");
		int pcafenum = pmenu_num;
		
		PrivateLogCommand privateLogCommand = new PrivateLogCommand();
		
		privateLogCommand.setPcafe_num(pcafenum);
		privateLogCommand.setU_uid(u_uid);
		privateLogCommand.setP_log_change(1);
		privateLogCommand.setP_log_message("["+u_uid+"] 사용자가 ["+pcafenum+"]의 Private Cafe Menu 글을 삭제했습니다");
		
		adminprivateService.insertLog(privateLogCommand);
		
		adminprivateService.deletemenu(pmenu_num);
		
		
		
		
		
		return "redirect:/admin/privatecafe/privatecafemenu.do?pcafe_num="+privateCafeMenuCommand.getPcafe_num();
	}
}

package kr.cafein.franchise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;
import kr.cafein.franchise.service.FranchiseService;
import kr.cafein.util.PagingUtil;
import kr.cafein.util.PagingUtil_franchise;

@Controller
public class FranchiseDetailController {
	
	private int rowCount = 6;
	private int pageCount = 10;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FranchiseService franchiseService;
	
	//������ ���
	@RequestMapping(value="/cafein_user/franchise/franchise_detail.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam("franchise_num") int franchise_num,
			HttpSession session){
		
		franchiseService.updateHit(franchise_num);
		
		FC_FranchiseCommand franchise = franchiseService.selectFranchise(franchise_num); 
		
		int count = franchiseService.getRowCount(franchise_num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		PagingUtil_franchise page = new PagingUtil_franchise(currentPage, count, rowCount, pageCount, "/CafeIN/cafein_user/franchise/franchise_detail.do", franchise_num);
		
		map.put("franchise_num", franchise_num);
		map.put("end", page.getEndCount());
		map.put("start", page.getStartCount());
		
		List<FC_FranchiseMenuCommand> franchiseMenu = franchiseService.menuList(map);
		
		int likeCount = franchiseService.totalFranchiseLike(franchise_num);
		
		ModelAndView mav = new ModelAndView();
		
		String u_name = (String)session.getAttribute("u_name");
		String u_uid = (String)session.getAttribute("u_uid");
		
		if(u_name == null){
			u_name = "Guest";
		}
		
		mav.setViewName("franchise_detail");
		mav.addObject("franchise", franchise);
		mav.addObject("franchiseMenu", franchiseMenu);
		mav.addObject("pagingHtml", page.getPagingHtml());
		mav.addObject("u_name", u_name);
		mav.addObject("likeCount", likeCount);
		UserCountLogCommand userCountLogCommand = new UserCountLogCommand();
	    userCountLogCommand = franchiseService.selectFCafeUserCountLogByDate(); 
		if(userCountLogCommand == null) {
		       log.debug("�ڡڡڿ��ó�¥ �������� �ο� �����Ƿ� insert");
		       franchiseService.insertFCafeUserCountLog();
		    }else {
		       log.debug("�ڡڡڿ��ó��� �������� �ο� �����Ƿ� update, ��üī��Ʈ�� ����ī�� ī��Ʈ+1");
		       franchiseService.updateFCafeUserCountLog();
		    }
		if(log.isDebugEnabled()){
			log.debug("mav : " + mav);
		}
		
		//System.out.println("likeCount : " + likeCount);
		return mav; 
	}
	
	@RequestMapping(value="/cafein_user/franchise/franchise_replylist.do")
	@ResponseBody
	public Map<String, Object> franchiseReplyList(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
			@RequestParam("franchise_num") int franchise_num, HttpSession session){
		
		int count = franchiseService.getReplyRowCount(franchise_num);
		//System.out.println("count : " + count);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "/CafeIN/cafein_user/franchise/franchise_replylist.do");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("franchise_num", franchise_num);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		//System.out.println("start : " + page.getStartCount() + ", end : " + page.getEndCount());
		
		List<FC_FranchiseReplyCommand> replyList = franchiseService.listReply(map);
		//System.out.println(replyList);
		Map<String, Object> mJson = new HashMap<String, Object>();
		
		mJson.put("replyList", replyList);
		mJson.put("rowCount", rowCount);
		mJson.put("count", count);

		
		return mJson;
	}
}
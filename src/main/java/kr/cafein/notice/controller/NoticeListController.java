package kr.cafein.notice.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.notice.domain.EventCommand;
import kr.cafein.notice.domain.NoticeCommand;
import kr.cafein.notice.service.NoticeService;
import kr.cafein.util.PagingUtil;

@Controller
public class NoticeListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@RequestMapping("/cafein_user/notice/notice.do")
	public ModelAndView process(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int noticeCount = noticeService.getRowCount(map);
		int eventCount = noticeService.getRowCountEvent(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice");
		mav.addObject("noticeCount", noticeCount);
		mav.addObject("eventCount", eventCount);
		
		return mav;
	}
	
	@RequestMapping("/cafein_user/notice/noticeAjax.do")
	@ResponseBody
	public Map<String, Object> noticeList(@RequestParam(value="pageNum", defaultValue="1")int currentPage) {
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int count = noticeService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "noticeAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("start : " + page.getStartCount() + ", end : " + page.getEndCount());
		
		List<NoticeCommand> noticeList = null;
		if(count > 0){
			noticeList = noticeService.noticeList(map);
		}else{
			noticeList = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("noticeList", noticeList);
		
		return mapJson;	
		
	}
	
	
	@RequestMapping("/cafein_user/notice/eventAjax.do")
	@ResponseBody
	public Map<String, Object> eventList(@RequestParam(value="pageNum", defaultValue="1")int currentPage){
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int count = noticeService.getRowCountEvent(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "eventAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<EventCommand> eventList = null;
		if(count > 0){
			eventList = noticeService.eventList(map);
		}else{
			eventList = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("eventList", eventList);
		
		return mapJson;
	}
	
	@RequestMapping("/cafein_user/notice/visit_eventAjax.do")
	@ResponseBody
	public Map<String, Object> visit_eventList(@RequestParam int event_num){
		if(log.isDebugEnabled()){
			log.debug("event_num : " + event_num);
		}
		
		noticeService.updateEventHit(event_num);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();

		mapJson.put("visit_event", "visit_event");
		
		return mapJson;
	}
	
}

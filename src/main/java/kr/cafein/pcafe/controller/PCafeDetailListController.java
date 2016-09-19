package kr.cafein.pcafe.controller;

import java.util.Collections;
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

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.PagingUtil;

@Controller
public class PCafeDetailListController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount;
	private int pageCount;
	
	//페이징 버튼 클릭 할 경우 tabindex=1 속성 추가
	//private StringBuffer pagingClick;
	
	@Resource
	private PCafeService pcafeService;
	
	//먼저 상세페이지 뷰 호출	, private_main.js에서 pcafe_num 전달 - (메뉴 페이징처리)
	@RequestMapping("/cafein_user/private/private_detail.do")
	public ModelAndView process(@RequestParam int pcafe_num, 
								@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
								HttpSession session) {
		
		System.out.println("private_detail.do 진입");
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
			//log.debug("currentPage : " + currentPage);
		}
		
		//u_level 일반회원:0, 사업자:1 뷰에 보여줄때 사업자의 경우만 메뉴추가 버튼 활성화 하기 위해.
		int u_level = 0;
		//로그인시 회원의 level도 세션에 가지고 있기. 세션에서 값 뽑아오기
		if(session.getAttribute("u_level") != null){
			u_level = (Integer)session.getAttribute("u_level");
		}
		
		//u_uid = null이면 guest 상태인것
		String u_uid = (String)session.getAttribute("u_uid");
		//int u_level = 1;
		//String u_uid = "00001";
		
		//해당 카페의 조회수 증가
		pcafeService.updateVisit(pcafe_num);
		
		//해당 카페의 정보 찾아오기
		PCafeCommand pcafe_info = pcafeService.selectPCafe(pcafe_num);
		System.out.println("pcafe_info : " + pcafe_info);
		//해당 카페의 댓글수,좋아요수 카운트
		pcafe_info.setPc_reply_cnt(pcafeService.getCountReply(pcafe_num));
		pcafe_info.setPc_like_cnt(pcafeService.getCountLike(pcafe_num));
		
		//u_uid = null이면 guest 상태인것, 즐겨찾기, 좋아요 여부 검사 불가능.
		int bookmarkCount = 0;
		int likeCount = 0;
		if(u_uid != null) {
			//아이디에 따른 해당 카페 즐겨찾기 여부 검사(jsp에서 즐겨찾기/취소하기 버튼 구별하기 위해)
			BookmarkCommand bookmarkCommand = new BookmarkCommand();
			bookmarkCommand.setU_uid(u_uid);
			bookmarkCommand.setPcafe_num(pcafe_num);
			System.out.println("bookmarkCommand체크 : " + bookmarkCommand);
			bookmarkCount = pcafeService.selectBookmarkCount(bookmarkCommand);
			
			//아이디에 따른 해당 카페 좋아요 여부 검사(jsp에서 좋아요/취소하기 버튼 구별하기 위해)
			LikeCommand likeCommand = new LikeCommand();
			likeCommand.setU_uid(u_uid);
			likeCommand.setPcafe_num(pcafe_num);
			likeCount = pcafeService.selectLikeCount(likeCommand);
			
			System.out.println("메인 bookmarkCount : " + bookmarkCount + ", likeCount : " + likeCount);
		}
		
		//개인카페 메뉴 페이징 처리 하는 부분
		rowCount = 6;
		pageCount = 8;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("pcafe_num",pcafe_num);
				
		//총 메뉴의 갯수
		int count = pcafeService.getRowMenuCount(map);

		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("currentPage: " + currentPage + ", count : " + count);
		System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
		System.out.println("pcafe_num : " + pcafe_num + ", start: " + page.getStartCount() + ", end: " + page.getEndCount());

		List<PCafeMenuCommand> menuList = null;
		
		if(count > 0) {
			menuList = pcafeService.menuList(map);
			System.out.println("menuList : " +  menuList);
		}else {
			menuList = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("private_detail");
		if(u_uid != null) {
			mav.addObject("u_uid",u_uid);
		}
		mav.addObject("u_level",u_level);
		mav.addObject("pcafe_info",pcafe_info);
		//bookmarkCount가 0이라면 해당 아이디는 즐겨찾기는 하지 않은 것임-private_detail.jsp에서 c태그로 검사
		mav.addObject("bookmarkCount",bookmarkCount);
		//likeCount가 0이라면 해당 아이디는 좋아요를 하지 않은 것임-private_detail.jsp에서 c태그로 검사
		mav.addObject("likeCount",likeCount);
		//개인카페 메뉴 부분 정보 뿌리고 페이징 처리하는 부분
		mav.addObject("count",count);
		mav.addObject("menuList",menuList);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav; 
	}
	
	//에이작스로 데이터 불러와서 카페 정보 상세페이지에 뿌리기 - 태그와 이미지 붙이는 부분(,로 쪼개서 append로 붙이기 위해)
	@RequestMapping("/cafein_user/private/private_detail_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detail_ajax(@RequestParam int pcafe_num,
												HttpSession session ) {
											//@RequestParam("u_uid") int u_uid 
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		//rowCount = 5;
		//pageCount = 5;
		
		PCafeCommand pcafe_info_list = pcafeService.selectPCafe(pcafe_num);
		System.out.println("pcafe_info_list : " +  pcafe_info_list);
		
		//json 형태로 ajax에 전달
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("pcafe_info_list", pcafe_info_list);

		return mapJson;
	}
	
	
	//에이작스로 데이터 불러와서 카페 메뉴 정보 상세페이지에 뿌리기-카페메뉴 클릭시 아래에 정보 붙는 부분
	@RequestMapping("/cafein_user/private/private_detailMenuDetail_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detailMenuDetail_ajax(@RequestParam int pmenu_num,
														  HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("pmenu_num : " + pmenu_num);
		}
		System.out.println("private_detailMenuDetail_ajax 진입");

		PCafeMenuCommand pcafeMenuCommand = null;
		
		pcafeMenuCommand = pcafeService.selectMenuDetail(pmenu_num);
		System.out.println("pcafeMenuCommand : " + pcafeMenuCommand);
		
		//u_uid = null이면 guest 상태인것
		String u_uid = (String)session.getAttribute("u_uid");
		
		//u_uid = null이면 guest 상태인것, 좋아요 여부 검사 불가능.
		int menuLikeCount = 0;
		LikeCommand likeCommand = new LikeCommand();
		likeCommand.setPmenu_num(pmenu_num);
		System.out.println("pmenu_num : " + likeCommand.getPmenu_num());
		if(u_uid != null) {
			//아이디에 따른 해당 카페 좋아요 여부 검사(jsp에서 좋아요/취소하기 버튼 구별하기 위해)
			likeCommand.setU_uid(u_uid);
			menuLikeCount = pcafeService.selectMenuLikeCount(likeCommand);
			
			System.out.println("메뉴  menuLikeCount : " + menuLikeCount);
		}
		
		//전체 사용자가 좋아요 누른 수
		int totalMenuLikeCount = 0;
		totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
		
		
		//json 형태로 ajax에 전달
		Map<String,Object> map = new HashMap<String,Object> ();
		map.put("pcafeMenuCommand", pcafeMenuCommand);
		map.put("menuLikeCount", menuLikeCount);
		map.put("totalMenuLikeCount", totalMenuLikeCount);
		//프렌차이즈쪽 cube-portfolio-lightbox.js와 구분하기 위해서.
		map.put("PcafeMenuSuccess", "PcafeMenuSuccess");
		return map;
	}
	
	//에이작스로 데이터 불러와서 해당카페의 댓글 정보 상세페이지에 뿌리기(페이징처리)
	@RequestMapping("/cafein_user/private/private_detailReply_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detailReply_ajax(@RequestParam(value="pageNum", defaultValue="1") int reply_currentPage,
											  @RequestParam int pcafe_num,
											  HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("reply_currentPage : " + reply_currentPage);
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		System.out.println("private_detailReply_ajax 진입");
		
		//한 화면에 보여질 아이템 수
		rowCount = 5;
		pageCount = 5;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("pcafe_num",pcafe_num);
				
		//총 메뉴의 갯수
		int count = pcafeService.getRowReplyCount(map);

		PagingUtil page = new PagingUtil(reply_currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/private/private_detailMenu_ajax.do?pcafe_num="+pcafe_num);

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("pcafe_num : " + pcafe_num + ", count : " + count + ", start: " + page.getStartCount() + ", end: " + page.getEndCount());

		//System.out.println("count : " + count + ", reply_start: " + page.getStartCount() + ", end: " + page.getEndCount());
		
		List<PCafeReplyCommand> replyList = null;
		
		
		if(count > 0) {
			replyList = pcafeService.replyList(map);
			//현재 페이지에 보여질 메뉴의 숫자 (한페이지에 보여지는 메뉴의 숫자는 최대 6개이다.) 그 숫자만큼 화면에 foreach로 돌려주기 위해.
			System.out.println("replyList : " +  replyList); 
		}else {
			replyList = Collections.emptyList();
		}
		
		
		//json 형태로 ajax에 전달
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("replyList", replyList);

		return mapJson;
	}
	
}

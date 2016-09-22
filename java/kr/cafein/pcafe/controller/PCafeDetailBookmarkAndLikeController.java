package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.pcafe.service.PCafeService;

@Controller
public class PCafeDetailBookmarkAndLikeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	//에이작스로 데이터 전달해서 상세페이지에 뿌라기-즐겨찾기(u_uid = null일 경우 guest인것. 좋아요,즐겨찾기 금지.js에서 검사함)
	@RequestMapping("/cafein_user/private/private_detail_bookmark_ajax.do")
	@ResponseBody
	//public Map<String,String> PCafe_detail_Bookmark_ajax(@RequestParam int pcafe_num,
	public Map<String,String> PCafe_detail_Bookmark_ajax(@ModelAttribute BookmarkCommand bookmarkCommand,
												HttpSession session ) {
											//@RequestParam("u_uid") int u_uid 
		if(log.isDebugEnabled()) {
			log.debug("bookmarkCommand : " + bookmarkCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		//null값이 들어가면 부적합할 열유형 뜸. 
		bookmarkCommand.setU_uid(u_uid);
		//일단 세션에 u_uid 없으니 값 박아놓기
		//String u_uid = "00001";
		
		bookmarkCommand.setU_uid(u_uid);
		bookmarkCommand.setPcafe_num(bookmarkCommand.getPcafe_num());
		
		//bookmarkCount가 0이라면 현재 아이디가 즐겨찾기한 기록이 없다는 뜻->즐겨찾기 추가(insert)해주기
		int bookmarkCount = pcafeService.selectBookmarkCount(bookmarkCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(bookmarkCount == 0) {
			pcafeService.insertBookmark(bookmarkCommand);
			System.out.println("즐겨찾기 insert : " + bookmarkCommand.toString());
			map.put("result", "bookmarkinsert");
		} else {
			pcafeService.deleteBookmark(bookmarkCommand);
			System.out.println("즐겨찾기 delete");
			map.put("result", "bookmarkdelete");
		}

		return map;
	}
	
	
	//에이작스로 데이터 전달해서 상세페이지에 뿌라기-좋아요(u_uid = null일 경우 guest인것. 좋아요,즐겨찾기 금지.js에서 검사함)
	@RequestMapping("/cafein_user/private/private_detail_like_ajax.do")
	@ResponseBody													//pcafe_num 전달 받음
	public Map<String,Object> PCafe_detail_like_ajax(@ModelAttribute LikeCommand likeCommand,
												HttpSession session ) {
		if(log.isDebugEnabled()) {
			log.debug("likeCommand : " + likeCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		likeCommand.setU_uid(u_uid);
		likeCommand.setPcafe_num(likeCommand.getPcafe_num());
		
		//likeCount가 0이라면 현재 아이디가 좋아요한 기록이 없다는 뜻->좋아요 추가(insert)해주기
		int likeCount = pcafeService.selectLikeCount(likeCommand);
		
		Map<String,Object> map = new HashMap<String,Object>();
		int totalLikeCount = 0;
		
		if(likeCount == 0) {
			pcafeService.insertLike(likeCommand);
			//전체 사용자의 좋아요 수
			totalLikeCount = pcafeService.selectTotalLikeCount(likeCommand);
			System.out.println("좋아요 insert : " + likeCommand.toString());
			map.put("result", "likeinsert");
			map.put("totalLikeCount", totalLikeCount);
		} else {
			pcafeService.deleteLike(likeCommand);
			//전체 사용자의 좋아요 수
			totalLikeCount = pcafeService.selectTotalLikeCount(likeCommand);
			System.out.println("좋아요 delete");
			map.put("result", "likedelete");
			map.put("totalLikeCount", totalLikeCount);
		}

		return map;
	}
	
	
	//에이작스로 데이터 전달해서 메뉴 상세페이지에 뿌리기-좋아요(u_uid = null일 경우 guest인것. 좋아요,즐겨찾기 금지.js에서 검사함)
	@RequestMapping("/cafein_user/private/private_detailMenu_like_ajax.do")
	@ResponseBody													//pmenu_num 전달 받음
	public Map<String,Object> PCafe_detailMenu_like_ajax(@ModelAttribute LikeCommand likeCommand,
												HttpSession session ) {
		if(log.isDebugEnabled()) {
			log.debug("likeCommand : " + likeCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		likeCommand.setU_uid(u_uid);
		likeCommand.setPmenu_num(likeCommand.getPmenu_num());
		
		//menuLikeCount가 0이라면 현재 아이디가 좋아요한 기록이 없다는 뜻->좋아요 추가(insert)해주기
		int menuLikeCount = pcafeService.selectMenuLikeCount(likeCommand);
		
		Map<String,Object> map = new HashMap<String,Object>();
		int totalMenuLikeCount = 0;
		
		if(menuLikeCount == 0) {
			pcafeService.insertMenuLike(likeCommand);
			//전체 사용자의 좋아요 수
			totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
			System.out.println("좋아요 insert : " + likeCommand.toString());
			map.put("result", "menulikeinsert");
			map.put("totalMenuLikeCount", totalMenuLikeCount);
		} else {
			pcafeService.deleteMenuLike(likeCommand);
			//전체 사용자의 좋아요 수
			totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
			System.out.println("좋아요 delete");
			map.put("result", "menulikedelete");
			map.put("totalMenuLikeCount", totalMenuLikeCount);
		}

		return map;
	}
	
}

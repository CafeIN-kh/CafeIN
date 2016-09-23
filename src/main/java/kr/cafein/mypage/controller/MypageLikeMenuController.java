package kr.cafein.mypage.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.cafein.domain.LikeAndMypageCommand;
import kr.cafein.mypage.service.MypageService;
import kr.cafein.util.PagingUtil;

@Controller
public class MypageLikeMenuController {

private Logger log = Logger.getLogger(this.getClass());
	
	//페이징
	private int rowCount;
	private int pageCount;
	
	@Resource
	private MypageService mypageService;
	
	//마이페이지 좋아요 카페 뷰에 출력하는 부분(카페고리에 따른 페이징)
	@RequestMapping("/cafein_user/mypage/mypage_like_menu.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								@RequestParam(value="category", defaultValue="1") int category,
								HttpSession session) {
		
		System.out.println("mypage_like_menu.do 진입");
		
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
			//category:1 프렌차이즈메뉴, category:2 개인카페메뉴, category:3 커스텀메뉴
			log.debug("category : " + category);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		//세션에 값이 없으면 로그인 페이지로 이동
		if(u_uid == null){
			ModelAndView mav = new ModelAndView();
			mav.setView(new RedirectView("/CafeIN/cafein_user/user/login.do"));
			return mav;
		}else {
			
			//마이페이지 좋아요 카페 페이징 처리 하는 부분
			rowCount = 5;
			pageCount = 8;
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("u_uid",u_uid);
			//디비에서 프렌차이즈/개인카페  카테고리 구별하기 위해서 필요
			map.put("category",category);
					
			//총 마이페이지 좋아요 카페 갯수
			int count = mypageService.getRowMenuLikeCount(map);
			
			PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/mypage/mypage_like_menu.do?category="+category);
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			System.out.println("currentPage: " + currentPage + ", count : " + count);
			System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
			System.out.println("start: " + page.getStartCount() + ", end: " + page.getEndCount());
			
			//해당 사용자가 좋아요 카페  리스트 찾기
			List<LikeAndMypageCommand> likeMypage = null;
			
			if(count > 0) {
				//좋아요한 카페의  정보 리스트로 가지고있기 
				likeMypage = mypageService.selectMenuByLikeMypage(map);
				
				System.out.println("likeMypage : " +  likeMypage);
			}else {
				likeMypage = Collections.emptyList();
				System.out.println("count=0이라 likeMypage 값이 없음");
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage_like_menu");
			mav.addObject("count",count);
			mav.addObject("likeMypage",likeMypage);
			mav.addObject("pagingHtml",page.getPagingHtml());
			mav.addObject("category",category);
			
			return mav; 
		}
	}
	
	
	//마이페이지 좋아요 취소 누르는 경우
	@RequestMapping("/cafein_user/mypage/mypage_like_menu_deletelike.do")
	public String deleteCafeLike(@RequestParam(value="category", defaultValue="1") int category,
								 @RequestParam(value="fmenu_num", defaultValue="0") int fmenu_num, 
								 @RequestParam(value="pmenu_num", defaultValue="0") int pmenu_num, 
								 @RequestParam(value="custom_num", defaultValue="0") int custom_num, 
								 HttpSession session) {
		
		System.out.println("mypage_like_cafe_deletelike.do 진입");
		if(log.isDebugEnabled()) {
			log.debug("category : " + category);
			log.debug("fmenu_num : " + fmenu_num);
			log.debug("pmenu_num : " + pmenu_num);
			log.debug("custom_num : " + custom_num);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//세션에 값이 없으면 로그인 페이지로 이동
		if(u_uid == null){
			//로그인 페이지로 리다이렉트(새로고침)
			return "redirect:/cafein_user/user/login.do";
		}else {
			map.put("u_uid",u_uid);
			map.put("category",category);
			map.put("fmenu_num",fmenu_num);
			map.put("pmenu_num",pmenu_num);
			map.put("custom_num",custom_num);
			
			//즐겨찾기 지우기
			mypageService.deleteMenuLikeMypage(map);
			
			//마이페이지 개인카페 즐겨찾기 페이지로 리다이렉트(새로고침)
			return "redirect:/cafein_user/mypage/mypage_like_menu.do?category="+category;
		}
	}
}

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

import kr.cafein.domain.BookmarkAndMypageCommand;
import kr.cafein.domain.BookmarkCommand;
import kr.cafein.mypage.service.MypageService;
import kr.cafein.util.PagingUtil_mypage;

@Controller
public class MypageBookmarkPCafeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	//페이징
	private int rowCount;
	private int pageCount;
	
	@Resource
	private MypageService mypageService;
	
	//마이페이지 즐겨찾기 개인카페 뷰에 출력하는 부분(페이징)
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_private.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
								HttpSession session) {
		
		System.out.println("mypage_bookmark_private.do 진입");
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		//세션에 값이 없으면 로그인 페이지로 이동
		if(u_uid == null){
			ModelAndView mav = new ModelAndView();
			mav.setView(new RedirectView("/CafeIN/cafein_user/user/login.do"));
			//return "redirect:/cafein_user/user/login.do";
			return mav;
		}else {
			
			//마이페이지 개인카페 즐겨찾기 페이징 처리 하는 부분
			rowCount = 9;
			pageCount = 8;
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("u_uid",u_uid);
					
			//총 마이페이지 개인카페 즐겨찾기 갯수
			int count = mypageService.getRowPCafeBookmarkCount(map);
			
			PagingUtil_mypage page = new PagingUtil_mypage(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/mypage/mypage_bookmark_private.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			System.out.println("currentPage: " + currentPage + ", count : " + count);
			System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
			System.out.println("start: " + page.getStartCount() + ", end: " + page.getEndCount());
			
			//해당 사용자가 즐겨찾기한 개인카페 리스트 찾기
			List<BookmarkAndMypageCommand> bookmarkMypage = null;
			
			if(count > 0) {
				//즐겨찾기한 개인카페의 정보 리스트로 가지고있기 
				bookmarkMypage = mypageService.selectPCafeByBookmarkMypage(map);
				
				//개인카페 대표 이미지를 찾아내기 위함
				String pcafeImgName;
			    String[] pcafeImgNameArray;
			    
			    for(int i=0; i<bookmarkMypage.size(); i++) {
			    	//문자열에 ,가 있다면 쪼개서 배열에 담기
					pcafeImgName = bookmarkMypage.get(i).getPcafe_img();
				    pcafeImgNameArray = pcafeImgName.split(",");
				    for (int j = 0; j < pcafeImgNameArray.length; j++) {
						//pcafeImgNameArray 인덱스 안에 * 값이 없으면 -1 반환
						if(pcafeImgNameArray[j].indexOf("*") != -1){
							//*이 있다는 것이므로 *표를 빈값으로 대체
							//대표이미지 찾아서 *표시 없애주기
							pcafeImgNameArray[j] = pcafeImgNameArray[j].replace("*","");
							//여러 이미지 중에 대표이미지만 BookmarkAndMypageCommand에 넣어주기(jsp에서 이미지 불러오기 위해)
							bookmarkMypage.get(i).setPcafe_img(pcafeImgNameArray[j]);
						}
					}
			    }
			    
				System.out.println("bookmarkMypage : " +  bookmarkMypage);
			}else {
				bookmarkMypage = Collections.emptyList();
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage_bookmark_private");
			mav.addObject("count",count);
			mav.addObject("bookmarkMypage",bookmarkMypage);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav; 
		}
		
	}
	
	
	//마이페이지 즐겨찾기 취소 누르는 경우
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_private_deleteBookmark.do")
	public String deletePCafeBookmark(@RequestParam int pcafe_num, 
									HttpSession session) {
		
		System.out.println("mypage_bookmark_private_deleteBookmark.do 진입");
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//세션에 값이 없으면 로그인 페이지로 이동
		if(u_uid == null){
			//로그인 페이지로 리다이렉트(새로고침)
			return "redirect:/cafein_user/user/login.do";
		}else {
			map.put("u_uid",u_uid);
			map.put("pcafe_num",pcafe_num);
			
			//즐겨찾기 지우기
			mypageService.deletePCafeBookmarkMypage(map);
			
			//마이페이지 개인카페 즐겨찾기 페이지로 리다이렉트(새로고침)
			return "redirect:/cafein_user/mypage/mypage_bookmark_private.do";
		}
	}
}

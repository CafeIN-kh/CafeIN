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
import kr.cafein.mypage.service.MypageService;
import kr.cafein.util.PagingUtil_mypage;

@Controller
public class MypageBookmarkCustomController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//����¡
	private int rowCount;
	private int pageCount;
	
	@Resource
	private MypageService mypageService;
	
	//���������� ���ã�� Ŀ���Ҹ���¡�޴� �信 ����ϴ� �κ�(����¡)
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_customMenu.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
								HttpSession session) {
		
		System.out.println("mypage_bookmark_customMenu.do ����");
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		//���ǿ� ���� ������ �α��� �������� �̵�
		if(u_uid == null){
			ModelAndView mav = new ModelAndView();
			mav.setView(new RedirectView("/CafeIN/cafein_user/user/login.do"));
			return mav;
		}else {
			
			//���������� Ŀ���Ҹ���¡�޴� ���ã�� ����¡ ó�� �ϴ� �κ�
			rowCount = 5;
			pageCount = 8;
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("u_uid",u_uid);
					
			//�� ���������� Ŀ���Ҹ���¡�޴� ���ã�� ����
			int count = mypageService.getRowCustomBookmarkCount(map);
			
			PagingUtil_mypage page = new PagingUtil_mypage(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/mypage/mypage_bookmark_customMenu.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			System.out.println("currentPage: " + currentPage + ", count : " + count);
			System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
			System.out.println("start: " + page.getStartCount() + ", end: " + page.getEndCount());
			
			//�ش� ����ڰ� ���ã���� Ŀ���Ҹ���¡�޴� ����Ʈ ã��
			List<BookmarkAndMypageCommand> bookmarkMypage = null;
			
			if(count > 0) {
				//���ã���� Ŀ���Ҹ���¡�޴��� ���� ����Ʈ�� �������ֱ� 
				bookmarkMypage = mypageService.selectCustomByBookmarkMypage(map);
				System.out.println("bookmarkMypage : " +  bookmarkMypage);
			}else {
				bookmarkMypage = Collections.emptyList();
				System.out.println("count=0�̶� bookmarkMypage ���� ����");
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage_bookmark_customMenu");
			mav.addObject("count",count);
			mav.addObject("bookmarkMypage",bookmarkMypage);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav; 
		}
		
	}
	
	//���������� ���ã�� ��� ������ ���
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_custom_deleteBookmark.do")
	public String deletePCafeBookmark(@RequestParam int custom_num, 
									HttpSession session) {
		
		System.out.println("mypage_bookmark_custom_deleteBookmark.do ����");
		if(log.isDebugEnabled()) {
			log.debug("custom_num : " + custom_num);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//���ǿ� ���� ������ �α��� �������� �̵�
		if(u_uid == null){
			//�α��� �������� �����̷�Ʈ(���ΰ�ħ)
			return "redirect:/cafein_user/user/login.do";
		}else {
			map.put("u_uid",u_uid);
			map.put("custom_num",custom_num);
			
			//���ã�� �����
			mypageService.deleteCustomBookmarkMypage(map);
			
			//���������� Ŀ���Ҹ���¡�޴� ���ã�� �������� �����̷�Ʈ(���ΰ�ħ)
			return "redirect:/cafein_user/mypage/mypage_bookmark_customMenu.do";
		}
	}

}

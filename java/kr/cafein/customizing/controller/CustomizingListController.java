package kr.cafein.customizing.controller;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.util.PagingUtilCus;


@Controller
public class CustomizingListController {
	
	
		//rowCount = 보여줄 카드 수(endCount)
		private int rowCount = 8;
		private int pageCount = 10;
		private Logger log = Logger.getLogger(this.getClass());
		
		@Resource
		private CustomizingService customizingService;
		
		//customizing_list_check.do
		@RequestMapping("/cafein_user/customizing/customizing_list.do")
		public ModelAndView process(@RequestParam(value="custom_num",defaultValue="1") int custom_num,
									@RequestParam(value="pageNum", defaultValue="1") int currentPage,
									@RequestParam(value="keyword",defaultValue="") String keyword,
									@RequestParam(value="keyfield",defaultValue="") String keyfield,
									@RequestParam(value="category",defaultValue="1") int category,
									@RequestParam(value="franchise_name",defaultValue="") String franchise_name,
									@RequestParam(value="franchise_num",defaultValue="0") int franchise_num,
									HttpSession session,Model model
									) {
			
			String u_uid = (String)session.getAttribute("u_uid");
			System.out.println("u_uid"+u_uid);
			
			MemberCommand membercommand = new  MemberCommand();
			membercommand.setU_uid(u_uid);
			System.out.println("memberCommand.tostring : "+membercommand.toString());
			
			System.out.println("String franchise_num : " +franchise_num);
			System.out.println("custom_num : " +custom_num);
			if(log.isDebugEnabled()) {
				log.debug("currentPage : " + currentPage);
				log.debug("custom_num : " + custom_num);
			}
			
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("keyword", keyword);
			map.put("keyfield", keyfield);
			map.put("u_uid",u_uid);
			map.put("franchise_num", franchise_num);
			map.put("category", category);
			//총 글의 갯수
			
			int count = customizingService.getRowCount(map);
			PagingUtilCus page = new PagingUtilCus(currentPage,count,rowCount,pageCount,"customizing_list.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			
			List<CustomizingCommand> list = null;
			
			
			System.out.println("map : " +map);
			//pagingList는 글목록을 10개만 가져오는 메서드
			
			//visit==1이면 검색에 대한 메서드
			//2이면 방문자 수에 대한 메서드
			//3이면 좋아요 순으로 
			//4이면 내가 등록한 글 순
			
			List<FranchiseCommand> franchiseList = customizingService.selectBrand();
			
			System.out.println("franchiseList : " +franchiseList.toString());
			
			System.out.println("count : " +count);
			
			
			
			
			if(category==1 && franchise_num!=0){
				System.out.println("페이지넘받으면 들어오는곳 ");
				list = customizingService.selectCafe(map);
			}else if(category==1){
				if(count > 0) {
				list = customizingService.searchList(map);
				System.out.println("visit=1,searchList단순키워드검색");
				}else {
					list = Collections.emptyList();
				}
			}else if(category==2 && keyword.equals("")){
				System.out.println("조회수만");
				list = customizingService.pagingVisitList(map);
			}else if(category==2 && !keyword.equals("")){
				System.out.println("조회수+키워드");
				list = customizingService.pagingSearchLikeList(map);
			}else if(category==3 && keyword.equals("")){
				System.out.println("두번째 : ");
				list = customizingService.pagingLikeList(map);
			}else if(category==3 && !keyword.equals("")){
				System.out.println("3번째");
				list = customizingService.pagingSearchLikeList(map);
			}else if(category==4 && keyword.equals("")){
				System.out.println("4번째-내가등록한글보기");
				list = customizingService.searchList(map);
				System.out.println("list.toString : "+list.toString());
			}else if(category==4 && !keyword.equals("")){
				map.put("u_uid", u_uid);
				System.out.println("4번째-내가등록한글보기+키워드 : " +map.toString());
				list = customizingService.pagingSearchLikeList(map);
			}
			
			
			System.out.println("마지막 리스트 점검 list : " +list.toString());
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("customizing_main");
			mav.addObject("list",list);
			mav.addObject("count",count);
			//mav.addObject("customizing",customizing);
			mav.addObject("franchiseList",franchiseList);
			mav.addObject("map",map);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav;
		}
		
		
		
		

}

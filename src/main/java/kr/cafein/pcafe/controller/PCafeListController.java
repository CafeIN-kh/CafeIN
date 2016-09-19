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

import kr.cafein.domain.PCafeCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.PagingUtil;

@Controller
public class PCafeListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 9;
	private int pageCount = 12;
	
	@Resource
	private PCafeService pcafeService;
	
	//먼저 메인 뷰 호출
	@RequestMapping("/cafein_user/private/private_main.do")
	public ModelAndView process(HttpSession session) {
		
		//u_level 일반회원:0, 사업자:1 뷰에 보여줄때 사업자의 경우만 카페등록/내글보기 버튼 활성화 하기 위해.
		//로그인시 회원의 level도 세션에 가지고 있기. 세션에서 값 뽑아오기
		int u_level = 0;
		if(session.getAttribute("u_level") != null) {
			u_level = (Integer)session.getAttribute("u_level");
		}
		//int u_level = 1;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("private_main");
		mav.addObject("u_level",u_level);
		
		return mav; 
	}

	//에이작스로 데이터 불러와서 메인에 뿌리기
	@RequestMapping("/cafein_user/private/private_main_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_main_ajax(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
											  @RequestParam(value="category", defaultValue="1") int category,
											  @RequestParam(value="keyfield",defaultValue="") String keyfield,
											  @RequestParam(value="keyword", defaultValue="") String keyword,
											  HttpSession session ) {
											//@RequestParam("u_uid") int u_uid 
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
			log.debug("category : " + category);
			log.debug("keyfield : " + keyfield + " [사용안함-pagingutil 형식 맞추기 위해 넣음]");
			log.debug("keyword : " + keyword);
		}
		
		HashMap<String,Object> map = new HashMap<String,Object>();

		String u_uid = (String)session.getAttribute("u_uid");
		//null값이 들어가면 부적합할 열유형 뜸. 
		//pcafeCommand.setU_uid(u_uid);
		//String u_uid = "00001";
		//내글보기시 필요
		map.put("u_uid",u_uid);
		//디비에서 최신순,조회순,좋아요순,내글보기순으로 정렬하기 위해서 필요
		map.put("category",category);
		//사용자가 검색한 키워드 값
		map.put("keyword", keyword);
				
		//카페고리에 따른 총 글의 갯수
		int count = pcafeService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/private/private_main_ajax.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("u_uid : " + u_uid + ", category : " + category + ", count : " + count + ", start: " + page.getStartCount() + ", end: " + page.getEndCount());

		List<PCafeCommand> list = null;

		if(count > 0) {
			list = pcafeService.list(map);
			System.out.println("list : " +  list);
		}else {
			list = Collections.emptyList();
		}
		
		//json 형태로 ajax에 전달
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		if(category == 4) {
			//카테고리=4일경우 내글보기. 내글보기 누르면 작성자 삭제가능
			mapJson.put("category_mywrite", "category_mywrite");
			System.out.println("category_mywrite put");
		}

		return mapJson;
	}
	
}

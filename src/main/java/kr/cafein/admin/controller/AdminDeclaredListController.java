package kr.cafein.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.domain.DeclaredCommand;
import kr.cafein.admin.service.DeclaredService;
import kr.cafein.util.Declared_PagingUtil;

@Controller
public class AdminDeclaredListController {
	// 로그처리
	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;

	// 로그테이블 mapper,service 만들기
	@Resource(name = "declaredService")
	private DeclaredService declaredService;

	@RequestMapping("/cafein_admin/member/declaredlist.do")
	public ModelAndView process(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage,
			@RequestParam(value = "keyfield", defaultValue = "") String keyfield,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		int count = declaredService.getDeclaredRowCount(map); // 전체 혹은 검색된 신고글의 총 갯수

		Declared_PagingUtil page = new Declared_PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount,
				"declaredlist.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<DeclaredCommand> list = null;
		if (count > 0) {

			list = declaredService.getDeclaredList(map);
		} else {
			list = Collections.emptyList();
		}

		log.debug("count : " + count);
		log.debug("rowCount: " + rowCount);
		

		String memberEmail;

		try { // IndexOutOfBoundsException 처리
			
			for (int x = 0; x < rowCount; x++) { // 페이징이 10개씩 되어있으니 마지막 페이지에서 에러남. 예외처리!

									// 리스트에서 mem_id(seq)를 가져와 멤버의 id(email)을 가져옴 
				memberEmail = declaredService.getMemberId(list.get(x).getD_mem_id());
				
				if(memberEmail!=null && !memberEmail.isEmpty()){ // 정보가 없는 탈퇴한 회원이라면 
					list.get(x).setD_mem_id(memberEmail); // target_id : 신고한 회원의 이메일
				}else{
					list.get(x).setD_mem_id("탈퇴 회원"); // target_id : 신고한 회원의 이메일
				}
					
				

				memberEmail = declaredService.getMemberId(list.get(x).getD_target_mem_id());
				
				if(memberEmail!=null && !memberEmail.isEmpty()){
					list.get(x).setD_target_mem_id(memberEmail); // target_mem_id
				}else{
					list.get(x).setD_target_mem_id("탈퇴 회원"); // target_mem_id
				}
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("declared");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;

	}
}

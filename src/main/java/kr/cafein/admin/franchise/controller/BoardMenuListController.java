package kr.cafein.admin.franchise.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.admin.franchise.service.AdminFranchiseService;
import kr.cafein.util.PagingUtil_adminFranchise;

@Controller
public class BoardMenuListController {

	private int rowCount = 8;
	private int pageCount = 10;   
	
	@Resource
	private AdminFranchiseService adminFranchiseService;
	
	//상세정보 출력
	@RequestMapping("/cafein_admin/franchise/franchise_menuList.do")
	public ModelAndView detailProcess(@RequestParam(value="franchise_name",defaultValue="") String franchise_name, 
									  @RequestParam(value="franchise_num",defaultValue="") int franchise_num, 
									  @RequestParam(value="pageNum",defaultValue="1") int currentPage,
									  @RequestParam(value="keyword",defaultValue="") String keyword){
								

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		
		
		//총 글의 갯수 또는 검색된 글의 갯수
		int count = adminFranchiseService.getRowCount(franchise_num);

		
		PagingUtil_adminFranchise page = new PagingUtil_adminFranchise(keyword,currentPage,count,rowCount,pageCount,franchise_num,"franchise_menuList.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		map.put("franchise_num", franchise_num);

		System.out.println("2 : " + franchise_num);
		AdminFranchiseCommand franchise = adminFranchiseService.selectFranchise(franchise_num);
		
		List<AdminFranchiseMenuCommand> franchiseMenu = null;
		
		
		if(count > 0){
			franchiseMenu = adminFranchiseService.menuList(map);
		}else{
			franchiseMenu = Collections.emptyList();
		}

		System.out.println("keyword : " + keyword);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("franchise_menuList");
		mav.addObject("franchise", franchise);
		mav.addObject("franchiseMenu", franchiseMenu);
		mav.addObject("franchise_num",franchise_num);
		mav.addObject("count",count);
		mav.addObject("pagingHtml",page.getPagingHtml());
		mav.addObject("franchise_name",franchise_name);


		return mav; 
			}
				
		
	}


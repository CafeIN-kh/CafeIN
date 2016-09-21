package kr.cafein.customizing.controller;


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

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.customizing.service.CustomizingService;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.util.PagingUtilCus;


@Controller
public class CustomizingListController {
	
	
		//rowCount = ������ ī�� ��(endCount)
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
									@RequestParam(value="custom_visit",defaultValue="1") int custom_visit,
									@RequestParam(value="franchise_name",defaultValue="") String franchise_name,
									@RequestParam(value="franchise_num",defaultValue="") String franchise_num,
									HttpSession session
									) {
			
			String u_uid = (String)session.getAttribute("u_uid");
			System.out.println("u_uid"+u_uid);
			
			
			
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
			//�� ���� ����
			int count = customizingService.getRowCount(map);
			PagingUtilCus page = new PagingUtilCus(currentPage,count,rowCount,pageCount,"customizing_list.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			map.put("custom_visit", custom_visit);
			
			List<CustomizingCommand> list = null;
			
			
			System.out.println("map : " +map);
			//pagingList�� �۸���� 10���� �������� �޼���
			
			//visit==1�̸� �˻��� ���� �޼���
			//2�̸� �湮�� ���� ���� �޼���
			//3�̸� ���ƿ� ������ 
			//4�̸� ���� ����� �� ��
			
			List<FranchiseCommand> franchiseList = customizingService.selectBrand();
			
			System.out.println("franchiseList : " +franchiseList.toString());
			
			System.out.println("count : " +count);
			
			
			
			
			if(custom_visit==1 && !franchise_num.equals("")){
				list = customizingService.selectCafe(franchise_num);
			}
			else if(custom_visit==1){
				if(count > 0) {
				list = customizingService.searchList(map);
				System.out.println("visit=1,searchList�ܼ�Ű����˻�");
				}else {
					list = Collections.emptyList();
				}
			}else if(custom_visit==2 && keyword.equals("")){
				System.out.println("��ȸ����");
				list = customizingService.pagingVisitList(map);
			}else if(custom_visit==2 && !keyword.equals("")){
				System.out.println("��ȸ��+Ű����");
				list = customizingService.pagingSearchLikeList(map);
			}else if(custom_visit==3 && keyword.equals("")){
				System.out.println("�ι�° : ");
				list = customizingService.pagingLikeList(map);
			}else if(custom_visit==3 && !keyword.equals("")){
				System.out.println("3��°");
				list = customizingService.pagingSearchLikeList(map);
			}else if(custom_visit==4 && keyword.equals("")){
				System.out.println("here is error");
				System.out.println("4��°-��������ѱۺ���");
				list = customizingService.searchList(map);
				System.out.println("list.toString : "+list.toString());
			}else if(custom_visit==4 && !keyword.equals("")){
				map.put("u_uid", u_uid);
				System.out.println("4��°-��������ѱۺ���+Ű���� : " +map.toString());
				list = customizingService.pagingSearchLikeList(map);
			}
			
			
			System.out.println("������ ����Ʈ ���� list : " +list.toString());
			
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

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
	
	//���� ���� �� ȣ��
	@RequestMapping("/cafein_user/private/private_main.do")
	public ModelAndView process(HttpSession session) {
		
		//u_level �Ϲ�ȸ��:0, �����:1 �信 �����ٶ� ������� ��츸 ī����/���ۺ��� ��ư Ȱ��ȭ �ϱ� ����.
		//�α��ν� ȸ���� level�� ���ǿ� ������ �ֱ�. ���ǿ��� �� �̾ƿ���
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

	//�����۽��� ������ �ҷ��ͼ� ���ο� �Ѹ���
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
			log.debug("keyfield : " + keyfield + " [������-pagingutil ���� ���߱� ���� ����]");
			log.debug("keyword : " + keyword);
		}
		
		HashMap<String,Object> map = new HashMap<String,Object>();

		String u_uid = (String)session.getAttribute("u_uid");
		//null���� ���� �������� ������ ��. 
		//pcafeCommand.setU_uid(u_uid);
		//String u_uid = "00001";
		//���ۺ���� �ʿ�
		map.put("u_uid",u_uid);
		//��񿡼� �ֽż�,��ȸ��,���ƿ��,���ۺ�������� �����ϱ� ���ؼ� �ʿ�
		map.put("category",category);
		//����ڰ� �˻��� Ű���� ��
		map.put("keyword", keyword);
				
		//ī����� ���� �� ���� ����
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
		
		//json ���·� ajax�� ����
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		if(category == 4) {
			//ī�װ�=4�ϰ�� ���ۺ���. ���ۺ��� ������ �ۼ��� ��������
			mapJson.put("category_mywrite", "category_mywrite");
			System.out.println("category_mywrite put");
		}

		return mapJson;
	}
	
}

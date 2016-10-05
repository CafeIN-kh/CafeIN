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
	// �α�ó��
	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;

	// �α����̺� mapper,service �����
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

		int count = declaredService.getDeclaredRowCount(map); // ��ü Ȥ�� �˻��� �Ű���� �� ����

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

		try { // IndexOutOfBoundsException ó��
			
			for (int x = 0; x < rowCount; x++) { // ����¡�� 10���� �Ǿ������� ������ ���������� ������. ����ó��!

									// ����Ʈ���� mem_id(seq)�� ������ ����� id(email)�� ������ 
				memberEmail = declaredService.getMemberId(list.get(x).getD_mem_id());
				
				if(memberEmail!=null && !memberEmail.isEmpty()){ // ������ ���� Ż���� ȸ���̶�� 
					list.get(x).setD_mem_id(memberEmail); // target_id : �Ű��� ȸ���� �̸���
				}else{
					list.get(x).setD_mem_id("Ż�� ȸ��"); // target_id : �Ű��� ȸ���� �̸���
				}
					
				

				memberEmail = declaredService.getMemberId(list.get(x).getD_target_mem_id());
				
				if(memberEmail!=null && !memberEmail.isEmpty()){
					list.get(x).setD_target_mem_id(memberEmail); // target_mem_id
				}else{
					list.get(x).setD_target_mem_id("Ż�� ȸ��"); // target_mem_id
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

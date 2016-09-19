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

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.service.PCafeService;
import kr.cafein.util.PagingUtil;

@Controller
public class PCafeDetailListController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount;
	private int pageCount;
	
	//����¡ ��ư Ŭ�� �� ��� tabindex=1 �Ӽ� �߰�
	//private StringBuffer pagingClick;
	
	@Resource
	private PCafeService pcafeService;
	
	//���� �������� �� ȣ��	, private_main.js���� pcafe_num ���� - (�޴� ����¡ó��)
	@RequestMapping("/cafein_user/private/private_detail.do")
	public ModelAndView process(@RequestParam int pcafe_num, 
								@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
								HttpSession session) {
		
		System.out.println("private_detail.do ����");
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
			//log.debug("currentPage : " + currentPage);
		}
		
		//u_level �Ϲ�ȸ��:0, �����:1 �信 �����ٶ� ������� ��츸 �޴��߰� ��ư Ȱ��ȭ �ϱ� ����.
		int u_level = 0;
		//�α��ν� ȸ���� level�� ���ǿ� ������ �ֱ�. ���ǿ��� �� �̾ƿ���
		if(session.getAttribute("u_level") != null){
			u_level = (Integer)session.getAttribute("u_level");
		}
		
		//u_uid = null�̸� guest �����ΰ�
		String u_uid = (String)session.getAttribute("u_uid");
		//int u_level = 1;
		//String u_uid = "00001";
		
		//�ش� ī���� ��ȸ�� ����
		pcafeService.updateVisit(pcafe_num);
		
		//�ش� ī���� ���� ã�ƿ���
		PCafeCommand pcafe_info = pcafeService.selectPCafe(pcafe_num);
		System.out.println("pcafe_info : " + pcafe_info);
		//�ش� ī���� ��ۼ�,���ƿ�� ī��Ʈ
		pcafe_info.setPc_reply_cnt(pcafeService.getCountReply(pcafe_num));
		pcafe_info.setPc_like_cnt(pcafeService.getCountLike(pcafe_num));
		
		//u_uid = null�̸� guest �����ΰ�, ���ã��, ���ƿ� ���� �˻� �Ұ���.
		int bookmarkCount = 0;
		int likeCount = 0;
		if(u_uid != null) {
			//���̵� ���� �ش� ī�� ���ã�� ���� �˻�(jsp���� ���ã��/����ϱ� ��ư �����ϱ� ����)
			BookmarkCommand bookmarkCommand = new BookmarkCommand();
			bookmarkCommand.setU_uid(u_uid);
			bookmarkCommand.setPcafe_num(pcafe_num);
			System.out.println("bookmarkCommandüũ : " + bookmarkCommand);
			bookmarkCount = pcafeService.selectBookmarkCount(bookmarkCommand);
			
			//���̵� ���� �ش� ī�� ���ƿ� ���� �˻�(jsp���� ���ƿ�/����ϱ� ��ư �����ϱ� ����)
			LikeCommand likeCommand = new LikeCommand();
			likeCommand.setU_uid(u_uid);
			likeCommand.setPcafe_num(pcafe_num);
			likeCount = pcafeService.selectLikeCount(likeCommand);
			
			System.out.println("���� bookmarkCount : " + bookmarkCount + ", likeCount : " + likeCount);
		}
		
		//����ī�� �޴� ����¡ ó�� �ϴ� �κ�
		rowCount = 6;
		pageCount = 8;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("pcafe_num",pcafe_num);
				
		//�� �޴��� ����
		int count = pcafeService.getRowMenuCount(map);

		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/private/private_detail.do?pcafe_num="+pcafe_num);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("currentPage: " + currentPage + ", count : " + count);
		System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
		System.out.println("pcafe_num : " + pcafe_num + ", start: " + page.getStartCount() + ", end: " + page.getEndCount());

		List<PCafeMenuCommand> menuList = null;
		
		if(count > 0) {
			menuList = pcafeService.menuList(map);
			System.out.println("menuList : " +  menuList);
		}else {
			menuList = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("private_detail");
		if(u_uid != null) {
			mav.addObject("u_uid",u_uid);
		}
		mav.addObject("u_level",u_level);
		mav.addObject("pcafe_info",pcafe_info);
		//bookmarkCount�� 0�̶�� �ش� ���̵�� ���ã��� ���� ���� ����-private_detail.jsp���� c�±׷� �˻�
		mav.addObject("bookmarkCount",bookmarkCount);
		//likeCount�� 0�̶�� �ش� ���̵�� ���ƿ並 ���� ���� ����-private_detail.jsp���� c�±׷� �˻�
		mav.addObject("likeCount",likeCount);
		//����ī�� �޴� �κ� ���� �Ѹ��� ����¡ ó���ϴ� �κ�
		mav.addObject("count",count);
		mav.addObject("menuList",menuList);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav; 
	}
	
	//�����۽��� ������ �ҷ��ͼ� ī�� ���� ���������� �Ѹ��� - �±׿� �̹��� ���̴� �κ�(,�� �ɰ��� append�� ���̱� ����)
	@RequestMapping("/cafein_user/private/private_detail_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detail_ajax(@RequestParam int pcafe_num,
												HttpSession session ) {
											//@RequestParam("u_uid") int u_uid 
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		//rowCount = 5;
		//pageCount = 5;
		
		PCafeCommand pcafe_info_list = pcafeService.selectPCafe(pcafe_num);
		System.out.println("pcafe_info_list : " +  pcafe_info_list);
		
		//json ���·� ajax�� ����
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("pcafe_info_list", pcafe_info_list);

		return mapJson;
	}
	
	
	//�����۽��� ������ �ҷ��ͼ� ī�� �޴� ���� ���������� �Ѹ���-ī��޴� Ŭ���� �Ʒ��� ���� �ٴ� �κ�
	@RequestMapping("/cafein_user/private/private_detailMenuDetail_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detailMenuDetail_ajax(@RequestParam int pmenu_num,
														  HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("pmenu_num : " + pmenu_num);
		}
		System.out.println("private_detailMenuDetail_ajax ����");

		PCafeMenuCommand pcafeMenuCommand = null;
		
		pcafeMenuCommand = pcafeService.selectMenuDetail(pmenu_num);
		System.out.println("pcafeMenuCommand : " + pcafeMenuCommand);
		
		//u_uid = null�̸� guest �����ΰ�
		String u_uid = (String)session.getAttribute("u_uid");
		
		//u_uid = null�̸� guest �����ΰ�, ���ƿ� ���� �˻� �Ұ���.
		int menuLikeCount = 0;
		LikeCommand likeCommand = new LikeCommand();
		likeCommand.setPmenu_num(pmenu_num);
		System.out.println("pmenu_num : " + likeCommand.getPmenu_num());
		if(u_uid != null) {
			//���̵� ���� �ش� ī�� ���ƿ� ���� �˻�(jsp���� ���ƿ�/����ϱ� ��ư �����ϱ� ����)
			likeCommand.setU_uid(u_uid);
			menuLikeCount = pcafeService.selectMenuLikeCount(likeCommand);
			
			System.out.println("�޴�  menuLikeCount : " + menuLikeCount);
		}
		
		//��ü ����ڰ� ���ƿ� ���� ��
		int totalMenuLikeCount = 0;
		totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
		
		
		//json ���·� ajax�� ����
		Map<String,Object> map = new HashMap<String,Object> ();
		map.put("pcafeMenuCommand", pcafeMenuCommand);
		map.put("menuLikeCount", menuLikeCount);
		map.put("totalMenuLikeCount", totalMenuLikeCount);
		//������������ cube-portfolio-lightbox.js�� �����ϱ� ���ؼ�.
		map.put("PcafeMenuSuccess", "PcafeMenuSuccess");
		return map;
	}
	
	//�����۽��� ������ �ҷ��ͼ� �ش�ī���� ��� ���� ���������� �Ѹ���(����¡ó��)
	@RequestMapping("/cafein_user/private/private_detailReply_ajax.do")
	@ResponseBody
	public Map<String,Object> PCafe_detailReply_ajax(@RequestParam(value="pageNum", defaultValue="1") int reply_currentPage,
											  @RequestParam int pcafe_num,
											  HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("reply_currentPage : " + reply_currentPage);
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		System.out.println("private_detailReply_ajax ����");
		
		//�� ȭ�鿡 ������ ������ ��
		rowCount = 5;
		pageCount = 5;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("pcafe_num",pcafe_num);
				
		//�� �޴��� ����
		int count = pcafeService.getRowReplyCount(map);

		PagingUtil page = new PagingUtil(reply_currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/private/private_detailMenu_ajax.do?pcafe_num="+pcafe_num);

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		System.out.println("pcafe_num : " + pcafe_num + ", count : " + count + ", start: " + page.getStartCount() + ", end: " + page.getEndCount());

		//System.out.println("count : " + count + ", reply_start: " + page.getStartCount() + ", end: " + page.getEndCount());
		
		List<PCafeReplyCommand> replyList = null;
		
		
		if(count > 0) {
			replyList = pcafeService.replyList(map);
			//���� �������� ������ �޴��� ���� (���������� �������� �޴��� ���ڴ� �ִ� 6���̴�.) �� ���ڸ�ŭ ȭ�鿡 foreach�� �����ֱ� ����.
			System.out.println("replyList : " +  replyList); 
		}else {
			replyList = Collections.emptyList();
		}
		
		
		//json ���·� ajax�� ����
		Map<String,Object> mapJson = new HashMap<String,Object> ();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("replyList", replyList);

		return mapJson;
	}
	
}

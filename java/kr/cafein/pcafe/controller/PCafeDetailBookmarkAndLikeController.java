package kr.cafein.pcafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.pcafe.service.PCafeService;

@Controller
public class PCafeDetailBookmarkAndLikeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PCafeService pcafeService;
	
	//�����۽��� ������ �����ؼ� ���������� �Ѷ��-���ã��(u_uid = null�� ��� guest�ΰ�. ���ƿ�,���ã�� ����.js���� �˻���)
	@RequestMapping("/cafein_user/private/private_detail_bookmark_ajax.do")
	@ResponseBody
	//public Map<String,String> PCafe_detail_Bookmark_ajax(@RequestParam int pcafe_num,
	public Map<String,String> PCafe_detail_Bookmark_ajax(@ModelAttribute BookmarkCommand bookmarkCommand,
												HttpSession session ) {
											//@RequestParam("u_uid") int u_uid 
		if(log.isDebugEnabled()) {
			log.debug("bookmarkCommand : " + bookmarkCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		//null���� ���� �������� ������ ��. 
		bookmarkCommand.setU_uid(u_uid);
		//�ϴ� ���ǿ� u_uid ������ �� �ھƳ���
		//String u_uid = "00001";
		
		bookmarkCommand.setU_uid(u_uid);
		bookmarkCommand.setPcafe_num(bookmarkCommand.getPcafe_num());
		
		//bookmarkCount�� 0�̶�� ���� ���̵� ���ã���� ����� ���ٴ� ��->���ã�� �߰�(insert)���ֱ�
		int bookmarkCount = pcafeService.selectBookmarkCount(bookmarkCommand);
		
		Map<String,String> map = new HashMap<String,String>();
		
		if(bookmarkCount == 0) {
			pcafeService.insertBookmark(bookmarkCommand);
			System.out.println("���ã�� insert : " + bookmarkCommand.toString());
			map.put("result", "bookmarkinsert");
		} else {
			pcafeService.deleteBookmark(bookmarkCommand);
			System.out.println("���ã�� delete");
			map.put("result", "bookmarkdelete");
		}

		return map;
	}
	
	
	//�����۽��� ������ �����ؼ� ���������� �Ѷ��-���ƿ�(u_uid = null�� ��� guest�ΰ�. ���ƿ�,���ã�� ����.js���� �˻���)
	@RequestMapping("/cafein_user/private/private_detail_like_ajax.do")
	@ResponseBody													//pcafe_num ���� ����
	public Map<String,Object> PCafe_detail_like_ajax(@ModelAttribute LikeCommand likeCommand,
												HttpSession session ) {
		if(log.isDebugEnabled()) {
			log.debug("likeCommand : " + likeCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		likeCommand.setU_uid(u_uid);
		likeCommand.setPcafe_num(likeCommand.getPcafe_num());
		
		//likeCount�� 0�̶�� ���� ���̵� ���ƿ��� ����� ���ٴ� ��->���ƿ� �߰�(insert)���ֱ�
		int likeCount = pcafeService.selectLikeCount(likeCommand);
		
		Map<String,Object> map = new HashMap<String,Object>();
		int totalLikeCount = 0;
		
		if(likeCount == 0) {
			pcafeService.insertLike(likeCommand);
			//��ü ������� ���ƿ� ��
			totalLikeCount = pcafeService.selectTotalLikeCount(likeCommand);
			System.out.println("���ƿ� insert : " + likeCommand.toString());
			map.put("result", "likeinsert");
			map.put("totalLikeCount", totalLikeCount);
		} else {
			pcafeService.deleteLike(likeCommand);
			//��ü ������� ���ƿ� ��
			totalLikeCount = pcafeService.selectTotalLikeCount(likeCommand);
			System.out.println("���ƿ� delete");
			map.put("result", "likedelete");
			map.put("totalLikeCount", totalLikeCount);
		}

		return map;
	}
	
	
	//�����۽��� ������ �����ؼ� �޴� ���������� �Ѹ���-���ƿ�(u_uid = null�� ��� guest�ΰ�. ���ƿ�,���ã�� ����.js���� �˻���)
	@RequestMapping("/cafein_user/private/private_detailMenu_like_ajax.do")
	@ResponseBody													//pmenu_num ���� ����
	public Map<String,Object> PCafe_detailMenu_like_ajax(@ModelAttribute LikeCommand likeCommand,
												HttpSession session ) {
		if(log.isDebugEnabled()) {
			log.debug("likeCommand : " + likeCommand);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		likeCommand.setU_uid(u_uid);
		likeCommand.setPmenu_num(likeCommand.getPmenu_num());
		
		//menuLikeCount�� 0�̶�� ���� ���̵� ���ƿ��� ����� ���ٴ� ��->���ƿ� �߰�(insert)���ֱ�
		int menuLikeCount = pcafeService.selectMenuLikeCount(likeCommand);
		
		Map<String,Object> map = new HashMap<String,Object>();
		int totalMenuLikeCount = 0;
		
		if(menuLikeCount == 0) {
			pcafeService.insertMenuLike(likeCommand);
			//��ü ������� ���ƿ� ��
			totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
			System.out.println("���ƿ� insert : " + likeCommand.toString());
			map.put("result", "menulikeinsert");
			map.put("totalMenuLikeCount", totalMenuLikeCount);
		} else {
			pcafeService.deleteMenuLike(likeCommand);
			//��ü ������� ���ƿ� ��
			totalMenuLikeCount = pcafeService.selectMenuTotalLikeCount(likeCommand);
			System.out.println("���ƿ� delete");
			map.put("result", "menulikedelete");
			map.put("totalMenuLikeCount", totalMenuLikeCount);
		}

		return map;
	}
	
}

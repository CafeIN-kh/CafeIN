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
import kr.cafein.domain.BookmarkCommand;
import kr.cafein.mypage.service.MypageService;
import kr.cafein.util.PagingUtil_mypage;

@Controller
public class MypageBookmarkPCafeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	//����¡
	private int rowCount;
	private int pageCount;
	
	@Resource
	private MypageService mypageService;
	
	//���������� ���ã�� ����ī�� �信 ����ϴ� �κ�(����¡)
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_private.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
								HttpSession session) {
		
		System.out.println("mypage_bookmark_private.do ����");
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		//���ǿ� ���� ������ �α��� �������� �̵�
		if(u_uid == null){
			ModelAndView mav = new ModelAndView();
			mav.setView(new RedirectView("/CafeIN/cafein_user/user/login.do"));
			//return "redirect:/cafein_user/user/login.do";
			return mav;
		}else {
			
			//���������� ����ī�� ���ã�� ����¡ ó�� �ϴ� �κ�
			rowCount = 9;
			pageCount = 8;
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("u_uid",u_uid);
					
			//�� ���������� ����ī�� ���ã�� ����
			int count = mypageService.getRowPCafeBookmarkCount(map);
			
			PagingUtil_mypage page = new PagingUtil_mypage(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/mypage/mypage_bookmark_private.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			System.out.println("currentPage: " + currentPage + ", count : " + count);
			System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
			System.out.println("start: " + page.getStartCount() + ", end: " + page.getEndCount());
			
			//�ش� ����ڰ� ���ã���� ����ī�� ����Ʈ ã��
			List<BookmarkAndMypageCommand> bookmarkMypage = null;
			
			if(count > 0) {
				//���ã���� ����ī���� ���� ����Ʈ�� �������ֱ� 
				bookmarkMypage = mypageService.selectPCafeByBookmarkMypage(map);
				
				//����ī�� ��ǥ �̹����� ã�Ƴ��� ����
				String pcafeImgName;
			    String[] pcafeImgNameArray;
			    
			    for(int i=0; i<bookmarkMypage.size(); i++) {
			    	//���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
					pcafeImgName = bookmarkMypage.get(i).getPcafe_img();
				    pcafeImgNameArray = pcafeImgName.split(",");
				    for (int j = 0; j < pcafeImgNameArray.length; j++) {
						//pcafeImgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
						if(pcafeImgNameArray[j].indexOf("*") != -1){
							//*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
							//��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
							pcafeImgNameArray[j] = pcafeImgNameArray[j].replace("*","");
							//���� �̹��� �߿� ��ǥ�̹����� BookmarkAndMypageCommand�� �־��ֱ�(jsp���� �̹��� �ҷ����� ����)
							bookmarkMypage.get(i).setPcafe_img(pcafeImgNameArray[j]);
						}
					}
			    }
			    
				System.out.println("bookmarkMypage : " +  bookmarkMypage);
			}else {
				bookmarkMypage = Collections.emptyList();
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage_bookmark_private");
			mav.addObject("count",count);
			mav.addObject("bookmarkMypage",bookmarkMypage);
			mav.addObject("pagingHtml",page.getPagingHtml());
			
			return mav; 
		}
		
	}
	
	
	//���������� ���ã�� ��� ������ ���
	@RequestMapping("/cafein_user/mypage/mypage_bookmark_private_deleteBookmark.do")
	public String deletePCafeBookmark(@RequestParam int pcafe_num, 
									HttpSession session) {
		
		System.out.println("mypage_bookmark_private_deleteBookmark.do ����");
		if(log.isDebugEnabled()) {
			log.debug("pcafe_num : " + pcafe_num);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//���ǿ� ���� ������ �α��� �������� �̵�
		if(u_uid == null){
			//�α��� �������� �����̷�Ʈ(���ΰ�ħ)
			return "redirect:/cafein_user/user/login.do";
		}else {
			map.put("u_uid",u_uid);
			map.put("pcafe_num",pcafe_num);
			
			//���ã�� �����
			mypageService.deletePCafeBookmarkMypage(map);
			
			//���������� ����ī�� ���ã�� �������� �����̷�Ʈ(���ΰ�ħ)
			return "redirect:/cafein_user/mypage/mypage_bookmark_private.do";
		}
	}
}

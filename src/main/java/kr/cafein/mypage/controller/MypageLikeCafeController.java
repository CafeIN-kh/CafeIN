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

import kr.cafein.domain.LikeAndMypageCommand;
import kr.cafein.mypage.service.MypageService;
import kr.cafein.util.PagingUtil;

@Controller
public class MypageLikeCafeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	//����¡
	private int rowCount;
	private int pageCount;
	
	@Resource
	private MypageService mypageService;
	
	//���������� ���ƿ� ī�� �信 ����ϴ� �κ�(ī����� ���� ����¡)
	@RequestMapping("/cafein_user/mypage/mypage_like_cafe.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage,
								@RequestParam(value="category", defaultValue="1") int category,
								HttpSession session) {
		
		System.out.println("mypage_like_cafe.do ����");
		
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage);
			//category=1 : ����������, category=2 : ����ī��
			log.debug("category : " + category);
		}
		
		String u_uid = (String)session.getAttribute("u_uid");
		
		//���ǿ� ���� ������ �α��� �������� �̵�
		if(u_uid == null){
			ModelAndView mav = new ModelAndView();
			mav.setView(new RedirectView("/CafeIN/cafein_user/user/login.do"));
			return mav;
		}else {
			
			//���������� ���ƿ� ī�� ����¡ ó�� �ϴ� �κ�
			rowCount = 9;
			pageCount = 8;
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("u_uid",u_uid);
			//��񿡼� ����������/����ī��  ī�װ� �����ϱ� ���ؼ� �ʿ�
			map.put("category",category);
					
			//�� ���������� ���ƿ� ī�� ����
			int count = mypageService.getRowCafeLikeCount(map);
			
			PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"/CafeIN/cafein_user/mypage/mypage_like_cafe.do?category="+category);
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			System.out.println("currentPage: " + currentPage + ", count : " + count);
			System.out.println("rowCount: " + rowCount + ", pageCount : " + pageCount);
			System.out.println("start: " + page.getStartCount() + ", end: " + page.getEndCount());
			
			//�ش� ����ڰ� ���ƿ� ī��  ����Ʈ ã��
			List<LikeAndMypageCommand> likeMypage = null;
			
			if(count > 0) {
				//���ƿ��� ī����  ���� ����Ʈ�� �������ֱ� 
				likeMypage = mypageService.selectCafeByLikeMypage(map);
				
				//����ī�� ī�װ��� ��� ��ǥ�̹��� ������ ���� ������ �ʿ���
				if(category == 2) {
					//����ī�� ��ǥ �̹����� ã�Ƴ��� ����
					String imgName;
				    String[] imgNameArray;
				    
				    for(int i=0; i<likeMypage.size(); i++) {
				    	//���ڿ��� ,�� �ִٸ� �ɰ��� �迭�� ���
				    	imgName = likeMypage.get(i).getPcafe_img();
				    	imgNameArray = imgName.split(",");
					    for (int j = 0; j < imgNameArray.length; j++) {
							//imgNameArray �ε��� �ȿ� * ���� ������ -1 ��ȯ
							if(imgNameArray[j].indexOf("*") != -1){
								//*�� �ִٴ� ���̹Ƿ� *ǥ�� ������ ��ü
								//��ǥ�̹��� ã�Ƽ� *ǥ�� �����ֱ�
								imgNameArray[j] = imgNameArray[j].replace("*","");
								//���� �̹��� �߿� ��ǥ�̹����� LikeAndMypageCommand�� �־��ֱ�(jsp���� �̹��� �ҷ����� ����)
								likeMypage.get(i).setPcafe_img(imgNameArray[j]);
							}
						}
				    }
				}
				
				System.out.println("likeMypage : " +  likeMypage);
			}else {
				likeMypage = Collections.emptyList();
				System.out.println("count=0�̶� likeMypage ���� ����");
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage_like_cafe");
			mav.addObject("count",count);
			mav.addObject("likeMypage",likeMypage);
			mav.addObject("pagingHtml",page.getPagingHtml());
			mav.addObject("category",category);
			
			return mav; 
		}
	}
	
	
	//���������� ���ƿ� ��� ������ ���
	@RequestMapping("/cafein_user/mypage/mypage_like_cafe_deletelike.do")
	public String deleteCafeLike(@RequestParam(value="category", defaultValue="1") int category,
								 @RequestParam(value="franchise_num", defaultValue="0") int franchise_num, 
								 @RequestParam(value="pcafe_num", defaultValue="0") int pcafe_num, 
								 HttpSession session) {
		
		System.out.println("mypage_like_cafe_deletelike.do ����");
		if(log.isDebugEnabled()) {
			log.debug("category : " + category);
			log.debug("franchise_num : " + franchise_num);
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
			map.put("category",category);
			map.put("franchise_num",franchise_num);
			map.put("pcafe_num",pcafe_num);
			
			//���ã�� �����
			mypageService.deleteCafeLikeMypage(map);
			
			//���������� ����ī�� ���ã�� �������� �����̷�Ʈ(���ΰ�ħ)
			return "redirect:/cafein_user/mypage/mypage_like_cafe.do?category="+category;
		}
	}
	
}

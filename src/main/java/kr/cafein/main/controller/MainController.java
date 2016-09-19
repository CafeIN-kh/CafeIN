package kr.cafein.main.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;
import kr.cafein.main.service.MainService;



@Controller
public class MainController {
  
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="mainService") //필요로 하는 자원을 자동 연결
	private MainService mainService;
	
	@RequestMapping("/cafein_user/main/main.do") //메서드가 처리할 요청 경로 지정
	public ModelAndView process(){//웹 요청을 처리할 메서드
		
		//커스텀마이징 메뉴 좋아요 
		List<ULikeCommand> cLikeCommand = null;
		List<CustomizingCommand> customizingCommand = null;
		
		cLikeCommand = mainService.selectCLike();
		customizingCommand = mainService.selectLikeCustomizing();

		System.out.println("uLikeCommand.size() : " + cLikeCommand.size());
		System.out.println("customizingCommand.size() : " + customizingCommand.size());
		System.out.println("customizingCommand.toString() : " + customizingCommand.toString());
		
		/*for(int i=0; i<uLikeCommand.size(); i++) {
			int custom_num = uLikeCommand.get(i).getCustom_num();	
			System.out.println("custom_num :" + custom_num);
			System.out.println("customizingCommandNum:" + mainService.selectLikeCustomizing());
			customizingCommand.add(mainService.selectLikeCustomizing());
		}*/
		/*for(int i=0; i<uLikeCommand.size(); i++) {
			int custom_num = uLikeCommand.get(i).getCustom_num();
			int count = uLikeCommand.get(i).getCount();
			
			System.out.println("custom_num :" + custom_num);
			System.out.println("customizingCommand:" + mainService.selectLikeCustomizing());
			customizingCommand.add((CustomizingCommand) mainService.selectLikeCustomizing());
			
			System.out.println("customizingCommand : " + customizingCommand.get(i).toString());
		}*/
		
		//프랜차이즈 즐겨찾기
		FranchiseCommand franchiseCommandB;
		
		franchiseCommandB = mainService.selectBookmarkFranchise();
		
		if(franchiseCommandB != null) {
			System.out.println("franchiseCommand name :" + franchiseCommandB.getFranchise_name());
			System.out.println("franchiseCommand Fnum : " + franchiseCommandB.getFranchise_num());
		}
		
		//개인카페 즐겨찾기
		List<PrivateCafeCommand> privateCafeCommand = null;
		privateCafeCommand = mainService.selectBookmarkPrivateCafe();
		
		
		//프랜차이즈 메뉴 좋아요
		List<ULikeCommand> fmenuLikeCommand = null;
		List<FranchiseMenuCommand> fmenuCommandL;
		fmenuLikeCommand = mainService.selectFMLike();
		fmenuCommandL = mainService.selectLikeFmenu();
		
		
		System.out.println("fmenuCommandL.size() : " + fmenuCommandL.size());
		System.out.println("fmenuCommandL.toString() : " + fmenuCommandL.toString());
		
		
		//개인카페 메뉴 좋아요
		List<ULikeCommand> pmenuLikeCommand = null;
		List<PrivateCafeMenuCommand> pmenuCommandL;
		pmenuLikeCommand = mainService.selectPMLike();
		pmenuCommandL = mainService.selectLikePmenu();
		
		System.out.println("pmenuCommandL.size() : " + pmenuCommandL.size());
		System.out.println("pmenuCommandL.toString() : " + pmenuCommandL.toString());

		ModelAndView mav = new ModelAndView();
		//데이터 매칭
		mav.setViewName("main");
		
		mav.addObject("cLikeCommand",cLikeCommand);
		mav.addObject("customizingCommand",customizingCommand);
		
		mav.addObject("franchiseCommandB",franchiseCommandB);
		
		mav.addObject("privateCafeCommand", privateCafeCommand);
		
		mav.addObject("fmenuLikeCommand", fmenuLikeCommand);
		mav.addObject("fmenuCommandL", fmenuCommandL);
		
		mav.addObject("pmenuLikeCommand", pmenuLikeCommand);
		mav.addObject("pmenuCommandL", pmenuCommandL);
		
		return mav;
	}
	
}

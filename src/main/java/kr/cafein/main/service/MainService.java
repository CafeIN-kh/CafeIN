package kr.cafein.main.service;

import java.util.List;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;
import kr.cafein.domain.UserCountLogCommand;



public interface MainService { 
	
	//커스텀마이징 메뉴 좋아요
	//public List<ULikeCommand> uList(Map<String, Object> map);
	
	public List<ULikeCommand> selectCLike();
	public List<CustomizingCommand> selectLikeCustomizing();
	
	
	//프랜차이즈 즐겨찾기
	//public List<MainBookmarkCommand> bList(Map<String, Object> map);
	
	public FranchiseCommand selectBookmarkFranchise();
	
	//개인카페 즐겨찾기
	public List<PrivateCafeCommand> selectBookmarkPrivateCafe();
	
	//프랜차이즈 메뉴 좋아요
	//public List<ULikeCommand> selectFMLike();
	public List<FranchiseMenuCommand> selectLikeFmenu();
		
	
	//개인카페 메뉴 좋아요
	//public List<ULikeCommand> selectPMLike();
	public List<PrivateCafeMenuCommand> selectLikePmenu();

	//메인 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	public void insertMainUserCountLog();
	public void updateMainUserCountLog();
	public UserCountLogCommand selectMainUserCountLogByDate();
	
}

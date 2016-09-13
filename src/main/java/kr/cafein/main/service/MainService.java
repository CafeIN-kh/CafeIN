package kr.cafein.main.service;

import java.util.List;
import java.util.Map;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.MainBookmarkCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;



public interface MainService { 
	
	//Ŀ���Ҹ���¡ �޴� ���ƿ�
	public List<ULikeCommand> uList(Map<String, Object> map);
	
	public List<ULikeCommand> selectCLike();
	public List<CustomizingCommand> selectLikeCustomizing();
	
	
	//���������� ���ã��
	public List<MainBookmarkCommand> bList(Map<String, Object> map);
	
	public FranchiseCommand selectBookmarkFranchise();
	
	//����ī�� ���ã��
	public List<PrivateCafeCommand> selectBookmarkPrivateCafe();
	
	//���������� �޴� ���ƿ�
	public List<ULikeCommand> selectFMLike();
	public List<FranchiseMenuCommand> selectLikeFmenu();
		
	
	//����ī�� �޴� ���ƿ�
	public List<ULikeCommand> selectPMLike();
	public List<PrivateCafeMenuCommand> selectLikePmenu();

	
	
}
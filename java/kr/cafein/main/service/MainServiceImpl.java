package kr.cafein.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;
import kr.cafein.domain.FranchiseMenuCommand;
import kr.cafein.domain.MainBookmarkCommand;
import kr.cafein.domain.PrivateCafeCommand;
import kr.cafein.domain.PrivateCafeMenuCommand;
import kr.cafein.domain.ULikeCommand;
import kr.cafein.main.dao.MainMapper;



@Service("mainService")
public class MainServiceImpl implements MainService{
	
	@Resource
	private MainMapper mainMapper;
	
	//Ŀ���Ҹ���¡ �޴� ���ƿ�
	/*@Override
	public List<ULikeCommand> uList(Map<String, Object> map) {
		return null;
	}*/
	@Override
	public List<ULikeCommand> selectCLike() {
		return mainMapper.selectCLike();
	}
		@Override
	public List<CustomizingCommand> selectLikeCustomizing() {
		return mainMapper.selectLikeCustomizing();
	}



	//���������� ���ã��
	/*@Override
	public List<MainBookmarkCommand> bList(Map<String, Object> map) {
		return null;
	}*/


	@Override
	public FranchiseCommand selectBookmarkFranchise() {
		return mainMapper.selectBookmarkFranchise();
	}
	//����ī�� ���ã��

	@Override
	public List<PrivateCafeCommand> selectBookmarkPrivateCafe() {
		return mainMapper.selectBookmarkPrivateCafe();
	}
	
	//���������� �޴� ���ƿ�
	/*@Override
	public List<ULikeCommand> selectFMLike() {
		return null;
	}*/
	@Override
	public List<FranchiseMenuCommand> selectLikeFmenu() {
		return mainMapper.selectLikeFmenu();
	}
		
	//����ī�� �޴� ���ƿ�
	/*@Override
	public List<ULikeCommand> selectPMLike() {
		return null;
	}*/
	@Override
	public List<PrivateCafeMenuCommand> selectLikePmenu() {
		return mainMapper.selectLikePmenu();
	}


	






}

package kr.cafein.admin.privatecafe.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.privatecafe.dao.PrivateMapper;
import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Service("privateService")
public class PrivateServiceImpl implements PrivateService{
	
	@Resource
	private PrivateMapper privateMapper;

	@Override
	public List<PrivateCommand> getPrivateList() {
		return privateMapper.getPrivateList();
		
	}
	
	@Override
	public PrivateCommand selectBoard(Integer seq) {
		return privateMapper.selectBoard(seq);
	}

	@Override
	public void delete(Integer seq) {
		privateMapper.delete(seq);
	}

	@Override
	public void update(PrivateCommand privatecafe) {
		privateMapper.update(privatecafe);
		
	}

	@Override
	public List<PrivateCommand> getPrivateDetailList(Integer seq) {
		return privateMapper.getPrivateDetailList(seq);
	}

	@Override
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer seq) {
		
		return privateMapper.getPrivateCafeMenuList(seq);
	}

	@Override
	public PrivateMenuCommand selectMenu(Integer seq) {
		return privateMapper.selectMenu(seq);
	}

	@Override
	public void update2(PrivateMenuCommand privateCafeMenu) {
		// TODO Auto-generated method stub
		privateMapper.update2(privateCafeMenu);
	}



	
	/*

	@Override
	public List<PrivateCommand> getPrivateDetailList() {
		return privateMapper.getPrivateDetailList();
	}*/


}

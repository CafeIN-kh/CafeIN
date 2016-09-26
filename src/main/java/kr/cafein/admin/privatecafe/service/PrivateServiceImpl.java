package kr.cafein.admin.privatecafe.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.dao.PrivateMapper;

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
	public PrivateCommand selectBoard(Integer pcafe_num) {
		return privateMapper.selectBoard(pcafe_num);
	}

	@Override
	public void delete(Integer pcafe_num) {
		privateMapper.delete(pcafe_num);
	}

	@Override
	public void update(PrivateCommand privatecafe) {
		privateMapper.update(privatecafe);
		
	}

	@Override
	public List<PrivateCommand> getPrivateDetailList(Integer pcafe_num) {
		return privateMapper.getPrivateDetailList(pcafe_num);
	}

	@Override
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer pcafe_num) {
		
		return privateMapper.getPrivateCafeMenuList(pcafe_num);
	}

	@Override
	public PrivateMenuCommand selectMenu(Integer pmenu_num) {
		return privateMapper.selectMenu(pmenu_num);
	}

	@Override
	public void update2(PrivateMenuCommand privateCafeMenu) {
		// TODO Auto-generated method stub
		privateMapper.update2(privateCafeMenu);
	}

	@Override
	public int getRowCount(int pcafe_num) {	
		// TODO Auto-generated method stub
		return privateMapper.getRowCount(pcafe_num);
	}

	@Override
	public List<PrivateMenuCommand> menuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return privateMapper.menuList(map);
	}



	
	/*

	@Override
	public List<PrivateCommand> getPrivateDetailList() {
		return privateMapper.getPrivateDetailList();
	}*/


}

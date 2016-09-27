package kr.cafein.admin.privatecafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Repository
public interface PrivateService {
	public List<PrivateCommand> getPrivateList();
	public PrivateCommand selectBoard(Integer pcafe_num);
	public void delete(Integer pcafe_num);
	public void update(PrivateCommand privatecafe);
	
	public List<PrivateCommand> getPrivateDetailList(Integer pcafe_num);
	
	public List<PrivateMenuCommand> menuList(Map<String,Object> map);
	
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer pcafe_num);
	
	public PrivateMenuCommand selectMenu(Integer pmenu_num);
	
	public void update2(PrivateMenuCommand privateCafeMenu);
	
	public void deletemenu(Integer pmenu_num);
	
	@Transactional(readOnly=true)
	public int getRowCount(int pcafe_num);



}
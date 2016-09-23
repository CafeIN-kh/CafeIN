package kr.cafein.admin.privatecafe.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Repository
public interface PrivateService {
	public List<PrivateCommand> getPrivateList();
	public PrivateCommand selectBoard(Integer seq);
	public void delete(Integer seq);
	public void update(PrivateCommand privatecafe);
	
	public List<PrivateCommand> getPrivateDetailList(Integer seq);
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer seq);
	
	public PrivateMenuCommand selectMenu(Integer seq);
	
	public void update2(PrivateMenuCommand privateCafeMenu);



}

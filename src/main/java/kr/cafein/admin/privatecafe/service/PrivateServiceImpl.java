package kr.cafein.admin.privatecafe.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateReplyCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.admin.privatecafe.dao.PrivateMapper;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;
import kr.cafein.admin.privatecafe.domain.PrivateLogCommand;

@Service("privateService")
public class PrivateServiceImpl implements PrivateService{
	
	@Resource
	private PrivateMapper privateMapper;

	@Override
	public List<PrivateCommand> getPrivateList() {
		return privateMapper.getPrivateList();
		
	}
	
	@Override
	public void deletemenu(Integer pmenu_num) {
		privateMapper.deletemenu(pmenu_num);
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

	@Override
	public List<LikeCommand> getLikeUser(Integer pcafe_num) {
		// TODO Auto-generated method stub
		return privateMapper.getLikeUser(pcafe_num);
	}

	@Override
	public void deleteallmenu(Integer pcafe_num) {
		// TODO Auto-generated method stub
		privateMapper.deleteallmenu(pcafe_num);
	}

	@Override
	public void deletereply(Integer pcafe_num) {
		// TODO Auto-generated method stub
		privateMapper.deletereply(pcafe_num);
	}

	@Override
	public List<PrivateReplyCommand> selectReplyp(int pcafe_num) {
		// TODO Auto-generated method stub
		return privateMapper.selectReplyp(pcafe_num);
	}

	@Override
	public int selectPcafe_num(Integer preply_num) {
		// TODO Auto-generated method stub
		return privateMapper.selectPcafe_num(preply_num);
	}

	@Override
	public void deletePrivateReplyAdminp(int preply_num) {
		// TODO Auto-generated method stub
		privateMapper.deletePrivateReplyAdminp(preply_num);
	}

	@Override
	public MemberCommand selectEmail(String u_uid) {
		return privateMapper.selectEmail(u_uid);
	}

	@Override
	public void insertAdminPrivateLog(UserMenuLogCommand userMenuLogCommand) {
		// TODO Auto-generated method stub
		privateMapper.insertAdminPrivateLog(userMenuLogCommand);
	}

	@Override
	public void insertLog(PrivateLogCommand privateLogCommand) {
		// TODO Auto-generated method stub
		privateMapper.insertLog(privateLogCommand);
	}

	@Override
	public List<PrivateLogCommand> selectLog() {
		// TODO Auto-generated method stub
		return privateMapper.selectLog();
	}

	
	
	
	
	
	
	

}

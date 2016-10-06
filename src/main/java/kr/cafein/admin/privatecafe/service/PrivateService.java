package kr.cafein.admin.privatecafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateReplyCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserMenuLogCommand;
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
	
	public List<LikeCommand> getLikeUser(Integer pcafe_num);
	
	@Transactional(readOnly=true)
	public int getRowCount(int pcafe_num);


	public void deleteallmenu(Integer pcafe_num);
	
	public void deletereply(Integer pcafe_num);
	
	public List<PrivateReplyCommand> selectReplyp(int pcafe_num);
	
	
	
	

	
	
	public int selectPcafe_num(Integer preply_num);
	
	public void deletePrivateReplyAdminp(int preply_num);
	
	public MemberCommand selectEmail(String u_uid);
	
	public void insertAdminPrivateLog(UserMenuLogCommand userMenuLogCommand);

}

package kr.cafein.admin.franchise.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseLogCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;


@Transactional
public interface AdminFranchiseService {
	
	public void updateFranchiseMenu(AdminFranchiseMenuCommand adminFranchiseMenuCommand);
	
	public void updateFranchise(AdminFranchiseCommand adminFranchiseCommand);
	
	public List<AdminFranchiseCommand> list(String franchise_name);
	
	public List<AdminFranchiseLogCommand> logList();
	
	public List<AdminFranchiseCommand> listDetail(int franchise_num);
	
	public List<AdminFranchiseMenuCommand> menuList(Map<String,Object> map);
	
	public List<AdminFranchiseMenuCommand> menuList2();
	
	public AdminFranchiseCommand selectFranchise(int franchise_num);
	
	public void insert(AdminFranchiseCommand board);
	
	public void insertMenu(AdminFranchiseMenuCommand board);
	
	public void delete(int franchise_num);
	
	public void deletemenu(int fmenu_num);
	
	public String getFranchise_name(int franchise_num);
	
	public int getFranchise_num(int franchise_num);
	
	public void updateHit(int franchise_num);
	
	@Transactional(readOnly=true)
	public int getRowCount(int franchise_num);

	public AdminFranchiseCommand selectFranchiseDetail(int franchise_num);

	public AdminFranchiseMenuCommand selectFmenu(int fmenu_num);
	
	public void f_log_insert(AdminFranchiseLogCommand board);
	
}
   
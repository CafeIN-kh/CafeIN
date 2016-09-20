package kr.cafein.admin.franchise.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.franchise.dao.AdminFranchiseMapper;
import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;

@Service("adminFranchiseService")
public class AdminFranchiseServiceImpl implements AdminFranchiseService{

	@Resource
	private AdminFranchiseMapper adminfranchiseMapper;
		
	@Override
	public void delete(int franchise_num) {
		adminfranchiseMapper.delete(franchise_num);
	}
	
	@Override
	public void deletemenu(int fmenu_num) {
		adminfranchiseMapper.deletemenu(fmenu_num);
	}
	
	@Override
	public List<AdminFranchiseCommand> list(String franchise_name) {
		return adminfranchiseMapper.list(franchise_name);
	}
	@Override
	public List<AdminFranchiseMenuCommand> menuList(Map<String, Object> map) {
		return adminfranchiseMapper.menuList(map);
	}
	@Override
	public void updateHit(int franchise_num) {
		adminfranchiseMapper.updateHit(franchise_num);
	}

	@Override
	public AdminFranchiseCommand selectFranchise(int franchise_num) {
		return adminfranchiseMapper.selectFranchise(franchise_num);	
	}

	@Override
	public void insert(AdminFranchiseCommand board) {
		adminfranchiseMapper.insert(board);	
	}
	@Override
	public void insertMenu(AdminFranchiseMenuCommand board){
		adminfranchiseMapper.insertMenu(board);
	}

	@Override
	public String getFranchise_name(int franchise_num) {
		return adminfranchiseMapper.getFranchise_name(franchise_num);
	}

	@Override
	public int getRowCount(int franchise_num) {
		return adminfranchiseMapper.getRowCount(franchise_num);
	}

	@Override
	public List<AdminFranchiseCommand> listDetail(int franchise_num) {
		return adminfranchiseMapper.listDetail(franchise_num);
	}

	@Override
	public AdminFranchiseCommand selectFranchiseDetail(int franchise_num) {
		return adminfranchiseMapper.selectFranchiseDetail(franchise_num);
	}

	@Override
	public List<AdminFranchiseMenuCommand> menuList2() {
		return adminfranchiseMapper.menuList2();
	}

	@Override
	public void updateFranchise(AdminFranchiseCommand adminFranchiseCommand) {
		adminfranchiseMapper.updateFranchise(adminFranchiseCommand);
	}

	@Override
	public void updateFranchiseMenu(AdminFranchiseMenuCommand adminFranchiseMenuCommand) {
		adminfranchiseMapper.updateFranchiseMenu(adminFranchiseMenuCommand);
	}

	@Override
	public AdminFranchiseMenuCommand selectFmenu(int fmenu_num) {
		return adminfranchiseMapper.selectFmenu(fmenu_num);
	}

	@Override
	public int getFranchise_num(int franchise_num) {
		return adminfranchiseMapper.getFranchise_num(franchise_num);
	}



}
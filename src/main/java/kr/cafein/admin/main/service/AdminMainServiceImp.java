package kr.cafein.admin.main.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.main.dao.AdminMainMapper;
import kr.cafein.admin.main.domain.AdminMainCountCommand;
import kr.cafein.admin.main.domain.AdminMainCustomizingCommand;
import kr.cafein.admin.main.domain.AdminMainFranchiseCommand;
import kr.cafein.admin.main.domain.AdminMainNoticeCommand;
import kr.cafein.admin.main.domain.AdminMainPrivateCommand;

@Service("adminMainService")
public class AdminMainServiceImp implements AdminMainService{

	@Resource
	private AdminMainMapper adminMainMapper;
	@Override
	public List<AdminMainFranchiseCommand> franchiseTotalCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.franchiseTotalCount();
	}
	@Override
	public List<AdminMainPrivateCommand> privateTotalCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.privateTotalCount();
	}
	@Override
	public List<AdminMainCustomizingCommand> customTotalCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.customTotalCount();
	}
	@Override
	public int pageTotal() {
		// TODO Auto-generated method stub
		return adminMainMapper.pageTotal();
	}
	@Override
	public int franchiseTotal() {
		// TODO Auto-generated method stub
		return adminMainMapper.franchiseTotal();
	}
	@Override
	public int privateTotal() {
		// TODO Auto-generated method stub
		return adminMainMapper.privateTotal();
	}
	@Override
	public int customizingTotal() {
		// TODO Auto-generated method stub
		return adminMainMapper.customizingTotal();
	}
	@Override
	public List<AdminMainCountCommand> franchiseCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.franchiseCount();
	}
	@Override
	public List<AdminMainCountCommand> privateCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.privateCount();
	}
	@Override
	public List<AdminMainCountCommand> customCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.customCount();
	}
	@Override
	public List<AdminMainCountCommand> pmenuCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.pmenuCount();
	}
	@Override
	public List<AdminMainCountCommand> fmenuCount() {
		// TODO Auto-generated method stub
		return adminMainMapper.fmenuCount();
	}
	@Override
	public List<AdminMainNoticeCommand> selectNotice() {
		// TODO Auto-generated method stub
		return adminMainMapper.selectNotice();
	}
}

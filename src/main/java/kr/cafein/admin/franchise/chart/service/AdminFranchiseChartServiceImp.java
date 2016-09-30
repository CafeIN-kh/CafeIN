package kr.cafein.admin.franchise.chart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.franchise.chart.dao.AdminFranchiseChartMapper;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseBookmarkCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseChartCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseDeClaredCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseLikeCommand;

@Service("adminfranchiseChartService")
public class AdminFranchiseChartServiceImp implements AdminFranchiseChartService{

	@Resource
	private AdminFranchiseChartMapper adminFranchiseMapper;
	@Override
	public List<AdminFranchiseChartCommand> pageViewCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.pageViewCount();
	}
	@Override
	public int franchisePageViewTotal() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchisePageViewTotal();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseLikeDayCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseMenuLikeDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseMenuLikeDayCount();
	}
	@Override
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseBookmarkDayCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseLikeMonthCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeMenuMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseLikeMenuMonthCount();
	}
	@Override
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseBookmarkMonthCount();
	}
	@Override
	public List<AdminFranchiseDeClaredCommand> franchiseDeClaredCount() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.franchiseDeClaredCount();
	}
	@Override
	public int fDeClaredCountToTal() {
		// TODO Auto-generated method stub
		return adminFranchiseMapper.fDeClaredCountToTal();
	}
}

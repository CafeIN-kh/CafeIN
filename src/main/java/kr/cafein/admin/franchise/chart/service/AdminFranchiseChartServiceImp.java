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
	private AdminFranchiseChartMapper adminFranchiseChartMapper;
	@Override
	public List<AdminFranchiseChartCommand> pageViewCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.pageViewCount();
	}
	@Override
	public int franchisePageViewTotal() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchisePageViewTotal();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseLikeDayCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseMenuLikeDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseMenuLikeDayCount();
	}
	@Override
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkDayCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseBookmarkDayCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseLikeMonthCount();
	}
	@Override
	public List<AdminFranchiseLikeCommand> franchiseLikeMenuMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseLikeMenuMonthCount();
	}
	@Override
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkMonthCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseBookmarkMonthCount();
	}
	@Override
	public List<AdminFranchiseDeClaredCommand> franchiseDeClaredCount() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.franchiseDeClaredCount();
	}
	@Override
	public int fDeClaredCountToTal() {
		// TODO Auto-generated method stub
		return adminFranchiseChartMapper.fDeClaredCountToTal();
	}
}

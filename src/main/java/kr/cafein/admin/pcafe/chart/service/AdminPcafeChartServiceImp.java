package kr.cafein.admin.pcafe.chart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.pcafe.chart.dao.AdminPcafeChartMapper;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeBookmarkCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeChartCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeDeClaredCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeLikeCommand;

@Service("adminPcafeChartService")
public class AdminPcafeChartServiceImp implements AdminPcafeChartService {

	@Resource
	private AdminPcafeChartMapper adminPcafeChartMapper;
	
	@Override
	public List<AdminPcafeChartCommand> pageViewPcafeCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pageViewPcafeCount();
	}

	@Override
	public int pcafePageViewTotal() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pcafePageViewTotal();
	}

	@Override
	public List<AdminPcafeLikeCommand> pCafeLikeDayCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pCafeLikeDayCount();
	}

	@Override
	public List<AdminPcafeLikeCommand> pCafeMenuLikeDayCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pCafeMenuLikeDayCount();
	}

	@Override
	public List<AdminPcafeLikeCommand> pCafeLikeMonthCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pCafeLikeMonthCount();
	}

	@Override
	public List<AdminPcafeLikeCommand> pCafeLikeMenuMonthCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pCafeLikeMenuMonthCount();
	}

	@Override
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkDayCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pcafeBookmarkDayCount();
	}

	@Override
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkMonthCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pcafeBookmarkMonthCount();
	}

	@Override
	public List<AdminPcafeDeClaredCommand> pcafeDeClaredCount() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pcafeDeClaredCount();
	}

	@Override
	public int pDeClaredCountToTal() {
		// TODO Auto-generated method stub
		return adminPcafeChartMapper.pDeClaredCountToTal();
	}

}

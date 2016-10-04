package kr.cafein.admin.custom.chart.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.custom.chart.dao.AdminCustomChartMapper;
import kr.cafein.admin.custom.chart.domain.AdminCustomBookmarkCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomChartCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomDeClaredCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomLikeCommand;

@Service("adminCustomChartService")
public class AdminCustomChartServiceImp implements AdminCustomChartService{

	@Resource
	private AdminCustomChartMapper adminCustomChartMapper;
	
	@Override
	public List<AdminCustomChartCommand> pageViewCustomCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.pageViewCustomCount();
	}

	@Override
	public List<AdminCustomLikeCommand> customLikeDayCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.customLikeDayCount();
	}

	@Override
	public List<AdminCustomLikeCommand> customLikeMonthCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.customLikeMonthCount();
	}

	@Override
	public List<AdminCustomBookmarkCommand> customBookmarkDayCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.customBookmarkDayCount();
	}

	@Override
	public List<AdminCustomBookmarkCommand> customBookmarkMonthCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.customBookmarkMonthCount();
	}

	@Override
	public List<AdminCustomDeClaredCommand> cDeClaredCount() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.cDeClaredCount();
	}

	@Override
	public int cDeClaredCountToTal() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.cDeClaredCountToTal();
	}

	@Override
	public int customPageViewTotal() {
		// TODO Auto-generated method stub
		return adminCustomChartMapper.customPageViewTotal();
	}

}

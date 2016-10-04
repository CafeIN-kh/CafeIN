package kr.cafein.admin.pcafe.chart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.pcafe.chart.domain.AdminPcafeBookmarkCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeChartCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeDeClaredCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeLikeCommand;

@Transactional
public interface AdminPcafeChartService {


	public List<AdminPcafeChartCommand> pageViewPcafeCount();
	public int pcafePageViewTotal();
	public List<AdminPcafeLikeCommand> pCafeLikeDayCount();
	public List<AdminPcafeLikeCommand> pCafeMenuLikeDayCount();
	public List<AdminPcafeLikeCommand> pCafeLikeMonthCount();
	public List<AdminPcafeLikeCommand> pCafeLikeMenuMonthCount();
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkDayCount();
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkMonthCount();
	public List<AdminPcafeDeClaredCommand> pcafeDeClaredCount();
	public int pDeClaredCountToTal();
}

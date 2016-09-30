package kr.cafein.admin.franchise.chart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.franchise.chart.domain.AdminFranchiseBookmarkCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseChartCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseDeClaredCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseLikeCommand;

@Transactional
public interface AdminFranchiseChartService {

	public List<AdminFranchiseChartCommand> pageViewCount();
	public int franchisePageViewTotal();
	public List<AdminFranchiseLikeCommand> franchiseLikeDayCount();
	public List<AdminFranchiseLikeCommand> franchiseMenuLikeDayCount();
	public List<AdminFranchiseLikeCommand> franchiseLikeMonthCount();
	public List<AdminFranchiseLikeCommand> franchiseLikeMenuMonthCount();
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkDayCount();
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkMonthCount();
	public List<AdminFranchiseDeClaredCommand> franchiseDeClaredCount();
	public int fDeClaredCountToTal();
}

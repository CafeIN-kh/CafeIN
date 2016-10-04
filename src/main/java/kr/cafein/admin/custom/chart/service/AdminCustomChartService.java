package kr.cafein.admin.custom.chart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.custom.chart.domain.AdminCustomBookmarkCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomChartCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomDeClaredCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomLikeCommand;

@Transactional
public interface AdminCustomChartService {

	public List<AdminCustomChartCommand> pageViewCustomCount();
	public int customPageViewTotal();
	public List<AdminCustomLikeCommand> customLikeDayCount();
	public List<AdminCustomLikeCommand> customLikeMonthCount();
	public List<AdminCustomBookmarkCommand> customBookmarkDayCount();
	public List<AdminCustomBookmarkCommand> customBookmarkMonthCount();
	public List<AdminCustomDeClaredCommand> cDeClaredCount();
	public int cDeClaredCountToTal();
}

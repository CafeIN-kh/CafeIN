package kr.cafein.admin.custom.chart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.custom.chart.domain.AdminCustomBookmarkCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomChartCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomDeClaredCommand;
import kr.cafein.admin.custom.chart.domain.AdminCustomLikeCommand;

@Repository
public interface AdminCustomChartMapper {

	@Select("SELECT to_char(ucnt_log_reg_date,'MMDD') reg_date,sum(ucnt_log_custom) ucnt_log_custom FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminCustomChartCommand> pageViewCustomCount();
	@Select("SELECT sum(ucnt_log_custom) count FROM user_count_log")
	public int customPageViewTotal();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE custom_num != 0 AND custom_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminCustomLikeCommand> customLikeDayCount();
	@Select("SELECT to_char(like_reg_date,'MM') like_reg_date , count(*) count FROM u_like WHERE custom_num != 0 AND custom_num is not null AND to_char(like_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12) GROUP BY to_char(like_reg_date,'MM') ORDER BY like_reg_date ASC")
	public List<AdminCustomLikeCommand> customLikeMonthCount();
	@Select("SELECT to_char(bookmark_reg_date,'YYYY/MM/DD') bookmark_reg_date , count(*) count from bookmark WHERE custom_num != 0 AND custom_num is not null AND to_char(bookmark_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD')  GROUP BY to_char(bookmark_reg_date,'YYYY/MM/DD') ORDER BY bookmark_reg_date ASC")
	public List<AdminCustomBookmarkCommand> customBookmarkDayCount();
	@Select("SELECT to_char(bookmark_reg_date,'MM') bookmark_reg_date , count(*) count FROM bookmark WHERE custom_num != 0 AND custom_num is not null AND to_char(bookmark_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12)  GROUP BY to_char(bookmark_reg_date,'MM') ORDER BY bookmark_reg_date ASC")
	public List<AdminCustomBookmarkCommand> customBookmarkMonthCount();
	@Select("SELECT to_char(d_reg_date,'MMDD') reg_date,count(*) count FROM declared WHERE d_target_path=2 and to_char(d_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(d_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminCustomDeClaredCommand> cDeClaredCount();
	@Select("select count(*) count from declared where d_target_path = 2")
	public int cDeClaredCountToTal();
}


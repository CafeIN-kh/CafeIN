package kr.cafein.admin.pcafe.chart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.pcafe.chart.domain.AdminPcafeBookmarkCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeChartCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeDeClaredCommand;
import kr.cafein.admin.pcafe.chart.domain.AdminPcafeLikeCommand;

@Repository
public interface AdminPcafeChartMapper {

	@Select("SELECT to_char(ucnt_log_reg_date,'MMDD') reg_date,sum(ucnt_log_private) ucnt_log_private FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminPcafeChartCommand> pageViewPcafeCount();
	@Select("SELECT sum(ucnt_log_private) count FROM user_count_log")
	public int pcafePageViewTotal();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE pcafe_num != 0 AND pcafe_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminPcafeLikeCommand> pCafeLikeDayCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE pmenu_num != 0 AND pmenu_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminPcafeLikeCommand> pCafeMenuLikeDayCount();
	@Select("SELECT to_char(like_reg_date,'MM') like_reg_date , count(*) count FROM u_like WHERE pcafe_num != 0 AND pcafe_num is not null AND to_char(like_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12) GROUP BY to_char(like_reg_date,'MM') ORDER BY like_reg_date ASC")
	public List<AdminPcafeLikeCommand> pCafeLikeMonthCount();
	@Select("SELECT to_char(like_reg_date,'MM') like_reg_date , count(*) count FROM u_like WHERE pmenu_num != 0 AND pmenu_num is not null AND to_char(like_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12) GROUP BY to_char(like_reg_date,'MM') ORDER BY like_reg_date ASC")
	public List<AdminPcafeLikeCommand> pCafeLikeMenuMonthCount();
	@Select("SELECT to_char(bookmark_reg_date,'YYYY/MM/DD') bookmark_reg_date , count(*) count from bookmark WHERE pcafe_num != 0 AND pcafe_num is not null AND to_char(bookmark_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD')  GROUP BY to_char(bookmark_reg_date,'YYYY/MM/DD') ORDER BY bookmark_reg_date ASC")
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkDayCount();
	@Select("SELECT to_char(bookmark_reg_date,'MM') bookmark_reg_date , count(*) count FROM bookmark WHERE pcafe_num != 0 AND pcafe_num is not null AND to_char(bookmark_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12)  GROUP BY to_char(bookmark_reg_date,'MM') ORDER BY bookmark_reg_date ASC")
	public List<AdminPcafeBookmarkCommand> pcafeBookmarkMonthCount();
	@Select("SELECT to_char(d_reg_date,'MMDD') reg_date,count(*) count FROM declared WHERE d_target_path=1 and to_char(d_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(d_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminPcafeDeClaredCommand> pcafeDeClaredCount();
	@Select("SELECT count(*) count from declared where d_target_path = 1")
	public int pDeClaredCountToTal();
	
	
	
	
}

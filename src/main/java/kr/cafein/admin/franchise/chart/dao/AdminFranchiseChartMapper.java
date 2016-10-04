package kr.cafein.admin.franchise.chart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.franchise.chart.domain.AdminFranchiseBookmarkCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseChartCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseDeClaredCommand;
import kr.cafein.admin.franchise.chart.domain.AdminFranchiseLikeCommand;

@Repository
public interface AdminFranchiseChartMapper {

	
	@Select("SELECT to_char(ucnt_log_reg_date,'MMDD') reg_date,sum(ucnt_log_franchise) ucnt_log_franchise FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminFranchiseChartCommand> pageViewCount();
	@Select("SELECT sum(ucnt_log_franchise) count FROM user_count_log")
	public int franchisePageViewTotal();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE franchise_num != 0 AND franchise_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminFranchiseLikeCommand> franchiseLikeDayCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE fmenu_num != 0 AND fmenu_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminFranchiseLikeCommand> franchiseMenuLikeDayCount();
	@Select("SELECT to_char(like_reg_date,'MM') like_reg_date , count(*) count FROM u_like WHERE franchise_num != 0 AND franchise_num is not null AND to_char(like_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12) GROUP BY to_char(like_reg_date,'MM') ORDER BY like_reg_date ASC")
	public List<AdminFranchiseLikeCommand> franchiseLikeMonthCount();
	@Select("SELECT to_char(like_reg_date,'MM') like_reg_date , count(*) count FROM u_like WHERE fmenu_num != 0 AND fmenu_num is not null AND to_char(like_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12) GROUP BY to_char(like_reg_date,'MM') ORDER BY like_reg_date ASC")
	public List<AdminFranchiseLikeCommand> franchiseLikeMenuMonthCount();
	@Select("select to_char(bookmark_reg_date,'YYYY/MM/DD') bookmark_reg_date , count(*) count from bookmark WHERE franchise_num != 0 AND franchise_num is not null AND to_char(bookmark_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD')  GROUP BY to_char(bookmark_reg_date,'YYYY/MM/DD') ORDER BY bookmark_reg_date ASC")
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkDayCount();
	@Select("SELECT to_char(bookmark_reg_date,'MM') bookmark_reg_date , count(*) count FROM bookmark WHERE franchise_num != 0 AND franchise_num is not null AND to_char(bookmark_reg_date,'YYYYMM') BETWEEN to_char(trunc(sysdate,'year'),'YYYYMM') AND concat(to_char(trunc(sysdate,'year'),'YYYY'),12)  GROUP BY to_char(bookmark_reg_date,'MM') ORDER BY bookmark_reg_date ASC")
	public List<AdminFranchiseBookmarkCommand> franchiseBookmarkMonthCount();
	@Select("SELECT to_char(d_reg_date,'MMDD') reg_date,count(*) count FROM declared WHERE d_target_path=0 and to_char(d_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-7,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(d_reg_date,'MMDD') ORDER BY reg_date ASC")
	public List<AdminFranchiseDeClaredCommand> franchiseDeClaredCount();
	@Select("select count(*) count from declared where d_target_path = 0")
	public int fDeClaredCountToTal();
}




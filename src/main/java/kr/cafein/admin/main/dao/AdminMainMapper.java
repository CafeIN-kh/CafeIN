package kr.cafein.admin.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.main.domain.AdminMainCountCommand;
import kr.cafein.admin.main.domain.AdminMainCustomizingCommand;
import kr.cafein.admin.main.domain.AdminMainFranchiseCommand;
import kr.cafein.admin.main.domain.AdminMainNoticeCommand;
import kr.cafein.admin.main.domain.AdminMainPrivateCommand;

@Repository
public interface AdminMainMapper {

	@Select("SELECT to_char(ucnt_log_reg_date,'DD') reg_date,sum(ucnt_log_franchise) ucnt_log_franchise FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'DD') ORDER BY to_char(ucnt_log_reg_date,'DD') ASC")
	public List<AdminMainFranchiseCommand> franchiseTotalCount();
	@Select("SELECT to_char(ucnt_log_reg_date,'DD') reg_date,sum(ucnt_log_private) ucnt_log_private FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'DD') ORDER BY to_char(ucnt_log_reg_date,'DD') ASC")
	public List<AdminMainPrivateCommand> privateTotalCount();
	@Select("SELECT to_char(ucnt_log_reg_date,'DD') reg_date,sum(ucnt_log_custom) ucnt_log_custom FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(ucnt_log_reg_date,'DD') ORDER BY to_char(ucnt_log_reg_date,'DD') ASC")
	public List<AdminMainCustomizingCommand> customTotalCount();
	@Select("SELECT sum(ucnt_total) ucnt_total FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYMMDD') >= to_char(sysdate-20,'YYMMDD')")
	public int pageTotal();
	@Select("SELECT sum(ucnt_log_franchise) ucnt_log_franchise FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYMMDD') >= to_char(sysdate-20,'YYMMDD')")
	public int franchiseTotal();
	@Select("SELECT sum(ucnt_log_private) ucnt_log_private FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYMMDD') >= to_char(sysdate-20,'YYMMDD')")
	public int privateTotal();
	@Select("SELECT sum(ucnt_log_custom) ucnt_log_custom FROM user_count_log WHERE to_char(ucnt_log_reg_date,'YYMMDD') >= to_char(sysdate-20,'YYMMDD')")
	public int customizingTotal();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE franchise_num != 0 AND franchise_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminMainCountCommand> franchiseCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE pcafe_num != 0 AND pcafe_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminMainCountCommand> privateCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE custom_num != 0 AND custom_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminMainCountCommand> customCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE pmenu_num != 0 AND pmenu_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminMainCountCommand> pmenuCount();
	@Select("SELECT to_char(like_reg_date,'MMDD') like_reg_date , count(*) count FROM u_like WHERE fmenu_num != 0 AND fmenu_num is not null AND to_char(like_reg_date,'YYYYMMDD') BETWEEN to_char(sysdate-20,'YYYYMMDD') AND to_char(sysdate,'YYYYMMDD') GROUP BY to_char(like_reg_date,'MMDD') ORDER BY like_reg_date ASC")
	public List<AdminMainCountCommand> fmenuCount();
	@Select("SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM admin_notice ORDER BY admin_notice_num DESC)a) WHERE rnum <= 5")
	public List<AdminMainNoticeCommand> selectNotice();
}


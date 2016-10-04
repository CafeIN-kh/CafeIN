package kr.cafein.admin.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.event.domain.AdminEventLogCommand;
import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;

@Repository
public interface AdminNoticeMapper {
	
	//public List<AdminNoticeCommand> list(Map<String, Object> map);
	
	@Select("select * from notice")
	public List<AdminNoticeCommand> getNoticeList();
	
	@Update("update notice set notice_title=#{notice_title}, notice_content=#{notice_content}, notice_img=#{notice_img} where notice_num=#{notice_num}")
	public void updateNotice(AdminNoticeCommand noticeCommand);
	
	@Select("select * from notice where notice_num=#{seq}")
	public AdminNoticeCommand selectNotice(Integer seq);
	
	@Delete ("delete from notice where notice_num=#{seq}")
	public void delete(Integer seq);
	
	@Insert ("insert into notice (notice_num, notice_title, notice_content, notice_reg_date, notice_img, notice_uid) values (notice_seq.nextval, #{notice_title}, #{notice_content}, sysdate, #{notice_img,jdbcType=VARCHAR}, #{notice_uid})")
	public void insertNotice(AdminNoticeCommand noticeCommand);
	
	@Select("select * from notice_log")
	public List<AdminNoticeLogCommand> getAdminNotice_LogList();
	
	@Insert("insert into notice_log (n_log_num, n_log_uid, n_log_reg_date, n_log_change, n_log_message) values (n_log_seq.nextval, #{n_log_uid}, sysdate, #{n_log_change}, #{n_log_message})")
	public void insertAdminNotice_Log(AdminNoticeLogCommand adminNoticeLogCommand);
	
}

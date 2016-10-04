package kr.cafein.admin.admin_notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.event.domain.AdminEventCommand;

@Repository
public interface Admin_NoticeMapper {
	
	@Select("select * from admin_notice")
	public List<Admin_NoticeCommand> getAdmin_NoticeList();
	
	@Delete("delete from admin_notice where admin_notice_num=#{admin_notice_num}")
	public void deleteAdmin_Notice(Integer admin_notice_num);
	
	@Update("update admin_notice set admin_notice_title=#{admin_notice_title}, admin_notice_content=#{admin_notice_content}, admin_notice_img=#{admin_notice_img} where admin_notice_num=#{admin_notice_num}")
	public void updateAdmin_Notice(Admin_NoticeCommand admin_noticeCommand);
	
	@Insert("insert into admin_notice (admin_notice_num, admin_notice_title, admin_notice_content, admin_notice_reg_date, admin_notice_img,u_uid) values (admin_notice_seq.nextval,#{admin_notice_title}, #{admin_notice_content}, sysdate, #{admin_notice_img,jdbcType=VARCHAR}, #{u_uid})")
	public void insertAdmin_Notice(Admin_NoticeCommand admin_noticeCommand);
	
	@Select("select * from admin_notice where admin_notice_num=#{admin_notice_num}")
	public Admin_NoticeCommand selectAdmin_Notice(Integer admin_notice_num);
	
	@Select("select * from admin_notice_log")
	public List<Admin_Notice_LogCommand> getAdmin_Notice_LogList();
	
	@Insert("insert into admin_notice_log (an_log_num, an_log_uid, an_log_reg_date, an_log_change, an_log_message) values (an_log_seq.nextval, #{an_log_uid}, sysdate, #{an_log_change}, #{an_log_message})")
	public void inserAdmin_Notice_Log(Admin_Notice_LogCommand admin_notice_logCommand);

	

}

package kr.cafein.admin.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;

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
	
	@Insert ("insert into notice (notice_num, notice_title, notice_content, notice_reg_date, notice_img) values (notice_seq.nextval, #{notice_title}, #{notice_content}, sysdate, #{notice_img,jdbcType=VARCHAR})")
	public void insertNotice(AdminNoticeCommand noticeCommand);
	
	
}
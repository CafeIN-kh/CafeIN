package kr.cafein.admin.event.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.domain.AdminEventLogCommand;

@Repository
public interface AdminEventMapper {
	
	//public List<AdminEventCommand> list(Map<String, Object> map);
	
	@Select("select * from event")
	public List<AdminEventCommand> getEventList();

	
	@Update("update event set event_title=#{event_title}, event_content=#{event_content}, event_img=#{event_img} where event_num=#{event_num}")
	public void updateEvent(AdminEventCommand eventCommand);
	
	@Select("select * from event where event_num=#{seq}")
	public AdminEventCommand selectEvent(Integer seq);
	
	@Delete ("delete from event where event_num=#{seq}")
	public void deletEvente(Integer seq);
	
	@Insert ("insert into event (event_num, event_title, event_content, event_reg_date, event_img,event_uid) values (event_seq.nextval, #{event_title}, #{event_content}, sysdate, #{event_img,jdbcType=VARCHAR},#{event_uid})")
	public void insertEvent(AdminEventCommand eventCommand);
	
	@Select("select * from event_log")
	public List<AdminEventLogCommand> getAdminEvent_LogList();
	
	@Insert("insert into event_log (e_log_num, e_log_uid, e_log_reg_date, e_log_change, e_log_message) values (e_log_seq.nextval, #{e_log_uid}, sysdate, #{e_log_change}, #{e_log_message})")
	public void insertAdminEvent_Log(AdminEventLogCommand adminevnetLogCommand);
	
	
}

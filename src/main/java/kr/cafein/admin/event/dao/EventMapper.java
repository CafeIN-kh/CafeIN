package kr.cafein.admin.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.event.domain.EventCommand;

@Repository
public interface EventMapper {
	
	public List<EventCommand> list(Map<String, Object> map);
	
	@Select("select * from event")
	public List<EventCommand> getEventList();

	
	@Update("update event set event_title=#{event_title}, event_content=#{event_content}, event_img=#{event_img} where event_num=#{event_num}")
	public void updateEvent(EventCommand eventCommand);
	
	@Select("select * from event where event_num=#{seq}")
	public EventCommand selectEvent(Integer seq);
	
	@Delete ("delete from event where event_num=#{seq}")
	public void deletEvente(Integer seq);
	
	@Insert ("insert into event (event_num, event_title, event_content, event_reg_date, event_img) values (event_seq.nextval, #{event_title}, #{event_content}, sysdate, #{event_img,jdbcType=VARCHAR})")
	public void insertEvent(EventCommand eventCommand);
	
	
}

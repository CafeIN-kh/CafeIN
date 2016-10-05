package kr.cafein.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.notice.domain.EventCommand;
import kr.cafein.notice.domain.NoticeCommand;

@Repository
public interface NoticeMapper {
	//notice
	public List<NoticeCommand> noticeList(Map<String, Object> map);
	@Select("SELECT count(*) FROM notice")
	public int getRowCount(Map<String, Object> map);
	@Select("SELECT notice_num, notice_title, notice_hit FROM notice WHERE notice_num = #{seq}")
	public NoticeCommand selectNoticeTitle(Integer seq);
	@Select("SELECT notice_content, notice_reg_date FROM notice WHERE notice_num = #{seq}")
	public NoticeCommand selectNoticeContent(Integer seq);
	@Update("UPDATE notice SET notice_hit = notice_hit+1 WHERE notice_num = #{seq}")
	public void updateHit(Integer seq);
	
	//event
	public List<EventCommand> eventList(Map<String, Object> map);
	@Select("SELECT count(*) FROM event")
	public int getRowCountEvent(Map<String, Object> map);
	@Select("SELECT event_num, event_title, event_hit FROM event WHERE event_num = #{seq}")
	public EventCommand selectEventTitle(Integer seq);
	@Select("SELECT event_content, event_reg_date FROM event WHERE event_num = #{seq}")
	public EventCommand selectEventContent(Integer seq);
	@Update("UPDATE event SET event_hit = event_hit+1 WHERE event_num = #{seq}")
	public void updateEventHit(Integer seq);
}

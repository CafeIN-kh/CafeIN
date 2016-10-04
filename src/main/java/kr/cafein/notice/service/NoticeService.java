package kr.cafein.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.notice.domain.EventCommand;
import kr.cafein.notice.domain.NoticeCommand;

@Transactional
public interface NoticeService {
	//notice
	@Transactional(readOnly=true)  
	public List<NoticeCommand> noticeList(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	@Transactional(readOnly=true)
	public NoticeCommand selectNoticeTitle(Integer seq);
	@Transactional(readOnly=true)
	public NoticeCommand selectNoticeContent(Integer seq);
	public void updateHit(Integer seq);
	
	//event
	@Transactional(readOnly=true)
	public List<EventCommand> eventList(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountEvent(Map<String, Object> map);
	@Transactional(readOnly=true)
	public EventCommand selectEventTitle(Integer seq);
	@Transactional(readOnly=true)
	public EventCommand selectEventContent(Integer seq);
	public void updateEventHit(Integer seq);
}

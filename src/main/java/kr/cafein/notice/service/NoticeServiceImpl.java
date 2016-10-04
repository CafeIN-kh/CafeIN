package kr.cafein.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.notice.dao.NoticeMapper;
import kr.cafein.notice.domain.EventCommand;
import kr.cafein.notice.domain.NoticeCommand;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeCommand> noticeList(Map<String, Object> map) {
		return noticeMapper.noticeList(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return noticeMapper.getRowCount(map);
	}

	@Override
	public NoticeCommand selectNoticeTitle(Integer seq) {
		return noticeMapper.selectNoticeTitle(seq);
	}

	@Override
	public NoticeCommand selectNoticeContent(Integer seq) {
		return noticeMapper.selectNoticeContent(seq);
	}

	@Override
	public void updateHit(Integer seq) {
		noticeMapper.updateHit(seq);
	}

	@Override
	public List<EventCommand> eventList(Map<String, Object> map) {
		return noticeMapper.eventList(map);
	}

	@Override
	public int getRowCountEvent(Map<String, Object> map) {
		return noticeMapper.getRowCountEvent(map);
	}

	@Override
	public EventCommand selectEventTitle(Integer seq) {
		return noticeMapper.selectEventTitle(seq);
	}

	@Override
	public EventCommand selectEventContent(Integer seq) {
		return noticeMapper.selectEventContent(seq);
	}

	@Override
	public void updateEventHit(Integer seq) {
		noticeMapper.updateEventHit(seq);
	}

}

package kr.cafein.admin.notice.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.notice.domain.NoticeCommand;

@Transactional
public interface NoticeService {
	public List<NoticeCommand> getNoticeList();
	public void updateNotice(NoticeCommand noticeCommand);
	public NoticeCommand selectNotice(Integer seq);
	public void delete(Integer seq);
	public void insertNotice(NoticeCommand noticeCommand);

}

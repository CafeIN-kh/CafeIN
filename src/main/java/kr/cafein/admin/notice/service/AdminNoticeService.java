package kr.cafein.admin.notice.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;

@Transactional
public interface AdminNoticeService {
	public List<AdminNoticeCommand> getNoticeList();
	public void updateNotice(AdminNoticeCommand noticeCommand);
	public AdminNoticeCommand selectNotice(Integer seq);
	public void delete(Integer seq);
	public void insertNotice(AdminNoticeCommand noticeCommand);

}

package kr.cafein.admin.notice.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.notice.domain.AdminNoticeCommand;
import kr.cafein.admin.notice.domain.AdminNoticeLogCommand;

@Transactional
public interface AdminNoticeService {
	public List<AdminNoticeCommand> getNoticeList();
	public void updateNotice(AdminNoticeCommand noticeCommand);
	public AdminNoticeCommand selectNotice(Integer seq);
	public void delete(Integer seq);
	public void insertNotice(AdminNoticeCommand noticeCommand);
	
	public List<AdminNoticeLogCommand> getAdminNotice_LogList();
	public void insertAdminNotice_Log(AdminNoticeLogCommand adminNoticeLogCommand);

}

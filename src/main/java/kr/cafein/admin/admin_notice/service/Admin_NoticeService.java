package kr.cafein.admin.admin_notice.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.event.domain.AdminEventCommand;

@Repository
public interface Admin_NoticeService {
	
	public List<Admin_NoticeCommand> getAdmin_NoticeList();
	public void deleteAdmin_Notice(Integer admin_notice_num);
	public void updateAdmin_Notice(Admin_NoticeCommand admin_noticeCommand);
	public void insertAdmin_Notice(Admin_NoticeCommand admin_noticeCommand);
	public Admin_NoticeCommand selectAdmin_Notice(Integer admin_notice_num);
	public void inserAdmin_Notice_Log(Admin_Notice_LogCommand admin_notice_logCommand);
	public List<Admin_Notice_LogCommand> getAdmin_Notice_LogList();

}
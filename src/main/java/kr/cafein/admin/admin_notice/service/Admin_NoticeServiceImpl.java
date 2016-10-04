package kr.cafein.admin.admin_notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.admin_notice.dao.Admin_NoticeMapper;
import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;
import kr.cafein.admin.admin_notice.domain.Admin_Notice_LogCommand;
import kr.cafein.admin.event.domain.AdminEventCommand;

@Service("admin_NoticeService")
public class Admin_NoticeServiceImpl implements Admin_NoticeService{
	
	@Resource
	private Admin_NoticeMapper admin_NoticeMapper;

	@Override
	public List<Admin_NoticeCommand> getAdmin_NoticeList() {
		return admin_NoticeMapper.getAdmin_NoticeList();
	}

	@Override
	public void deleteAdmin_Notice(Integer admin_notice_num) {
		admin_NoticeMapper.deleteAdmin_Notice(admin_notice_num);
		
	}

	@Override
	public void updateAdmin_Notice(Admin_NoticeCommand admin_noticeCommand) {
		admin_NoticeMapper.updateAdmin_Notice(admin_noticeCommand);
		
	}

	@Override
	public void insertAdmin_Notice(Admin_NoticeCommand admin_noticeCommand) {
		admin_NoticeMapper.insertAdmin_Notice(admin_noticeCommand);
		
	}

	@Override
	public Admin_NoticeCommand selectAdmin_Notice(Integer admin_notice_num) {
		return admin_NoticeMapper.selectAdmin_Notice(admin_notice_num);
	}

	@Override
	public void inserAdmin_Notice_Log(Admin_Notice_LogCommand admin_notice_logCommand) {
		admin_NoticeMapper.inserAdmin_Notice_Log(admin_notice_logCommand);
		
	}

	@Override
	public List<Admin_Notice_LogCommand> getAdmin_Notice_LogList() {
		return admin_NoticeMapper.getAdmin_Notice_LogList();
	}

	
	

}

package kr.cafein.admin.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.notice.dao.AdminNoticeMapper;
import kr.cafein.admin.notice.domain.AdminNoticeCommand;

@Service("adminNoticeService")
public class AdminNoticeServiceImpl implements AdminNoticeService{
	
	@Resource
	private AdminNoticeMapper adminNoticeMapper;

	@Override
	public List<AdminNoticeCommand> getNoticeList() {
		return adminNoticeMapper.getNoticeList();
	}

	@Override
	public void updateNotice(AdminNoticeCommand noticeCommand) {
		adminNoticeMapper.updateNotice(noticeCommand);
	}

	@Override
	public AdminNoticeCommand selectNotice(Integer seq) {
		return adminNoticeMapper.selectNotice(seq);
	}

	@Override
	public void delete(Integer seq) {
		adminNoticeMapper.delete(seq);
		
	}

	@Override
	public void insertNotice(AdminNoticeCommand noticeCommand) {
		adminNoticeMapper.insertNotice(noticeCommand);
		
	}



	


}

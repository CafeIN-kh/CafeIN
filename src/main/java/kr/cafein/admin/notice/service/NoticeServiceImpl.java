package kr.cafein.admin.notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.notice.dao.NoticeMapper;
import kr.cafein.admin.notice.domain.NoticeCommand;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeCommand> getNoticeList() {
		return noticeMapper.getNoticeList();
	}

	@Override
	public void updateNotice(NoticeCommand noticeCommand) {
		noticeMapper.updateNotice(noticeCommand);
	}

	@Override
	public NoticeCommand selectNotice(Integer seq) {
		return noticeMapper.selectNotice(seq);
	}

	@Override
	public void delete(Integer seq) {
		noticeMapper.delete(seq);
		
	}

	@Override
	public void insertNotice(NoticeCommand noticeCommand) {
		noticeMapper.insertNotice(noticeCommand);
		
	}



	


}

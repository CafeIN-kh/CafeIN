package kr.cafein.admin.admin_notice.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.admin_notice.dao.Admin_NoticeMapper;
import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;

@Service("admin_NoticeService")
public class Admin_NoticeServiceImpl implements Admin_NoticeService{
	
	@Resource
	private Admin_NoticeMapper admin_NoticeMapper;

	@Override
	public List<Admin_NoticeCommand> getAdmin_NoticeList() {
		return admin_NoticeMapper.getAdmin_NoticeList();
	}
	

}

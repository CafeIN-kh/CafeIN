package kr.cafein.admin.admin_notice.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;

@Repository
public interface Admin_NoticeService {
	
	public List<Admin_NoticeCommand> getAdmin_NoticeList();

}
package kr.cafein.admin.admin_notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.admin_notice.domain.Admin_NoticeCommand;

@Repository
public interface Admin_NoticeMapper {
	
	@Select("select * from admin_notice")
	public List<Admin_NoticeCommand> getAdmin_NoticeList();

}

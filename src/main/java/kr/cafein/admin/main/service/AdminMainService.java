package kr.cafein.admin.main.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.main.domain.AdminMainCountCommand;
import kr.cafein.admin.main.domain.AdminMainCustomizingCommand;
import kr.cafein.admin.main.domain.AdminMainFranchiseCommand;
import kr.cafein.admin.main.domain.AdminMainNoticeCommand;
import kr.cafein.admin.main.domain.AdminMainPrivateCommand;

@Transactional
public interface AdminMainService {
	public List<AdminMainFranchiseCommand> franchiseTotalCount();
	public List<AdminMainPrivateCommand> privateTotalCount();
	public List<AdminMainCustomizingCommand> customTotalCount();
	public int pageTotal();
	public int franchiseTotal();
	public int privateTotal();
	public int customizingTotal();
	public List<AdminMainCountCommand> franchiseCount();
	public List<AdminMainCountCommand> privateCount();
	public List<AdminMainCountCommand> customCount();
	public List<AdminMainCountCommand> pmenuCount();
	public List<AdminMainCountCommand> fmenuCount();
	public List<AdminMainNoticeCommand> selectNotice();
}

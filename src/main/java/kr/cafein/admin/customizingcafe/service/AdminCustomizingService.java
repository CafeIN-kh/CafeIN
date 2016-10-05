package kr.cafein.admin.customizingcafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingListCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Repository
public interface AdminCustomizingService {
	
	public int getRowCount(int custom_num);
	public List<AdminCustomizingCommand> selectCustomizing();
	public AdminCustomizingCommand getCustomizing(Integer custom_num);
	public List<AdminCustomizingDetailCommand> searchList(Map<String, Object> map);
	public List<AdminCustomizingCommand> getCustomizingList(Integer franchise_num);
	public void update(AdminCustomizingCommand customizing);
	public void delete(Integer custom_num);
	public List<AdminCustomizingCommand> getCustomizingCafeDetailList(Integer custom_num);
	public List<AdminCustomizingCommand> getCustomizingCafeMenuList(Integer u_uid);
	public List<LikeCommand> getLikeUser(Integer custom_num);
	public int selectBookmarkCount(BookmarkCommand bookmark);
	public List<AdminCustomizingDetailCafeNameCommand> selectCafeMenu_Admin();

	public String selectCafeName_Admin(Integer franchise_num);
	public int selectFranchise_num(Integer custom_num);
	public List<AdminCustomizingListCommand> selectCafeJoin();
	public String selectUid(Integer custom_num);
	
	public List<AdminCustomizingReplyCommand> selectReplyc(Map<String, Object> map);
	public int selectCustom_num(int creply_num);
	public void deleteCutomizingReplyAdmin(int creply_num);
	
	public int getRowCount_admin_customizingReply(int custom_num);
	public void deleteCutomizingCafeAdmin(int custom_num);
	public MemberCommand selectEmail(String u_uid);
	public void insertAdminCustomLog(UserMenuLogCommand userMenuLogCommand);

}

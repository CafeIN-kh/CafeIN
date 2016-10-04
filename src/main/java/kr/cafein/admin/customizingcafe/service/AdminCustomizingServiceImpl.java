package kr.cafein.admin.customizingcafe.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.customizingcafe.dao.AdminCustomizingMapper;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingListCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;
import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;

@Service("admincustomizingService")
public class AdminCustomizingServiceImpl implements AdminCustomizingService{
	
	@Resource
	private AdminCustomizingMapper adminCustomizingMapper;

	@Override
	public AdminCustomizingCommand getCustomizing(Integer custom_num) {
		return adminCustomizingMapper.getCustomizing(custom_num);
	}

	@Override
	public List<AdminCustomizingDetailCommand> searchList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.searchList(map);
	}

	
	
	@Override
	public List<AdminCustomizingCommand> getCustomizingList(Integer franchise_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.getCustomizingList(franchise_num);
	}

	@Override
	public void update(AdminCustomizingCommand customizing) {
		// TODO Auto-generated method stub
		adminCustomizingMapper.update(customizing);
	}

	@Override
	public void delete(Integer custom_num) {
		// TODO Auto-generated method stub
		adminCustomizingMapper.delete(custom_num);
		
	}

	@Override
	public List<AdminCustomizingCommand> getCustomizingCafeDetailList(Integer custom_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminCustomizingCommand> getCustomizingCafeMenuList(Integer u_uid) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.getCustomizingCafeMenuList(u_uid);
	}

	@Override
	public List<LikeCommand> getLikeUser(Integer custom_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.getLikeUser(custom_num);
	}

	@Override
	public int selectBookmarkCount(BookmarkCommand bookmark) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectBookmarkCount(bookmark);
	}

	@Override
	public List<AdminCustomizingCommand> selectCustomizing() {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectCustomizing();
	}

	@Override
	public int getRowCount(int custom_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.getRowCount(custom_num);
	}

	@Override
	public List<AdminCustomizingDetailCafeNameCommand> selectCafeMenu_Admin() {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectCafeMenu_Admin();
	}

	@Override
	public String selectCafeName_Admin(Integer franchise_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectCafeName_Admin(franchise_num);
	}

	@Override
	public int selectFranchise_num(Integer custom_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectFranchise_num(custom_num);
	}

	@Override
	public List<AdminCustomizingListCommand> selectCafeJoin() {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectCafeJoin();
	}

	@Override
	public String selectUid(Integer custom_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectUid(custom_num);
	}

	@Override
	public List<AdminCustomizingReplyCommand> selectReply(Integer custom_num) {
		// TODO Auto-generated method stub
		return adminCustomizingMapper.selectReply(custom_num);

	}
	


}

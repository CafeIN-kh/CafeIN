package kr.cafein.admin.customizingcafe.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.admin.customizingcafe.dao.AdminCustomizingMapper;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;
import kr.cafein.admin.privatecafe.dao.PrivateMapper;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Service("admincustomizingService")
public class AdminCustomizingServiceImpl implements AdminCustomizingService{
	
	@Resource
	private AdminCustomizingMapper adminCustomizingMapper;

	@Override
	public AdminCustomizingCommand selectCustomizing(Integer custom_num) {
		return adminCustomizingMapper.selectCustomizing(custom_num);
	}

	@Override
	public List<AdminCustomizingCommand> searchList(Map<String, Object> map) {
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

	
	


}

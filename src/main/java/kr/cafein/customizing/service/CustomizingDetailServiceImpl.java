package kr.cafein.customizing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.customizing.dao.CustomizingDetailMapper;
import kr.cafein.customizing.domain.CustomizingDetailBookmarkCommand;
import kr.cafein.customizing.domain.CustomizingDetailCafeNameCommand;
import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.domain.CustomizingDetailULikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Service("customizingDetailService")
public class CustomizingDetailServiceImpl implements CustomizingDetailService{

	@Resource(name="customizingDetailMapper")
	private CustomizingDetailMapper customMapper;
	
	@Override
	public List<CustomizingDetailCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customMapper.list(map);
	}
	@Override
	public CustomizingDetailCommand selectCustomMenu(Map<String, Object> map) {
		return customMapper.selectCustomMenu(map);
	}

	@Override
	public void updateHit(Integer custom_num) {
		customMapper.updateHit(custom_num);
	}

	@Override
	public void updateCustomMenu(CustomizingDetailCommand customizingDetailCommand) {
		// TODO Auto-generated method stub
		customMapper.updateCustomMenu(customizingDetailCommand);
	}

	@Override
	public CustomizingDetailCommand selectImg(Integer custom_num) {
		// TODO Auto-generated method stub
		return customMapper.selectImg(custom_num);
	}

	@Override
	public void insertBookmark(CustomizingDetailBookmarkCommand bookmark) {
		// TODO Auto-generated method stub
		customMapper.insertBookmark(bookmark);
	}

	@Override
	public int selectUserBookmark(CustomizingDetailBookmarkCommand bookmark) {
		// TODO Auto-generated method stub
		return customMapper.selectUserBookmark(bookmark);
	}

	@Override
	public void deleteBookmark(CustomizingDetailBookmarkCommand bookmark) {
		// TODO Auto-generated method stub
		customMapper.deleteBookmark(bookmark);
	}

	@Override
	public int selectULike(CustomizingDetailULikeCommand likeCommand) {
		// TODO Auto-generated method stub
		return customMapper.selectULike(likeCommand);
	}

	@Override
	public void insertLike(CustomizingDetailULikeCommand likeCommand) {
		// TODO Auto-generated method stub
		customMapper.insertLike(likeCommand);
	}

	@Override
	public void deleteLike(CustomizingDetailULikeCommand likeCommand) {
		// TODO Auto-generated method stub
		customMapper.deleteLike(likeCommand);
	}

	@Override
	public int selectLikeCount(CustomizingDetailULikeCommand likeCommand) {
		// TODO Auto-generated method stub
		return customMapper.selectLikeCount(likeCommand);
	}

	@Override
	public int selectFirstLikeCount(Integer custom_num) {
		// TODO Auto-generated method stub
		return customMapper.selectFirstLikeCount(custom_num);
	}

	@Override
	public int selectFirstBookmarkCount(Integer custom_num) {
		// TODO Auto-generated method stub
		return customMapper.selectFirstBookmarkCount(custom_num);
	}

	@Override
	public int selectBookmarkCount(CustomizingDetailBookmarkCommand bookmark) {
		// TODO Auto-generated method stub
		return customMapper.selectBookmarkCount(bookmark);
	}

	@Override
	public String selectCafeName(Integer custom_num) {
		// TODO Auto-generated method stub
		return customMapper.selectCafeName(custom_num);
	}

	@Override
	public void insertReply(CustomizingDetailReplyCommand reply) {
		// TODO Auto-generated method stub
		customMapper.insertReply(reply);
	}

	@Override
	public List<CustomizingDetailReplyCommand> customReplyList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customMapper.customReplyList(map);
	}
	@Override
	public int getReplyRowCount(Integer custom_num) {
		// TODO Auto-generated method stub
		return customMapper.getReplyRowCount(custom_num);
	}
	@Override
	public List<CustomizingDetailCafeNameCommand> selectCafeMenu() {
		// TODO Auto-generated method stub
		return customMapper.selectCafeMenu();
	}
	
	//¥Ò±€ ªË¡¶
	@Override
	public void customizingReplyDelete(Integer creply_num) {
		customMapper.customizingReplyDelete(creply_num);
	}
	
	//¥Ò±€ Ω≈∞Ì
	@Override
	public CustomizingDetailReplyCommand selectDeclaredCustomizingReply(Integer creply_num) {
		return customMapper.selectDeclaredCustomizingReply(creply_num);
	}
	@Override
	public MemberCommand selectDeclaredMember(String u_uid) {
		return customMapper.selectDeclaredMember(u_uid);
	}
	@Override
	public void insertDeclaredReply(UserDeclaredCommand declared) {
		customMapper.insertDeclaredReply(declared);
	}
	@Override
	public void insertCustomUserLog(UserMenuLogCommand userMenuLog) {
		customMapper.insertCustomUserLog(userMenuLog);
	}
	@Override
	public void insertCustomUserCountLog() {
		// TODO Auto-generated method stub
		customMapper.insertCustomUserCountLog();
	}
	@Override
	public void updateCustomUserCountLog() {
		// TODO Auto-generated method stub
		customMapper.updateCustomUserCountLog();
	}
	@Override
	public UserCountLogCommand selectCustomUserCountLogByDate() {
		// TODO Auto-generated method stub
		return customMapper.selectCustomUserCountLogByDate();
	}

	
}

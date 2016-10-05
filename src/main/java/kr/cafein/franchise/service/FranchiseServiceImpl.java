package kr.cafein.franchise.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.franchise.dao.FranchiseMapper;
import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
/*import kr.cafein.franchise.domain.FranchiseBookmarkCommand;*/
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseDeclaredCommand;
import kr.cafein.franchise.domain.FC_FranchiseLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;


@Service("franchiseService")
public class FranchiseServiceImpl implements FranchiseService{

	@Resource
	private FranchiseMapper franchiseMapper;
	
	@Override
	public List<FC_FranchiseCommand> list() {
		return franchiseMapper.list();
	}
	@Override
	public FC_FranchiseCommand selectFranchise(int franchise_num) {
		return franchiseMapper.selectFranchise(franchise_num);
	}

	@Override
	public List<FC_FranchiseMenuCommand> menuList(Map<String, Object> map) {
		return franchiseMapper.menuList(map);
	}

	@Override
	public void updateHit(int franchise_num) {
		franchiseMapper.updateHit(franchise_num);
	}

	@Override
	public int getRowCount(int franchise_num) {
		return franchiseMapper.getRowCount(franchise_num);
	}

	@Override
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map) {
		return franchiseMapper.listReply(map);
	}

	@Override
	public void insertReply(FC_FranchiseReplyCommand franchiseReply) {
		franchiseMapper.insertReply(franchiseReply);
	}

	@Override
	public FC_FranchiseMenuCommand selectMenu(int fmenu_num) {
		return franchiseMapper.selectMenu(fmenu_num);
	}

	@Override
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num) {
		return franchiseMapper.menuListPaging(franchise_num);
	}

	@Override
	public void insertBookmark(FC_FranchiseBookmarkCommand bookmark) {
		franchiseMapper.insertBookmark(bookmark);
	}

	@Override
	public int selectBookmarkID(FC_FranchiseBookmarkCommand bookmark) {
		return franchiseMapper.selectBookmarkID(bookmark);
	}

	@Override
	public void deleteBookmark(FC_FranchiseBookmarkCommand bookmark) {
		franchiseMapper.deleteBookmark(bookmark);
	}

	@Override
	public int getReplyRowCount(int franchise_num) {
		return franchiseMapper.getReplyRowCount(franchise_num);
	}

	@Override
	public void deleteReply(int freply_num) {
		franchiseMapper.deleteReply(freply_num);
	}
	@Override
	public void insertFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand) {
		franchiseMapper.insertFranchiseLike(franchiseLikeCommand);
	}
	@Override
	public int selectFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand) {
		return franchiseMapper.selectFranchiseLike(franchiseLikeCommand);
	}
	@Override
	public int totalFranchiseLike(int franchise_num) {
		return franchiseMapper.totalFranchiseLike(franchise_num);
	}
	@Override
	public void deleteFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand) {
		franchiseMapper.deleteFranchiseLike(franchiseLikeCommand);
	}
	@Override
	public void insertMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand) {
		franchiseMapper.insertMenuLike(franchiseMenuLikeCommand);		
	}
	@Override
	public void deleteMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand) {
		franchiseMapper.deleteMenuLike(franchiseMenuLikeCommand);
	}
	@Override
	public int totalMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand) {
		return franchiseMapper.totalMenuLike(franchiseMenuLikeCommand);
	}
	@Override
	public int selectMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand) {
		return franchiseMapper.selectMenuLike(franchiseMenuLikeCommand);
	}
	@Override
	public FC_FranchiseReplyCommand selectReply(int freply_num) {
		return franchiseMapper.selectReply(freply_num);
	}
	@Override
	public MemberCommand selectDeclaredMember(String u_uid_declared) {
		return franchiseMapper.selectDeclaredMember(u_uid_declared);
	}
	@Override
	public void insertDeclared(FC_FranchiseDeclaredCommand declaredCommand) {
		franchiseMapper.insertDeclared(declaredCommand);
	}
	@Override
	public void insertFCafeUserCountLog() {
		franchiseMapper.insertFCafeUserCountLog();
	}
	@Override
	public void updateFCafeUserCountLog() {
		franchiseMapper.updateFCafeUserCountLog();
	}
	@Override
	public UserCountLogCommand selectFCafeUserCountLogByDate() {
		return franchiseMapper.selectFCafeUserCountLogByDate();
	}
	@Override
	public void insertUserLog_FC(UserMenuLogCommand userMenuLog) {
		franchiseMapper.insertUserLog_FC(userMenuLog);
	}
}
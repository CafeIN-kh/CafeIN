package kr.cafein.franchise.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseDeclaredCommand;
import kr.cafein.franchise.domain.FC_FranchiseLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;

@Repository
public interface FranchiseService {
	public List<FC_FranchiseCommand> list();
	public int getRowCount(int franchise_num);
	public List<FC_FranchiseMenuCommand> menuList(Map<String, Object> map);
	public FC_FranchiseCommand selectFranchise(int franchise_num);
	public void updateHit(int franchise_num);
	public FC_FranchiseMenuCommand selectMenu(int fmenu_num);
	public void insertBookmark(FC_FranchiseBookmarkCommand bookmark);
	public int selectBookmarkID(FC_FranchiseBookmarkCommand bookmark);
	public void deleteBookmark(FC_FranchiseBookmarkCommand bookmark);
	public int totalFranchiseLike(int franchise_num);
	public int selectFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	public void insertFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	public void deleteFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	public void insertMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	public void deleteMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	public int totalMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	public int selectMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	public MemberCommand selectDeclaredMember(String u_uid_declared);
	
	//프랜차이즈 페이징
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num);
	
	//댓글
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map);
	public void insertReply(FC_FranchiseReplyCommand franchiseReply);
	public int getReplyRowCount(int franchise_num);
	public void deleteReply(int freply_num);
	
	//신고
	public FC_FranchiseReplyCommand selectReply(int freply_num);
	public void insertDeclared(FC_FranchiseDeclaredCommand declaredCommand);
	
	//로그
	public void insertFCafeUserCountLog();
	public void updateFCafeUserCountLog();
	public UserCountLogCommand selectFCafeUserCountLogByDate();
}
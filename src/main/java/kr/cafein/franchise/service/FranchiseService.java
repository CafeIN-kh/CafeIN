package kr.cafein.franchise.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;

@Transactional
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
	
	//프랜차이즈 페이징
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num);
	
	//댓글
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map);
	public void insertReply(FC_FranchiseReplyCommand franchiseReply);
	public int getReplyRowCount(int franchise_num);
	public void deleteReply(int freply_num);
}
package kr.cafein.pcafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Transactional
public interface PCafeService {

	//private_main에서 사용되는 부분(페이징)
	//readOnly select 하는 애들한테만 붙여줌
	@Transactional(readOnly=true)
	public List<PCafeCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(PCafeCommand pcafe);
	//private_cafe 정보 삭제 순서
	public void deleteLikeByPCafe(int pcafe_num);							//private_cafe에 눌려있는 좋아요 모두 삭제
	public void deleteBookmarkByPCafe(int pcafe_num);						//private_cafe에 눌려있는 즐겨찾기 모두 삭제
	public void deletePCafeReplyByPCafe(int pcafe_num);						//private_cafe에 달려있는 댓글 모두 삭제
	public List<PCafeMenuCommand> selectPCafeMenuByPCafe(int pcafe_num);	//private_cafe안의 모든 메뉴 찾기
	public void deletePCafeMenuLikekByPCafe(int pmenu_num);					//private_cafe_menu에 눌려있는 좋아요 모두 삭제
	public void deleteMenuByPCafe(int pcafe_num);							//private_cafe안의 해당 메뉴 모두 삭제
	public void deletePCafe(Map<String,Object> deleteMap);					//해당 private_cafe 정보 삭제
	
	//private_detail에서 사용되는 부분
	@Transactional(readOnly=true)
	public PCafeCommand selectPCafe(Integer pcafe_num);
	public int getCountReply(Integer pcafe_num);
	public int getCountLike(Integer pcafe_num);
	public void updateVisit(Integer pcafe_num);
	public void update(PCafeCommand pcafe);
	
	//private_detail 즐겨찾기
	public int selectBookmarkCount(BookmarkCommand bookmark);
	public void insertBookmark(BookmarkCommand bookmark);
	public void deleteBookmark(BookmarkCommand bookmark);
	
	//private_detail 좋아요
	public int selectLikeCount(LikeCommand like);
	public int selectTotalLikeCount(LikeCommand like);
	public void insertLike(LikeCommand like);
	public void deleteLike(LikeCommand like);
	
	//private_detail_menu(페이징)
	public void insertMenu(PCafeMenuCommand pcafeMenu);
	public int getRowMenuCount(Map<String,Object> map);
	public List<PCafeMenuCommand> menuList(Map<String,Object> map);
	public PCafeMenuCommand selectMenuDetail(int pmenu_num);
	public void deleteMenu(int pmenu_num);		//private_cafe_menu 해당 메뉴 지우기
	public void deleteLikeByPCafeMenu(int pmenu_num);	//private_cafe_menu에 눌려있는 좋아요 기록 지우기
	
	//private_detail_menu 좋아요
	public int selectMenuLikeCount(LikeCommand like);
	public int selectMenuTotalLikeCount(LikeCommand like);
	public void insertMenuLike(LikeCommand like);
	public void deleteMenuLike(LikeCommand like);

	//private_detail_reply(paging)
	public List<PCafeReplyCommand> replyList(Map<String,Object> map);
	public int getRowReplyCount(Map<String,Object> map);
	public void insertReply(PCafeReplyCommand pcafeReply);
	public void deleteReply(Integer preply_num);
	
	//private_detail_reply_declared
	public PCafeReplyCommand selectDeclaredReply(Integer preply_num);
	public MemberCommand selectDeclaredMember(String u_uid);
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//개인카페 등록,삭제,수정,신고에 따른 로그 
	public void insertUserLog(UserMenuLogCommand userMenuLog);
	public MemberCommand selectUserLogByMember(String u_uid);
	
	//개인카페 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	public void insertPCafeUserCountLog();
	public void updatePCafeUserCountLog();
	public UserCountLogCommand selectPCafeUserCountLogByDate();
	
}

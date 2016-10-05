package kr.cafein.customizing.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.customizing.domain.CustomizingDetailBookmarkCommand;
import kr.cafein.customizing.domain.CustomizingDetailCafeNameCommand;
import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.domain.CustomizingDetailULikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Transactional
public interface CustomizingDetailService {
	
	public List<CustomizingDetailCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public CustomizingDetailCommand selectCustomMenu(Map<String, Object> map);
	public void updateHit(Integer custom_num);
	@Transactional(readOnly=true)
	public String selectCafeName(Integer custom_num);
	public void updateCustomMenu(CustomizingDetailCommand customizingDetailCommand);
	@Transactional(readOnly=true)
	public CustomizingDetailCommand selectImg(Integer custom_num);
	public void insertBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Transactional(readOnly=true)
	public int selectUserBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Transactional(readOnly=true)
	public int selectFirstBookmarkCount(Integer custom_num);
	@Transactional(readOnly=true)
	public int selectBookmarkCount(CustomizingDetailBookmarkCommand bookmark);
	public void deleteBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Transactional(readOnly=true)
	public int selectULike(CustomizingDetailULikeCommand likeCommand);
	public void insertLike(CustomizingDetailULikeCommand likeCommand);
	public void deleteLike(CustomizingDetailULikeCommand likeCommand);
	@Transactional(readOnly=true)
	public int selectLikeCount(CustomizingDetailULikeCommand likeCommand);
	@Transactional(readOnly=true)
	public int selectFirstLikeCount(Integer custom_num);
	
	/* 댓글 입력, 삭제, 목록 */
	//댓글 insert
	public void insertReply(CustomizingDetailReplyCommand reply);
	//댓글 list
	@Transactional(readOnly=true)
	public List<CustomizingDetailReplyCommand> customReplyList(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getReplyRowCount(Integer custom_num);
	@Transactional(readOnly=true)
	public List<CustomizingDetailCafeNameCommand> selectCafeMenu();
	//댓글 삭제
	public void customizingReplyDelete(Integer creply_num);
	
	/* 댓글 신고 */
	public CustomizingDetailReplyCommand selectDeclaredCustomizingReply(Integer creply_num);
	public MemberCommand selectDeclaredMember(String u_uid);
	//public UserDeclaredCommand selectDeclaredTargetNum(Integer d_target_num);
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//커스텀 등록,삭제,수정,신고에 따른 로그 
	public void insertCustomUserLog(UserMenuLogCommand userMenuLog);
	public MemberCommand selectCustomUserLogByMember(String u_uid);
	
	public void insertCustomUserCountLog();
	public void updateCustomUserCountLog();
	public UserCountLogCommand selectCustomUserCountLogByDate();
}

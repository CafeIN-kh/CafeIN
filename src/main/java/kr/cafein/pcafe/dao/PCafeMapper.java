package kr.cafein.pcafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Repository
public interface PCafeMapper {
	
	// 회원 탈퇴 (전체 삭제) 회원의 u_uid로 회원이 만든 pcafe_num들을 구함.  
	@Select("SELECT pcafe_num FROM private_cafe WHERE u_uid=#{u_uid}")
	public List<Integer> selectPCafeSeqByUid(String u_uid);
	
	//private_main에서 사용되는 부분(페이징)
	public List<PCafeCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO private_cafe(pcafe_num,u_uid,pcafe_name,pcafe_address,pcafe_phone,pcafe_time,pcafe_url,pcafe_introduce,pcafe_hash_tag,pcafe_img,pcafe_visit,pcafe_reg_date) VALUES (private_cafe_seq.nextval,#{u_uid},#{pcafe_name},#{pcafe_address},#{pcafe_phone},#{pcafe_time},#{pcafe_url},#{pcafe_introduce},#{pcafe_hash_tag},#{pcafe_img,jdbcType=VARCHAR},#{pcafe_visit},sysdate)")
	public void insert(PCafeCommand pcafe);
	//private_cafe 정보 삭제 순서
	@Delete("DELETE FROM u_like WHERE pcafe_num = #{pcafe_num}")
	public void deleteLikeByPCafe(int pcafe_num);							//private_cafe에 눌려있는 좋아요 모두 삭제
	@Delete("DELETE FROM bookmark WHERE pcafe_num = #{pcafe_num}")
	public void deleteBookmarkByPCafe(int pcafe_num);						//private_cafe에 눌려있는 즐겨찾기 모두 삭제
	@Delete("DELETE FROM private_cafe_reply WHERE pcafe_num = #{pcafe_num}")
	public void deletePCafeReplyByPCafe(int pcafe_num);						//private_cafe에 달려있는 댓글 모두 삭제
	@Select("SELECT * FROM private_cafe_menu WHERE pcafe_num = #{pcafe_num}")
	public List<PCafeMenuCommand> selectPCafeMenuByPCafe(int pcafe_num);	//private_cafe안의 모든 메뉴 찾기
	@Delete("DELETE FROM u_like WHERE pmenu_num = #{pmenu_num}")
	public void deletePCafeMenuLikekByPCafe(int pmenu_num);					//private_cafe_menu에 눌려있는 좋아요 모두 삭제
	@Delete("DELETE FROM private_cafe_menu WHERE pcafe_num = #{pcafe_num}")
	public void deleteMenuByPCafe(int pcafe_num);							//private_cafe안의 해당 메뉴 모두 삭제
	@Delete("DELETE FROM private_cafe WHERE pcafe_num = #{pcafe_num} AND u_uid = #{u_uid}")
	public void deletePCafe(Map<String,Object> deleteMap);					//해당 private_cafe 정보 삭제
	
	//private_detail에서 사용되는 부분
	@Select("SELECT * FROM private_cafe WHERE pcafe_num = #{pcafe_num}")
	public PCafeCommand selectPCafe(Integer pcafe_num);
	@Select("SELECT count(*) FROM private_cafe_reply WHERE pcafe_num = #{pcafe_num}")
	public int getCountReply(Integer pcafe_num);
	@Select("SELECT count(*) FROM u_like WHERE pcafe_num = #{pcafe_num}")
	public int getCountLike(Integer pcafe_num);
	@Update("UPDATE private_cafe SET pcafe_visit = pcafe_visit + 1 WHERE pcafe_num = #{pcafe_num}")
	public void updateVisit(Integer pcafe_num);
	@Update("UPDATE private_cafe SET pcafe_name=#{pcafe_name},pcafe_address=#{pcafe_address},pcafe_phone=#{pcafe_phone},pcafe_time=#{pcafe_time},pcafe_url=#{pcafe_url},pcafe_introduce=#{pcafe_introduce},pcafe_hash_tag=#{pcafe_hash_tag},pcafe_img=#{pcafe_img,jdbcType=VARCHAR} WHERE pcafe_num = #{pcafe_num}")
	public void update(PCafeCommand pcafe);
	
	//private_detail 즐겨찾기
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public int selectBookmarkCount(BookmarkCommand bookmark);
	@Insert("INSERT INTO bookmark(bookmark_num,u_uid,franchise_num,pcafe_num,custom_num,bookmark_reg_date) VALUES (bookmark_seq.nextval,#{u_uid},#{franchise_num,jdbcType=INTEGER},#{pcafe_num,jdbcType=INTEGER},#{custom_num,jdbcType=INTEGER},sysdate)")
	public void insertBookmark(BookmarkCommand bookmark);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public void deleteBookmark(BookmarkCommand bookmark);
	
	//private_detail 좋아요
	@Select("SELECT count(*) FROM u_like WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public int selectLikeCount(LikeCommand like);
	@Select("SELECT count(*) FROM u_like WHERE pcafe_num = #{pcafe_num}")
	public int selectTotalLikeCount(LikeCommand like);
	@Insert("INSERT INTO u_like(like_num,u_uid,franchise_num,pcafe_num,custom_num,fmenu_num,pmenu_num,like_reg_date) VALUES (u_like_seq.nextval,#{u_uid},#{franchise_num,jdbcType=INTEGER},#{pcafe_num,jdbcType=INTEGER},#{custom_num,jdbcType=INTEGER},#{fmenu_num,jdbcType=INTEGER},#{pmenu_num,jdbcType=INTEGER},sysdate)")
	public void insertLike(LikeCommand like);
	@Delete("DELETE FROM u_like WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public void deleteLike(LikeCommand like);
	
	//private_detail_menu(paging)
	@Insert("INSERT INTO private_cafe_menu(pmenu_num,pcafe_num,pmenu_name,pmenu_price,pmenu_introduce,pmenu_img) VALUES (private_cafe_menu_seq.nextval,#{pcafe_num},#{pmenu_name},#{pmenu_price},#{pmenu_introduce},#{pmenu_img,jdbcType=VARCHAR})")
	public void insertMenu(PCafeMenuCommand pcafeMenu);
	@Select("SELECT count(*) FROM private_cafe_menu WHERE pcafe_num = #{pcafe_num}")
	public int getRowMenuCount(Map<String,Object> map);
	public List<PCafeMenuCommand> menuList(Map<String,Object> map);
	@Select("SELECT * from private_cafe_menu WHERE pmenu_num = #{pmenu_num}")
	public PCafeMenuCommand selectMenuDetail(int pmenu_num);
	@Delete("DELETE FROM private_cafe_menu WHERE pmenu_num = #{pmenu_num}")
	public void deleteMenu(int pmenu_num);		//private_cafe_menu 해당 메뉴 지우기
	@Delete("DELETE FROM u_like WHERE pmenu_num = #{pmenu_num}")
	public void deleteLikeByPCafeMenu(int pmenu_num);	//private_cafe_menu에 눌려있는 좋아요 기록 지우기
	
	//private_detail_menu 좋아요
	@Select("SELECT count(*) FROM u_like WHERE u_uid = #{u_uid} AND pmenu_num = #{pmenu_num}")
	public int selectMenuLikeCount(LikeCommand like);
	@Select("SELECT count(*) FROM u_like WHERE pmenu_num = #{pmenu_num}")
	public int selectMenuTotalLikeCount(LikeCommand like);
	@Insert("INSERT INTO u_like(like_num,u_uid,franchise_num,pcafe_num,custom_num,fmenu_num,pmenu_num,like_reg_date) VALUES (u_like_seq.nextval,#{u_uid},#{franchise_num,jdbcType=INTEGER},#{pcafe_num,jdbcType=INTEGER},#{custom_num,jdbcType=INTEGER},#{fmenu_num,jdbcType=INTEGER},#{pmenu_num,jdbcType=INTEGER},sysdate)")
	public void insertMenuLike(LikeCommand like);
	@Delete("DELETE FROM u_like WHERE u_uid = #{u_uid} AND pmenu_num = #{pmenu_num}")
	public void deleteMenuLike(LikeCommand like);
	
	//private_detail_reply(paging)
	public List<PCafeReplyCommand> replyList(Map<String,Object> map);
	@Select("SELECT count(*) FROM private_cafe_reply WHERE pcafe_num=#{pcafe_num}")
	public int getRowReplyCount(Map<String,Object> map);
	@Insert("INSERT INTO private_cafe_reply (preply_num,pcafe_num,u_uid,preply_content,preply_nickname,preply_reg_date) VALUES (private_cafe_reply_seq.nextval,#{pcafe_num},#{u_uid,jdbcType=VARCHAR},#{preply_content},#{preply_nickname},sysdate)")
	public void insertReply(PCafeReplyCommand pcafeReply);
	@Delete("DELETE FROM private_cafe_reply WHERE preply_num=#{preply_num}")
	public void deleteReply(Integer preply_num);
	
	//private_detail_reply_declared
	@Select("SELECT * FROM private_cafe_reply WHERE preply_num = #{preply_num}")
	public PCafeReplyCommand selectDeclaredReply(Integer preply_num);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectDeclaredMember(String u_uid);
	@Insert("INSERT INTO declared (d_seq,d_target_path,d_target_num,d_target_id,d_mem_id,d_target_mem_id,d_reg_date,d_content,d_state,d_comment) VALUES (declared_seq.nextval,#{d_target_path},#{d_target_num},#{d_target_id},#{d_mem_id},#{d_target_mem_id},sysdate,#{d_content},#{d_state},#{d_comment})")
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//개인카페 등록,삭제,수정,신고에 따른 로그 
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertUserLog(UserMenuLogCommand userMenuLog);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectUserLogByMember(String u_uid);
	
	//개인카페 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	//insert시 sysdate varchar2 형태로 가공. (사용자의 현재 날짜와 비교하기 위해서. sysdate 상태면 비교 힘듬)
	//@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,TO_CHAR(sysdate,'YYYY-MM-DD'),0,0,0,0,0,0,0)")
	@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,sysdate,0,0,0,0,0,0,0)")
	public void insertPCafeUserCountLog();
	//@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_private=ucnt_log_private+1 WHERE ucnt_log_reg_date = #{ucnt_log_reg_date}")
	@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_private=ucnt_log_private+1 WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public void updatePCafeUserCountLog();
	//@Select("SELECT TO_CHAR(ucnt_log_reg_date,'YYYY-MM-DD')ucnt_log_reg_date FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YYYY-MM-DD') = TO_CHAR(#{today_reg_date},'YYYY-MM-DD')")
	@Select("SELECT * FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public UserCountLogCommand selectPCafeUserCountLogByDate();
	
}

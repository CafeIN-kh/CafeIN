package kr.cafein.customizing.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.customizing.domain.CustomizingDetailBookmarkCommand;
import kr.cafein.customizing.domain.CustomizingDetailCafeNameCommand;
import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.domain.CustomizingDetailULikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Repository
public interface CustomizingDetailMapper {
	   
	public List<CustomizingDetailCommand> list(Map<String, Object> map);
	@Select("SELECT cus.*,u.u_name,f.franchise_name FROM customizing cus, u_user u, franchise f WHERE cus.custom_num =#{custom_num}  and f.franchise_num=#{franchise_num} and u.u_uid=#{u_uid} and cus.franchise_num = f.franchise_num")
	public CustomizingDetailCommand selectCustomMenu(Map<String, Object> map);
	@Update("UPDATE customizing SET custom_visit = custom_visit + 1 where custom_num =#{custom_num}")
	public void updateHit(Integer custom_num);
	@Select("SELECT f.franchise_name FROM customizing cus, franchise f WHERE custom_num =#{custom_num} and cus.franchise_num = f.franchise_num")
	public String selectCafeName(Integer custom_num);
	@Update("UPDATE customizing SET custom_name =#{custom_name},franchise_num=#{franchise_num}, custom_introduce=#{custom_introduce},custom_recipe=#{custom_recipe},custom_img=#{custom_img,jdbcType=VARCHAR},custom_hash_tag=#{custom_hash_tag} WHERE u_uid=${u_uid} AND custom_num =${custom_num}")
	public void updateCustomMenu(CustomizingDetailCommand customizingDetailCommand);
	@Select("SELECT * FROM customizing where custom_num =#{custom_num}")
	public CustomizingDetailCommand selectImg(Integer custom_num);
	@Insert("INSERT INTO bookmark(bookmark_num,u_uid,custom_num,bookmark_reg_date) VALUES (bookmark_seq.nextval,#{u_uid},#{custom_num},sysdate)")
	public void insertBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Select("SELECT count(*) FROM bookmark WHERE u_uid=#{u_uid} AND custom_num=#{custom_num}")
	public int selectUserBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Select("SELECT count(*) count FROM bookmark WHERE custom_num=#{custom_num}")
	public int selectBookmarkCount(CustomizingDetailBookmarkCommand bookmark);
	@Select("SELECT count(*) count FROM bookmark WHERE custom_num=#{custom_num}")
	public int selectFirstBookmarkCount(Integer custom_num);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND custom_num =#{custom_num}")
	public void deleteBookmark(CustomizingDetailBookmarkCommand bookmark);
	@Select("SELECT count(*) FROM u_like WHERE u_uid=#{u_uid} AND custom_num=#{custom_num}")
	public int selectULike(CustomizingDetailULikeCommand likeCommand);
	@Insert("INSERT INTO u_like(like_num,u_uid,custom_num,like_reg_date) VALUES (u_like_seq.nextval,#{u_uid},#{custom_num},sysdate)")
	public void insertLike(CustomizingDetailULikeCommand likeCommand);
	@Delete("DELETE FROM u_like WHERE u_uid = #{u_uid} AND custom_num = #{custom_num}")
	public void deleteLike(CustomizingDetailULikeCommand likeCommand);
	@Select("SELECT count(*) count FROM u_like WHERE custom_num=#{custom_num}")
	public int selectLikeCount(CustomizingDetailULikeCommand likeCommand);
	@Select("SELECT count(*) count FROM u_like WHERE custom_num=#{custom_num}")
	public int selectFirstLikeCount(Integer custom_num);
	
	/* 댓글 입력, 삭제, 목록 */
	//댓글 insert
	@Insert("INSERT INTO customizing_reply(creply_num,custom_num,u_uid,creply_content,creply_nickname,creply_reg_date) VALUES (customizing_reply_seq.nextval,#{custom_num},#{u_uid},#{creply_content},#{creply_nickname},sysdate)")
	public void insertReply(CustomizingDetailReplyCommand reply);
	//댓글 list
	public List<CustomizingDetailReplyCommand> customReplyList(Map<String, Object> map);
	@Select("SELECT count(*) FROM customizing_reply WHERE custom_num=#{custom_num}")
	public int getReplyRowCount(Integer custom_num);
	@Select("SELECT franchise_num,franchise_name FROM franchise")
	public List<CustomizingDetailCafeNameCommand> selectCafeMenu();
	//댓글 삭제
	@Delete("DELETE FROM customizing_reply WHERE creply_num = #{creply_num}")
	public void customizingReplyDelete(Integer creply_num);
	
	/* 댓글 신고 */
	@Select("SELECT * FROM customizing_reply WHERE creply_num = #{creply_num}")
	public CustomizingDetailReplyCommand selectDeclaredCustomizingReply(Integer creply_num);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectDeclaredMember(String u_uid);
	@Insert("INSERT INTO declared (d_seq,d_target_path,d_target_num,d_target_id,d_mem_id,d_target_mem_id,d_reg_date,d_content,d_state,d_comment) VALUES (declared_seq.nextval,#{d_target_path},#{d_target_num},#{d_target_id},#{d_mem_id},#{d_target_mem_id},sysdate,#{d_content},#{d_state},#{d_comment})")
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//커스텀 등록,삭제,수정,신고에 따른 로그 
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertCustomUserLog(UserMenuLogCommand userMenuLog);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectCustomUserLogByMember(String u_uid);
	
	//커스텀메뉴 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	//insert시 sysdate varchar2 형태로 가공. (사용자의 현재 날짜와 비교하기 위해서. sysdate 상태면 비교 힘듬)
	@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,sysdate,0,0,0,0,0,0,0)")
	public void insertCustomUserCountLog();
	@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_custom=ucnt_log_custom+1 WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public void updateCustomUserCountLog();
	@Select("SELECT * FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public UserCountLogCommand selectCustomUserCountLogByDate();
}

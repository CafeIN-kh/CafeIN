package kr.cafein.customizing.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.customizing.domain.CustomizingDetailBookmarkCommand;
import kr.cafein.customizing.domain.CustomizingDetailCafeNameCommand;
import kr.cafein.customizing.domain.CustomizingDetailCommand;
import kr.cafein.customizing.domain.CustomizingDetailReplyCommand;
import kr.cafein.customizing.domain.CustomizingDetailULikeCommand;
import kr.cafein.domain.MemberCommand;
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
	
	/* ��� �Է�, ����, ��� */
	//��� insert
	@Insert("INSERT INTO customizing_reply(creply_num,custom_num,u_uid,creply_content,creply_nickname,creply_reg_date) VALUES (customizing_reply_seq.nextval,#{custom_num},#{u_uid},#{creply_content},#{creply_nickname},sysdate)")
	public void insertReply(CustomizingDetailReplyCommand reply);
	//��� list
	public List<CustomizingDetailReplyCommand> customReplyList(Map<String, Object> map);
	@Select("SELECT count(*) FROM customizing_reply WHERE custom_num=#{custom_num}")
	public int getReplyRowCount(Integer custom_num);
	@Select("SELECT franchise_num,franchise_name FROM franchise")
	public List<CustomizingDetailCafeNameCommand> selectCafeMenu();
	//��� ����
	@Delete("DELETE FROM customizing_reply WHERE creply_num = #{creply_num}")
	public void customizingReplyDelete(Integer creply_num);
	
	/* ��� �Ű� */
	@Select("SELECT * FROM customizing_reply WHERE creply_num = #{creply_num}")
	public CustomizingDetailReplyCommand selectDeclaredCustomizingReply(Integer creply_num);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectDeclaredMember(String u_uid);
	@Insert("INSERT INTO declared (d_seq,d_target_path,d_target_num,d_target_id,d_mem_id,d_target_mem_id,d_reg_date,d_content,d_state,d_comment) VALUES (declared_seq.nextval,#{d_target_path},#{d_target_num},#{d_target_id},#{d_mem_id},#{d_target_mem_id},sysdate,#{d_content},#{d_state},#{d_comment})")
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//Ŀ���� ���,����,����,�Ű� ���� �α� 
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertCustomUserLog(UserMenuLogCommand userMenuLog);
	
}

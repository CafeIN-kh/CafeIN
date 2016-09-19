package kr.cafein.pcafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.DeclaredCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;

@Repository
public interface PCafeMapper {
	
	//private_main���� ���Ǵ� �κ�(����¡)
	public List<PCafeCommand> list(Map<String,Object> map);
	//@Select("SELECT count(*) FROM private_cafe")
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO private_cafe(pcafe_num,u_uid,pcafe_name,pcafe_address,pcafe_phone,pcafe_time,pcafe_url,pcafe_introduce,pcafe_hash_tag,pcafe_img,pcafe_visit,pcafe_reg_date) VALUES (private_cafe_seq.nextval,#{u_uid},#{pcafe_name},#{pcafe_address},#{pcafe_phone},#{pcafe_time},#{pcafe_url},#{pcafe_introduce},#{pcafe_hash_tag},#{pcafe_img,jdbcType=VARCHAR},#{pcafe_visit},sysdate)")
	public void insert(PCafeCommand pcafe);
	//private_cafe ���� ���� ����
	@Delete("DELETE FROM u_like WHERE pcafe_num = #{pcafe_num}")
	public void deleteLikeByPCafe(int pcafe_num);							//private_cafe�� �����ִ� ���ƿ� ��� ����
	@Delete("DELETE FROM bookmark WHERE pcafe_num = #{pcafe_num}")
	public void deleteBookmarkByPCafe(int pcafe_num);						//private_cafe�� �����ִ� ���ã�� ��� ����
	@Delete("DELETE FROM private_cafe_reply WHERE pcafe_num = #{pcafe_num}")
	public void deletePCafeReplyByPCafe(int pcafe_num);						//private_cafe�� �޷��ִ� ��� ��� ����
	@Select("SELECT * FROM private_cafe_menu WHERE pcafe_num = #{pcafe_num}")
	public List<PCafeMenuCommand> selectPCafeMenuByPCafe(int pcafe_num);	//private_cafe���� ��� �޴� ã��
	@Delete("DELETE FROM u_like WHERE pmenu_num = #{pmenu_num}")
	public void deletePCafeMenuLikekByPCafe(int pmenu_num);					//private_cafe_menu�� �����ִ� ���ƿ� ��� ����
	@Delete("DELETE FROM private_cafe_menu WHERE pcafe_num = #{pcafe_num}")
	public void deleteMenuByPCafe(int pcafe_num);							//private_cafe���� �ش� �޴� ��� ����
	//@Select("SELECT * FROM private_cafe WHERE pcafe_num = #{pcafe_num}")
	//public PCafeCommand selectPCafe(int pcafe_num);							//private_cafe ���� ã��(���ε�� �̹��� split �� ������ ����)
	@Delete("DELETE FROM private_cafe WHERE pcafe_num = #{pcafe_num} AND u_uid = #{u_uid}")
	public void deletePCafe(Map<String,Object> deleteMap);					//�ش� private_cafe ���� ����
	
	//private_detail���� ���Ǵ� �κ�
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
	
	//private_detail ���ã��
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public int selectBookmarkCount(BookmarkCommand bookmark);
	@Insert("INSERT INTO bookmark(bookmark_num,u_uid,franchise_num,pcafe_num,custom_num,bookmark_reg_date) VALUES (bookmark_seq.nextval,#{u_uid},#{franchise_num,jdbcType=INTEGER},#{pcafe_num,jdbcType=INTEGER},#{custom_num,jdbcType=INTEGER},sysdate)")
	public void insertBookmark(BookmarkCommand bookmark);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public void deleteBookmark(BookmarkCommand bookmark);
	
	//private_detail ���ƿ�
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
	public void deleteMenu(int pmenu_num);		//private_cafe_menu �ش� �޴� �����
	@Delete("DELETE FROM u_like WHERE pmenu_num = #{pmenu_num}")
	public void deleteLikeByPCafeMenu(int pmenu_num);	//private_cafe_menu�� �����ִ� ���ƿ� ��� �����
	
	//private_detail_menu ���ƿ�
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
	@Insert("INSERT INTO declared (d_seq,d_target_id,d_target_path,d_mem_id,d_target_mem_id,d_reg_date,d_content,d_state) VALUES (declared_seq.nextval,#{d_target_id},#{d_target_path},#{d_mem_id},#{d_target_mem_id},sysdate,#{d_content},#{d_state})")
	public void insertDeclaredReply(DeclaredCommand declared);
	
}

package kr.cafein.admin.privatecafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;
import kr.cafein.admin.privatecafe.domain.PrivateReplyCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;
import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Repository
public interface PrivateMapper {
	//public List<PrivateCommand> list(Map<String, Object> map);
	
/**/
	public int getRowCount(int pcafe_num);

	@Select("SELECT * FROM private_cafe WHERE pcafe_num = #{pcafe_num}")
	public PrivateCommand selectBoard(Integer pcafe_num);

	public List<PrivateMenuCommand> menuList(Map<String, Object> map);
	
	@Select("SELECT pcafe_num,pcafe_name,pcafe_address,pcafe_phone,pcafe_time,pcafe_url,pcafe_introduce,pcafe_hash_tag,pcafe_img,pcafe_visit,pcafe_reg_date FROM private_cafe")
	public List<PrivateCommand> getPrivateList();
	
	@Select ("UPDATE private_cafe SET pcafe_name=#{pcafe_name},pcafe_img=#{pcafe_img},pcafe_address=#{pcafe_address},pcafe_phone=#{pcafe_phone},pcafe_time=#{pcafe_time},pcafe_introduce=#{pcafe_introduce},pcafe_url=#{pcafe_url},pcafe_hash_tag=#{pcafe_hash_tag} WHERE pcafe_num=#{pcafe_num}")
	public void update(PrivateCommand privatecafe);
	
	
	@Select("SELECT * from private_cafe where pcafe_num=#{pcafe_num}")
	public List<PrivateCommand> getPrivateDetailList(Integer pcafe_num);
	
	@Select("SELECT * from private_cafe_menu where pcafe_num=#{pcafe_num}")
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer pcafe_num);
	
	@Select("SELECT * FROM private_cafe_menu WHERE pmenu_num = #{pmenu_num}")
	public PrivateMenuCommand selectMenu(Integer pmenu_num);
	
	@Update("UPDATE private_cafe_menu SET pmenu_name=#{pmenu_name},pmenu_price=#{pmenu_price},pmenu_introduce=#{pmenu_introduce},pmenu_img=#{pmenu_img,jdbcType=VARCHAR} WHERE pmenu_num=#{pmenu_num}")
	public void update2(PrivateMenuCommand privateCafeMenu);
	
	@Select("select u_uid from u_like where pcafe_num = #{pcafe_num}")
	public List<LikeCommand> getLikeUser(Integer pcafe_num);

	
	
	@Delete ("delete  from private_cafe where pcafe_num=#{pcafe_num}")
	public void delete(Integer pcafe_num);
	
	@Delete ("delete from private_cafe_menu where pmenu_num=#{pmenu_num}")
	public void deletemenu(Integer pmenu_num);
	
	@Delete ("delete from private_cafe_menu where pcafe_num=#{pcafe_num}")
	public void deleteallmenu(Integer pcafe_num);
	
	@Delete ("delete from private_cafe_reply where pcafe_num=#{pcafe_num}")
	public void deletereply(Integer pcafe_num);
	
	
	@Select("SELECT * FROM private_cafe_reply WHERE pcafe_num = #{pcafe_num}")
	public List<PrivateReplyCommand> selectReplyp(int pcafe_num);
	
	
	
	
	
	
	
	
	
	
	@Select("SELECT pcafe_num from private_cafe_reply WHERE preply_num = #{preply_num}")
	public int selectPcafe_num(Integer preply_num);
	
	@Delete("DELETE from private_cafe_reply where preply_num = #{preply_num}")
	public void deletePrivateReplyAdminp(int preply_num);
	
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectEmail(String u_uid);
	
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertAdminPrivateLog(UserMenuLogCommand userMenuLogCommand);
	
	
	
	
	
/*
 * 
 * 		로그 미완
 * 
	  @Select("select * from admin_private_log")
	   public List<AdminPrivateLogCommand> getAdmin_Notice_LogList();
	   
	   @Insert("insert into admin_private_log (ap_log_num, ap_log_uid, ap_log_reg_date, ap_log_change, ap_log_message) values (ap_log_seq.nextval, #{ap_log_uid}, sysdate, #{ap_log_change}, #{ap_log_message})")
	   public void inserAdmin_Notice_Log(AdminPrivateLogCommand AdmincustomizinglogCommand);
	*/
	
	
	
	
	
	
	
	
	
}

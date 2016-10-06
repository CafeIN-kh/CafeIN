package kr.cafein.admin.customizingcafe.dao;

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
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingListCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingLogCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;


@Repository
public interface AdminCustomizingMapper {
	

	public int getRowCount(int custom_num);
	
	@Select("SELECT * FROM customizing_reply WHERE custom_num = #{custom_num}")
	public List<AdminCustomizingReplyCommand> selectReplyc(Map<String, Object> map);

	
	
	@Select("select u_uid from customizing where custom_num = #{custom_num}")
	public String selectUid(Integer custom_num);
	
	@Select("SELECT custom_num, franchise_name,custom_name,custom_reg_date, custom_visit from customizing inner join franchise on customizing.franchise_num = franchise.franchise_num order by custom_reg_date desc")
	public List<AdminCustomizingListCommand> selectCafeJoin();
	
	@Select("SELECT franchise_num,franchise_name FROM franchise")
	public List<AdminCustomizingDetailCafeNameCommand> selectCafeMenu_Admin();
	
	@Select("SELECT franchise_num from customizing WHERE custom_num = #{custom_num}")
	public int selectFranchise_num(Integer custom_num);
	
	@Select("SELECT franchise_name FROM franchise where franchise_num = #{franchise_num}")
	public String selectCafeName_Admin(Integer franchise_num);
	

	@Select("SELECT * FROM customizing WHERE custom_num = #{custom_num}")
	public AdminCustomizingCommand getCustomizing(Integer custom_num);

	@Select("SELECT * FROM customizing")
	public List<AdminCustomizingCommand> selectCustomizing();
	
	public List<AdminCustomizingDetailCommand> searchList(Map<String, Object> map);
	
	@Select("SELECT * FROM customizing WHERE franchise_num = #{franchise_num}")
	public List<AdminCustomizingCommand> getCustomizingList(Integer franchise_num);
	
	
	//이랍
	@Update ("UPDATE customizing SET franchise_num=#{franchise_num},custom_name=#{custom_name},custom_img=#{custom_img},custom_reg_date=#{custom_reg_date},custom_recipe=#{custom_recipe},custom_hash_tag=#{custom_hash_tag},custom_introduce=#{custom_introduce} WHERE custom_num=#{custom_num}")
	public void update(AdminCustomizingCommand customizing);
	
	@Delete ("Delete  from customizing where custom_num=#{custom_num}")
	public void delete(Integer custom_num);
	
	@Delete ("Delete  from customizing_reply where custom_num=#{custom_num}")
	public void deleteReply(Integer custom_num);
	
	@Select("SELECT * from customizing where custom_num=#{custom_num}")
	public List<AdminCustomizingCommand> getCustomizingCafeDetailList(Integer custom_num);
	
	
	
	//완전히 바꿔야함..  u_uid 참조해서 가져와야하
	@Select("SELECT * from customizing where u_uid=#{u_uid}")
	public List<AdminCustomizingCommand> getCustomizingCafeMenuList(Integer u_uid);
	
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public List<LikeCommand> getLikeUser(Integer custom_num);
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public int selectBookmarkCount(BookmarkCommand bookmark);
	
	

	@Select("SELECT custom_num from customizing_reply WHERE creply_num = #{creply_num}")
	public int selectCustom_num(Integer creply_num);
	
	@Delete("DELETE from customizing_reply where creply_num = #{creply_num}")
	public void deleteCutomizingReplyAdmin(int creply_num);
	
	@Delete("DELETE from customizing_reply where custom_num = #{custom_num}")
	public void deleteCutomizingReplyAdminc(int custom_num);
	
	@Delete("DELETE from customizing_reply where custom_num = #{custom_num}")
	public void deleteCutomizingCafeAdmin(int custom_num);
	
	@Select("SELECT count(*) from customizing_reply where custom_num = #{custom_num}")
	public int getRowCount_admin_customizingReply(int custom_num);
	
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectEmail(String u_uid);
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertAdminCustomLog(UserMenuLogCommand userMenuLogCommand);
	
	@Insert("INSERT INTO c_log(c_log_seq,custom_num,u_uid,c_log_reg_date,c_log_change,c_log_message) VALUES(c_log_seq.nextval,#{custom_num},#{u_uid},sysdate,#{c_log_change},#{c_log_message})")
	public void insertLog(AdminCustomizingLogCommand adminCustomizingLogCommand);
	
	@Select("SELECT * FROM c_log")
	public List<AdminCustomizingLogCommand> selectLog();
	
	
	/*
	 * 
	 * 로그 
	 * 
	 * 
	  @Select("select * from admin_customizing_log")
	   public List<AdminCustomizingLogCommand> getAdmin_Notice_LogList();
	   
	   @Insert("insert into admin_customizing_log (ac_log_num, ac_log_uid, ac_log_reg_date, ac_log_change, ac_log_message) values (ac_log_seq.nextval, #{ac_log_uid}, sysdate, #{ac_log_change}, #{ac_log_message})")
	   public void inserAdmin_Notice_Log(AdminCustomizingLogCommand AdmincustomizinglogCommand);*/
	
	
	
	
	
	
	
}
	
	



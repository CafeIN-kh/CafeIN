package kr.cafein.admin.customizingcafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingCommand;

@Repository
public interface AdminCustomizingMapper {
	

	public int getRowCount(int custom_num);

	@Select("SELECT * FROM customizing WHERE custom_num = #{custom_num}")
	public AdminCustomizingCommand getCustomizing(Integer custom_num);

	@Select("SELECT * FROM customizing")
	public List<AdminCustomizingCommand> selectCustomizing();
	
	public List<AdminCustomizingCommand> searchList(Map<String, Object> map);
	
	@Select("SELECT * FROM customizing WHERE franchise_num = #{franchise_num}")
	public List<AdminCustomizingCommand> getCustomizingList(Integer franchise_num);
	
	//이랍
	@Update ("UPDATE customizing SET custom_name=#{custom_name},custom_img=#{custom_img},custom_reg_date=#{custom_reg_date},custom_recipe=#{custom_recipe},custom_hash_tag=#{custom_hash_tag},custom_introduce=#{custom_introduce} WHERE custom_num=#{custom_num}")
	public void update(AdminCustomizingCommand customizing);
	
	@Delete ("Delete  from customizing where custom_num=#{custom_num}")
	public void delete(Integer custom_num);
	
	@Select("SELECT * from customizing where custom_num=#{custom_num}")
	public List<AdminCustomizingCommand> getCustomizingCafeDetailList(Integer custom_num);
	
	
	
	//완전히 바꿔야함..  u_uid 참조해서 가져와야하
	@Select("SELECT * from customizing where u_uid=#{u_uid}")
	public List<AdminCustomizingCommand> getCustomizingCafeMenuList(Integer u_uid);
	
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public List<LikeCommand> getLikeUser(Integer custom_num);
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public int selectBookmarkCount(BookmarkCommand bookmark);
	
	

}

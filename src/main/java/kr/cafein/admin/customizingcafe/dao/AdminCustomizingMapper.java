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
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCafeNameCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingDetailCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingListCommand;
import kr.cafein.admin.customizingcafe.domain.AdminCustomizingReplyCommand;


@Repository
public interface AdminCustomizingMapper {
	

	public int getRowCount(int custom_num);
	
	@Select("SELECT * FROM customizing_reply WHERE custom_num = #{custom_num}")
	public List<AdminCustomizingReplyCommand> selectReply(Integer custom_num);

	
	
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
	
	
	//�̶�
	@Update ("UPDATE customizing SET franchise_num=#{franchise_num},custom_name=#{custom_name},custom_img=#{custom_img},custom_reg_date=#{custom_reg_date},custom_recipe=#{custom_recipe},custom_hash_tag=#{custom_hash_tag},custom_introduce=#{custom_introduce} WHERE custom_num=#{custom_num}")
	public void update(AdminCustomizingCommand customizing);
	
	@Delete ("Delete  from customizing where custom_num=#{custom_num}")
	public void delete(Integer custom_num);
	
	@Select("SELECT * from customizing where custom_num=#{custom_num}")
	public List<AdminCustomizingCommand> getCustomizingCafeDetailList(Integer custom_num);
	
	
	
	//������ �ٲ����..  u_uid �����ؼ� �����;���
	@Select("SELECT * from customizing where u_uid=#{u_uid}")
	public List<AdminCustomizingCommand> getCustomizingCafeMenuList(Integer u_uid);
	
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public List<LikeCommand> getLikeUser(Integer custom_num);
	
	@Select("SELECT u_uid from u_like where custom_num = #{custom_num}")
	public int selectBookmarkCount(BookmarkCommand bookmark);
	
	

}

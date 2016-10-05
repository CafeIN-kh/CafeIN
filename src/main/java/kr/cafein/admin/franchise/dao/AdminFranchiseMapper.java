package kr.cafein.admin.franchise.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.franchise.domain.AdminFranchiseCommand;
import kr.cafein.admin.franchise.domain.AdminFranchiseMenuCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Repository
public interface AdminFranchiseMapper {
	
	@Update("update franchise_menu set franchise_num=#{franchise_num}, fmenu_name=#{fmenu_name}, fmenu_introduce=#{fmenu_introduce}, fmenu_img=#{fmenu_img}, fmenu_price=#{fmenu_price} where fmenu_num=#{fmenu_num}")
	public void updateFranchiseMenu(AdminFranchiseMenuCommand adminFranchiseMenuCommand);
	
	@Update("update franchise set franchise_name=#{franchise_name}, franchise_introduce=#{franchise_introduce}, franchise_img=#{franchise_img} where franchise_num=#{franchise_num}")
	public void updateFranchise(AdminFranchiseCommand adminFranchiseCommand);
	
	@Select("SELECT * FROM franchise_menu")
	public List<AdminFranchiseMenuCommand> menuList2();
	
	public int getRowCount(int franchise_num);
	
	public List<AdminFranchiseCommand> list(String franchise_name);
	
	public List<AdminFranchiseMenuCommand> menuList(Map<String, Object> map);
	
	@Select("SELECT * FROM franchise WHERE franchise_num = #{franchise_num}")
	public AdminFranchiseCommand selectFranchise(int franchise_num);
	
	@Insert("INSERT INTO franchise(franchise_introduce,franchise_img,franchise_num,franchise_name) VALUES(#{franchise_introduce},#{franchise_img,jdbcType=VARCHAR},franchise_seq.nextval,#{franchise_name})")
	public void insert(AdminFranchiseCommand franchise_isert);
	
	@Insert("INSERT INTO franchise_menu(fmenu_num,franchise_num,fmenu_name,fmenu_price,fmenu_img,fmenu_introduce) VALUES(franchise_menu_seq.nextval,#{franchise_num},#{fmenu_name},#{fmenu_price},#{fmenu_img,jdbcType=VARCHAR},#{fmenu_introduce})")
	public void insertMenu(AdminFranchiseMenuCommand franchise_insertMenu);
	
	@Delete ("delete from franchise where franchise_num=#{franchise_num}")
	public void delete(int franchise_num);
	
	@Delete ("delete from franchise_menu where fmenu_num=#{fmenu_num}")
	public void deletemenu(int fmenu_num);
	
	@Select("select franchise_name from franchise where franchise_num = #{franchise_num}")
	public String getFranchise_name(int franchise_num);
	
	@Select("select franchise_num from franchise where franchise_num = #{franchise_num}")
	public int getFranchise_num(int franchise_num);
	
	@Update("UPDATE franchise SET franchise_visit = franchise_visit + 1 WHERE franchise_num = #{franchise_num}")
	public void updateHit(int franchise_num);

	public List<AdminFranchiseCommand> listDetail(int franchise_num);
	
	@Select("SELECT * FROM franchise WHERE franchise_num = #{franchise_num}")
	public AdminFranchiseCommand selectFranchiseDetail(int franchise_num);

	@Select("SELECT * FROM franchise_menu WHERE fmenu_num = #{fmenu_num}")
	public AdminFranchiseMenuCommand selectFmenu(int fmenu_num);
	
	
}
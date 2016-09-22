package kr.cafein.admin.privatecafe.dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.privatecafe.domain.PrivateMenuCommand;

import kr.cafein.admin.privatecafe.domain.PrivateCommand;

@Repository
public interface PrivateMapper {
	//public List<PrivateCommand> list(Map<String, Object> map);

	

	@Select("SELECT * FROM private_cafe WHERE pcafe_num = #{pcafe_num}")
	public PrivateCommand selectBoard(Integer pcafe_num);

	@Select("SELECT pcafe_num,pcafe_name,pcafe_address,pcafe_phone,pcafe_time,pcafe_url,pcafe_introduce,pcafe_hash_tag,pcafe_img,pcafe_visit,pcafe_reg_date FROM private_cafe")
	public List<PrivateCommand> getPrivateList();
	
	@Select ("UPDATE private_cafe SET pcafe_name=#{pcafe_name},pcafe_address=#{pcafe_address},pcafe_phone=#{pcafe_phone},pcafe_time=#{pcafe_time},pcafe_introduce=#{pcafe_introduce},pcafe_url=#{pcafe_url},pcafe_hash_tag=#{pcafe_hash_tag} WHERE pcafe_num=#{pcafe_num}")
	public void update(PrivateCommand privatecafe);
	
	@Delete ("delete  from private_cafe where pcafe_num=#{pcafe_num}")
	public void delete(Integer pcafe_num);
	
	@Select("SELECT * from private_cafe where pcafe_num=#{pcafe_num}")
	public List<PrivateCommand> getPrivateDetailList(Integer pcafe_num);
	
	@Select("SELECT * from private_cafe_menu where pcafe_num=#{pcafe_num}")
	public List<PrivateMenuCommand> getPrivateCafeMenuList(Integer pcafe_num);
	
	@Select("SELECT * FROM private_cafe_menu WHERE pmenu_num = #{pmenu_num}")
	public PrivateMenuCommand selectMenu(Integer pmenu_num);
	
	@Update("UPDATE private_cafe_menu SET pmenu_name=#{pmenu_name},pmenu_price=#{pmenu_price},pmenu_introduce=#{pmenu_introduce},pmenu_img=#{pmenu_img,jdbcType=VARCHAR} WHERE pmenu_num=#{pmenu_num}")
	public void update2(PrivateMenuCommand privateCafeMenu);
}

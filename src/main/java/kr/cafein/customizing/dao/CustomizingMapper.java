package kr.cafein.customizing.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;

@Repository
public interface CustomizingMapper {
	//�θ��
	//searchList�� Ű���忡 ���缭 �׿� �ش��ϴ� ���̺��� �ҷ����� ��
	//getRowCount�� Ű���� ���缭 �׿� �ش��ϴ� ���̺��� ������ �ҷ����� ��
	//pagingList�� �Ϲ� ī�� ���� �������� list�� �����ȰŴϱ� �����ҷ�����(���⼭�� �� �ҷ����� ���� �ƴ϶� rnum10���� �ҷ�����
	@Insert("INSERT INTO CUSTOMIZING(CUSTOM_NUM,FRANCHISE_NUM,U_UID,CUSTOM_NAME,CUSTOM_INTRODUCE,CUSTOM_RECIPE,CUSTOM_IMG,CUSTOM_HASH_TAG,CUSTOM_REG_DATE) VALUES (customizing_seq.nextval,#{franchise_num},#{u_uid},#{custom_name},#{custom_introduce},#{custom_recipe},#{custom_img,jdbcType=VARCHAR},#{custom_hash_tag},sysdate)")
	public void insert(CustomizingCommand customizing);
	public List<CustomizingCommand> searchList(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	public List<CustomizingCommand> pagingList(Map<String,Object> map);
	public List<CustomizingCommand> pagingVisitList(Map<String,Object> map);
	public List<CustomizingCommand> pagingLikeList(Map<String,Object> map);
	public List<CustomizingCommand> pagingSearchLikeList(Map<String,Object> map);
	@Select("SELECT * FROM customizing where custom_num=#{custom_num}")
	public CustomizingCommand selectBoard(Integer custom_num);
	@Select("SELECT * FROM franchise")
	public List<FranchiseCommand> selectBrand(); 
	
	@Delete("DELETE FROM u_like WHERE custom_num=#{custom_num}")
	public void deleteU_like(int custom_num);
	@Delete("DELETE FROM customizing_reply WHERE custom_num=#{custom_num}")
	public void deleteReply(int custom_num);
	@Delete("DELETE FROM bookmark WHERE custom_num=#{custom_num}")
	public void deleteBookmark(int custom_num);
	@Delete("DELETE FROM customizing WHERE custom_num=#{custom_num}")
	public void deleteCboard(int custom_num);
	
	
	
	public List<CustomizingCommand> selectCafe(Map<String,Object> map);

	
	@Select ("SELECT custom_num FROM customizing WHERE u_uid=#{u_uid}")
	public List<Integer> selectCustomSeqByUid(String u_uid);
	
	
	
}




		
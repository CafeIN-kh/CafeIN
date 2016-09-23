package kr.cafein.mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.BookmarkAndMypageCommand;
import kr.cafein.domain.LikeAndMypageCommand;

@Repository
public interface MypageMapper {

	//���������� ����ī�� ���ã��
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num != 0 AND pcafe_num is not null")
	public int getRowPCafeBookmarkCount(Map<String,Object> map);
	//@Select("SELECT * FROM private_cafe WHERE pcafe_num = #{pcafe_num}")
	public List<BookmarkAndMypageCommand> selectPCafeByBookmarkMypage(Map<String,Object> map);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND pcafe_num = #{pcafe_num}")
	public void deletePCafeBookmarkMypage(Map<String,Object> map);
	
	//���������� ���������� ���ã��
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num != 0 AND franchise_num is not null")
	public int getRowFCafeBookmarkCount(Map<String,Object> map);
	public List<BookmarkAndMypageCommand> selectFCafeByBookmarkMypage(Map<String,Object> map);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public void deleteFCafeBookmarkMypage(Map<String,Object> map);
	
	//���������� Ŀ���Ҹ���¡�޴� ���ã��
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND custom_num != 0 AND custom_num is not null")
	public int getRowCustomBookmarkCount(Map<String,Object> map);
	public List<BookmarkAndMypageCommand> selectCustomByBookmarkMypage(Map<String,Object> map);
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND custom_num = #{custom_num}")
	public void deleteCustomBookmarkMypage(Map<String,Object> map);
	
	//���������� ī�� ���ƿ�
	public int getRowCafeLikeCount(Map<String,Object> map);
	public List<LikeAndMypageCommand> selectCafeByLikeMypage(Map<String,Object> map);
	public void deleteCafeLikeMypage(Map<String,Object> map);
	
	//���������� �޴� ���ƿ�
	public int getRowMenuLikeCount(Map<String,Object> map);
	public List<LikeAndMypageCommand> selectMenuByLikeMypage(Map<String,Object> map);
	public void deleteMenuLikeMypage(Map<String,Object> map);
}

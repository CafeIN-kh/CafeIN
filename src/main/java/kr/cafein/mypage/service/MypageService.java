package kr.cafein.mypage.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.BookmarkAndMypageCommand;
import kr.cafein.domain.LikeAndMypageCommand;

@Transactional
public interface MypageService {

	//���������� ����ī�� ���ã��
	public int getRowPCafeBookmarkCount(Map<String,Object> map);
	public List<BookmarkAndMypageCommand> selectPCafeByBookmarkMypage(Map<String,Object> map);
	public void deletePCafeBookmarkMypage(Map<String,Object> map);
	
	//���������� ���������� ���ã��
	public int getRowFCafeBookmarkCount(Map<String,Object> map);
	public List<BookmarkAndMypageCommand> selectFCafeByBookmarkMypage(Map<String,Object> map);
	public void deleteFCafeBookmarkMypage(Map<String,Object> map);
	
	//���������� Ŀ���Ҹ���¡�޴� ���ã��
	public int getRowCustomBookmarkCount(Map<String,Object> map);
	public List<BookmarkAndMypageCommand> selectCustomByBookmarkMypage(Map<String,Object> map);
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

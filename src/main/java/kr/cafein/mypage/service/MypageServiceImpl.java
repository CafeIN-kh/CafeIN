package kr.cafein.mypage.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.BookmarkAndMypageCommand;
import kr.cafein.domain.LikeAndMypageCommand;
import kr.cafein.mypage.dao.MypageMapper;

@Service("mypageService")
public class MypageServiceImpl implements MypageService{
	
	@Resource
	private MypageMapper mypageMapper;

	@Override
	public List<BookmarkAndMypageCommand> selectPCafeByBookmarkMypage(Map<String,Object> map) {
		return mypageMapper.selectPCafeByBookmarkMypage(map);
	}

	@Override
	public void deletePCafeBookmarkMypage(Map<String,Object> map) {
		mypageMapper.deletePCafeBookmarkMypage(map);
	}

	@Override
	public int getRowPCafeBookmarkCount(Map<String, Object> map) {
		return mypageMapper.getRowPCafeBookmarkCount(map);
	}

	@Override
	public int getRowFCafeBookmarkCount(Map<String, Object> map) {
		return mypageMapper.getRowFCafeBookmarkCount(map);
	}

	@Override
	public List<BookmarkAndMypageCommand> selectFCafeByBookmarkMypage(Map<String, Object> map) {
		return mypageMapper.selectFCafeByBookmarkMypage(map);
	}

	@Override
	public void deleteFCafeBookmarkMypage(Map<String, Object> map) {
		mypageMapper.deleteFCafeBookmarkMypage(map);
	}

	@Override
	public int getRowCustomBookmarkCount(Map<String, Object> map) {
		return mypageMapper.getRowCustomBookmarkCount(map);
	}

	@Override
	public List<BookmarkAndMypageCommand> selectCustomByBookmarkMypage(Map<String, Object> map) {
		return mypageMapper.selectCustomByBookmarkMypage(map);
	}

	@Override
	public void deleteCustomBookmarkMypage(Map<String, Object> map) {
		mypageMapper.deleteCustomBookmarkMypage(map);
	}

	@Override
	public int getRowCafeLikeCount(Map<String, Object> map) {
		return mypageMapper.getRowCafeLikeCount(map);
	}

	@Override
	public List<LikeAndMypageCommand> selectCafeByLikeMypage(Map<String, Object> map) {
		return mypageMapper.selectCafeByLikeMypage(map);
	}

	@Override
	public void deleteCafeLikeMypage(Map<String, Object> map) {
		mypageMapper.deleteCafeLikeMypage(map);
	}

	@Override
	public int getRowMenuLikeCount(Map<String, Object> map) {
		return mypageMapper.getRowMenuLikeCount(map);
	}

	@Override
	public List<LikeAndMypageCommand> selectMenuByLikeMypage(Map<String, Object> map) {
		return mypageMapper.selectMenuByLikeMypage(map);
	}

	@Override
	public void deleteMenuLikeMypage(Map<String, Object> map) {
		mypageMapper.deleteMenuLikeMypage(map);
	}

}

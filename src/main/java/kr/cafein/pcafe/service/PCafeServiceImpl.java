package kr.cafein.pcafe.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.pcafe.dao.PCafeMapper;

@Service("pcafeService")
public class PCafeServiceImpl implements PCafeService{

	@Resource
	private PCafeMapper pcafeMapper;

	//private_main에서 사용되는 부분
	@Override
	public List<PCafeCommand> list(Map<String, Object> map) {
		return pcafeMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return pcafeMapper.getRowCount(map);
	}

	@Override
	public void insert(PCafeCommand pcafe) {
		pcafeMapper.insert(pcafe);
	}

	//private_detail에서 사용되는 부분
	@Override
	public PCafeCommand selectPCafe(Integer pcafe_num) {
		return pcafeMapper.selectPCafe(pcafe_num);
	}
	
	@Override
	public int getCountReply(Integer pcafe_num) {
		return pcafeMapper.getCountReply(pcafe_num);
	}

	@Override
	public int getCountLike(Integer pcafe_num) {
		return pcafeMapper.getCountLike(pcafe_num);
	}

	@Override
	public void updateVisit(Integer pcafe_num) {
		pcafeMapper.updateVisit(pcafe_num);
	}

	@Override
	public void update(PCafeCommand pcafe) {
		pcafeMapper.update(pcafe);
	}

	@Override
	public void delete(Integer seq) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertBookmark(BookmarkCommand bookmark) {
		pcafeMapper.insertBookmark(bookmark);
	}

	@Override
	public void deleteBookmark(BookmarkCommand bookmark) {
		pcafeMapper.deleteBookmark(bookmark);
	}

	@Override
	public int selectBookmarkCount(BookmarkCommand bookmark) {
		return pcafeMapper.selectBookmarkCount(bookmark);
	}

	@Override
	public int selectLikeCount(LikeCommand like) {
		return pcafeMapper.selectLikeCount(like);
	}

	@Override
	public int selectTotalLikeCount(LikeCommand like) {
		return pcafeMapper.selectTotalLikeCount(like);
	}

	@Override
	public void insertLike(LikeCommand like) {
		pcafeMapper.insertLike(like);
	}

	@Override
	public void deleteLike(LikeCommand like) {
		pcafeMapper.deleteLike(like);
	}

	@Override
	public void insertMenu(PCafeMenuCommand pcafeMenu) {
		pcafeMapper.insertMenu(pcafeMenu);
	}

	@Override
	public int getRowMenuCount(Map<String, Object> map) {
		return pcafeMapper.getRowMenuCount(map);
	}

	@Override
	public List<PCafeMenuCommand> menuList(Map<String, Object> map) {
		return pcafeMapper.menuList(map);
	}

	@Override
	public PCafeMenuCommand selectMenuDetail(int pmenu_num) {
		return pcafeMapper.selectMenuDetail(pmenu_num);
	}

	@Override
	public int selectMenuLikeCount(LikeCommand like) {
		return pcafeMapper.selectMenuLikeCount(like);
	}

	@Override
	public int selectMenuTotalLikeCount(LikeCommand like) {
		return pcafeMapper.selectMenuTotalLikeCount(like);
	}

	@Override
	public void insertMenuLike(LikeCommand like) {
		pcafeMapper.insertMenuLike(like);
	}

	@Override
	public void deleteMenuLike(LikeCommand like) {
		pcafeMapper.deleteMenuLike(like);
	}

	@Override
	public List<PCafeReplyCommand> replyList(Map<String, Object> map) {
		return pcafeMapper.replyList(map);
	}

	@Override
	public int getRowReplyCount(Map<String, Object> map) {
		return pcafeMapper.getRowReplyCount(map);
	}

	@Override
	public void insertReply(PCafeReplyCommand pcafeReply) {
		pcafeMapper.insertReply(pcafeReply);
	}

	@Override
	public void deleteReply(Integer preply_num) {
		pcafeMapper.deleteReply(preply_num);
	}
	
}

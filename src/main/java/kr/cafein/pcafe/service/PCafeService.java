package kr.cafein.pcafe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.BookmarkCommand;
import kr.cafein.domain.LikeCommand;
import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.PCafeCommand;
import kr.cafein.domain.PCafeMenuCommand;
import kr.cafein.domain.PCafeReplyCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserDeclaredCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Transactional
public interface PCafeService {

	//private_main���� ���Ǵ� �κ�(����¡)
	//readOnly select �ϴ� �ֵ����׸� �ٿ���
	@Transactional(readOnly=true)
	public List<PCafeCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(PCafeCommand pcafe);
	//private_cafe ���� ���� ����
	public void deleteLikeByPCafe(int pcafe_num);							//private_cafe�� �����ִ� ���ƿ� ��� ����
	public void deleteBookmarkByPCafe(int pcafe_num);						//private_cafe�� �����ִ� ���ã�� ��� ����
	public void deletePCafeReplyByPCafe(int pcafe_num);						//private_cafe�� �޷��ִ� ��� ��� ����
	public List<PCafeMenuCommand> selectPCafeMenuByPCafe(int pcafe_num);	//private_cafe���� ��� �޴� ã��
	public void deletePCafeMenuLikekByPCafe(int pmenu_num);					//private_cafe_menu�� �����ִ� ���ƿ� ��� ����
	public void deleteMenuByPCafe(int pcafe_num);							//private_cafe���� �ش� �޴� ��� ����
	public void deletePCafe(Map<String,Object> deleteMap);					//�ش� private_cafe ���� ����
	
	//private_detail���� ���Ǵ� �κ�
	@Transactional(readOnly=true)
	public PCafeCommand selectPCafe(Integer pcafe_num);
	public int getCountReply(Integer pcafe_num);
	public int getCountLike(Integer pcafe_num);
	public void updateVisit(Integer pcafe_num);
	public void update(PCafeCommand pcafe);
	
	//private_detail ���ã��
	public int selectBookmarkCount(BookmarkCommand bookmark);
	public void insertBookmark(BookmarkCommand bookmark);
	public void deleteBookmark(BookmarkCommand bookmark);
	
	//private_detail ���ƿ�
	public int selectLikeCount(LikeCommand like);
	public int selectTotalLikeCount(LikeCommand like);
	public void insertLike(LikeCommand like);
	public void deleteLike(LikeCommand like);
	
	//private_detail_menu(����¡)
	public void insertMenu(PCafeMenuCommand pcafeMenu);
	public int getRowMenuCount(Map<String,Object> map);
	public List<PCafeMenuCommand> menuList(Map<String,Object> map);
	public PCafeMenuCommand selectMenuDetail(int pmenu_num);
	public void deleteMenu(int pmenu_num);		//private_cafe_menu �ش� �޴� �����
	public void deleteLikeByPCafeMenu(int pmenu_num);	//private_cafe_menu�� �����ִ� ���ƿ� ��� �����
	
	//private_detail_menu ���ƿ�
	public int selectMenuLikeCount(LikeCommand like);
	public int selectMenuTotalLikeCount(LikeCommand like);
	public void insertMenuLike(LikeCommand like);
	public void deleteMenuLike(LikeCommand like);

	//private_detail_reply(paging)
	public List<PCafeReplyCommand> replyList(Map<String,Object> map);
	public int getRowReplyCount(Map<String,Object> map);
	public void insertReply(PCafeReplyCommand pcafeReply);
	public void deleteReply(Integer preply_num);
	
	//private_detail_reply_declared
	public PCafeReplyCommand selectDeclaredReply(Integer preply_num);
	public MemberCommand selectDeclaredMember(String u_uid);
	public void insertDeclaredReply(UserDeclaredCommand declared);
	
	//����ī�� ���,����,����,�Ű� ���� �α� 
	public void insertUserLog(UserMenuLogCommand userMenuLog);
	public MemberCommand selectUserLogByMember(String u_uid);
	
	//����ī�� �������� �α�, ���� ��¥�� �����Ͱ� ������ insert, ������ update�� +1 ī��Ʈ
	public void insertPCafeUserCountLog();
	public void updatePCafeUserCountLog();
	public UserCountLogCommand selectPCafeUserCountLogByDate();
	
}

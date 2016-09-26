package kr.cafein.franchise.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseDeclaredCommand;
import kr.cafein.franchise.domain.FC_FranchiseLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuLikeCommand;
import kr.cafein.franchise.domain.FC_FranchiseReplyCommand;



@Repository
public interface FranchiseMapper {
	//����������
	public List<FC_FranchiseCommand> list();
	//����¡ ���� �� ī��Ʈ
	public int getRowCount(int franchise_num);
	//�޴����
	@Select("SELECT * FROM (select ROWNUM rnum, a.* From(select * from franchise_menu where franchise_num = #{franchise_num} order by fmenu_num asc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseMenuCommand> menuList(Map<String, Object> map);
	//�ּ�ó��
	@Select("SELECT * FROM franchise WHERE franchise_num = #{franchise_num}")
	public FC_FranchiseCommand selectFranchise(int franchise_num);
	//��ȸ��
	@Update("UPDATE franchise SET franchise_visit = franchise_visit + 1 WHERE franchise_num = #{franchise_num}")
	public void updateHit(int franchise_num);
	//�޴���
	@Select("SELECT * FROM franchise_menu where fmenu_num = #{fmenu_num}")
	public FC_FranchiseMenuCommand selectMenu(int fmenu_num);
	//�ϸ�ũ �߰�
	@Insert("INSERT INTO bookmark(bookmark_num, u_uid, franchise_num) VALUES (bookmark_seq.nextval, #{u_uid}, #{franchise_num})")
	public void insertBookmark(FC_FranchiseBookmarkCommand bookmark);
	//�ϸ�ũ üũ
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public int selectBookmarkID(FC_FranchiseBookmarkCommand bookmark);
	//�ϸ�ũ üũX
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public void deleteBookmark(FC_FranchiseBookmarkCommand bookmark);
	//���������� ���ƿ� Ŭ��
	@Insert("INSERT INTO u_like(like_num, u_uid, franchise_num) VALUES (u_like_seq.nextval, #{u_uid}, #{franchise_num})")
	public void insertFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	//���������� ���ƿ� X
	@Delete("DELETE FROM u_like WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public void deleteFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	//��������� ��Ż ���ƿ� ��
	@Select("SELECT count(*) FROM u_like WHERE franchise_num = #{franchise_num}")
	public int totalFranchiseLike(int franchise_num);
	//���������� ���̵� ���ƿ� ��
	@Select("SELECT count(*) FROM u_like WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public int selectFranchiseLike(FC_FranchiseLikeCommand franchiseLikeCommand);
	//���������� ����¡�� �� ������ ��� ����
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_menu where franchise_num = #{franchise_num} order by fmenu_num asc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num);
	//�޴� ���ƿ� Ŭ��
	@Insert("INSERT INTO u_like(like_num, u_uid, fmenu_num) VALUES (u_like_seq.nextval, #{u_uid}, #{fmenu_num})")
	public void insertMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	//�޴� ���ƿ� X
	@Delete("DELETE FROM u_like WHERE u_uid = #{u_uid} AND fmenu_num = #{fmenu_num}")
	public void deleteMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	//�޴��� ��Ż ���ƿ� ��
	@Select("SELECT count(*) FROM u_like WHERE fmenu_num = #{fmenu_num}")
	public int totalMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	//�޴� ���̵� ���ƿ� ��
	@Select("SELECT count(*) FROM u_like WHERE u_uid = #{u_uid} AND fmenu_num = #{fmenu_num}")
	public int selectMenuLike(FC_FranchiseMenuLikeCommand franchiseMenuLikeCommand);
	//ȸ������ ����
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectDeclaredMember(String u_uid_declared);
	
	
	//���
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_reply where franchise_num = #{franchise_num} order by freply_num desc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map);
	@Insert("INSERT INTO franchise_reply(freply_num, franchise_num, u_uid, freply_content, freply_nickname, freply_reg_date) VALUES (franchise_reply_seq.nextval, #{franchise_num}, #{u_uid}, #{freply_content}, #{freply_nickname}, sysdate)")
	public void insertReply(FC_FranchiseReplyCommand franchiseReply);
	@Select("SELECT count(*) FROM franchise_reply WHERE franchise_num=#{franchise_num}")
	public int getReplyRowCount(int franchise_num);
	@Delete("DELETE FROM franchise_reply WHERE freply_num = #{freply_num}")
	public void deleteReply(int freply_num);
	
	//�Ű�
	
	//��� ����
	@Select("SELECT * FROM franchise_reply WHERE freply_num = #{freply_num}")
	public FC_FranchiseReplyCommand selectReply(int freply_num);
	//�Ű�
	@Insert("INSERT INTO declared(d_seq, d_target_path, d_target_num, d_target_id, d_mem_id, d_target_mem_id, d_reg_date, d_content, d_state, d_comment) "
			+ "VALUES(declared_seq.nextval, #{d_target_path}, #{d_target_num}, #{d_target_id}, #{d_target_mem_id}, #{d_target_mem_id}, sysdate, #{d_content}, #{d_state}, #{d_comment})")
	public void insertDeclared(FC_FranchiseDeclaredCommand declaredCommand);
	
	//�α�
	//����ī�� �������� �α�, ���� ��¥�� �����Ͱ� ������ insert, ������ update�� +1 ī��Ʈ
	//insert�� sysdate varchar2 ���·� ����. (������� ���� ��¥�� ���ϱ� ���ؼ�. sysdate ���¸� �� ����)
	//@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,TO_CHAR(sysdate,'YYYY-MM-DD'),0,0,0,0,0,0,0)")
	@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,sysdate,0,0,0,0,0,0,0)")
	public void insertFCafeUserCountLog();
	//@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_private=ucnt_log_private+1 WHERE ucnt_log_reg_date = #{ucnt_log_reg_date}")
	@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_franchise=ucnt_log_franchise+1 WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public void updateFCafeUserCountLog();
	//@Select("SELECT TO_CHAR(ucnt_log_reg_date,'YYYY-MM-DD')ucnt_log_reg_date FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YYYY-MM-DD') = TO_CHAR(#{today_reg_date},'YYYY-MM-DD')")
	@Select("SELECT * FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public UserCountLogCommand selectFCafeUserCountLogByDate();
}


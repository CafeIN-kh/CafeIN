package kr.cafein.franchise.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.franchise.domain.FC_FranchiseBookmarkCommand;
import kr.cafein.franchise.domain.FC_FranchiseCommand;
import kr.cafein.franchise.domain.FC_FranchiseMenuCommand;
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
	@Insert("INSERT INTO bookmark(bookmark_num, u_uid, franchise_num, bookmark_reg_date) VALUES (bookmark_seq.nextval, #{u_uid}, #{franchise_num}, sysdate)")
	public void insertBookmark(FC_FranchiseBookmarkCommand bookmark);
	//�ϸ�ũ üũ
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public int selectBookmarkID(FC_FranchiseBookmarkCommand bookmark);
	//�ϸ�ũ üũX
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public void deleteBookmark(FC_FranchiseBookmarkCommand bookmark);
	
	//���������� ����¡�� �� ������ ��� ����
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_menu where franchise_num = #{franchise_num} order by fmenu_num asc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num);
	
	//���
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_reply where franchise_num = #{franchise_num} order by freply_num desc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map);
	@Insert("INSERT INTO franchise_reply(freply_num, franchise_num, u_uid, freply_content, freply_nickname, freply_reg_date) VALUES (franchise_reply_seq.nextval, #{franchise_num}, #{u_uid}, #{freply_content}, #{freply_nickname}, sysdate)")
	public void insertReply(FC_FranchiseReplyCommand franchiseReply);
	@Select("SELECT count(*) FROM franchise_reply WHERE franchise_num=#{franchise_num}")
	public int getReplyRowCount(int franchise_num);
	@Delete("DELETE FROM franchise_reply WHERE freply_num = #{freply_num}")
	public void deleteReply(int freply_num);
	
}

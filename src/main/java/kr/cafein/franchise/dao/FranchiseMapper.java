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
	//프랜차이즈
	public List<FC_FranchiseCommand> list();
	//페이징 위한 총 카운트
	public int getRowCount(int franchise_num);
	//메뉴출력
	@Select("SELECT * FROM (select ROWNUM rnum, a.* From(select * from franchise_menu where franchise_num = #{franchise_num} order by fmenu_num asc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseMenuCommand> menuList(Map<String, Object> map);
	//주소처리
	@Select("SELECT * FROM franchise WHERE franchise_num = #{franchise_num}")
	public FC_FranchiseCommand selectFranchise(int franchise_num);
	//조회수
	@Update("UPDATE franchise SET franchise_visit = franchise_visit + 1 WHERE franchise_num = #{franchise_num}")
	public void updateHit(int franchise_num);
	//메뉴상세
	@Select("SELECT * FROM franchise_menu where fmenu_num = #{fmenu_num}")
	public FC_FranchiseMenuCommand selectMenu(int fmenu_num);
	//북마크 추가
	@Insert("INSERT INTO bookmark(bookmark_num, u_uid, franchise_num, bookmark_reg_date) VALUES (bookmark_seq.nextval, #{u_uid}, #{franchise_num}, sysdate)")
	public void insertBookmark(FC_FranchiseBookmarkCommand bookmark);
	//북마크 체크
	@Select("SELECT count(*) FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public int selectBookmarkID(FC_FranchiseBookmarkCommand bookmark);
	//북마크 체크X
	@Delete("DELETE FROM bookmark WHERE u_uid = #{u_uid} AND franchise_num = #{franchise_num}")
	public void deleteBookmark(FC_FranchiseBookmarkCommand bookmark);
	
	//프랜차이즈 페이징용 한 페이지 출력 갯수
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_menu where franchise_num = #{franchise_num} order by fmenu_num asc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseMenuCommand> menuListPaging(int franchise_num);
	
	//댓글
	@Select("select * from (select ROWNUM rnum, a.* From(select * from franchise_reply where franchise_num = #{franchise_num} order by freply_num desc) a where ROWNUM <= #{end}) where rnum >= #{start}")
	public List<FC_FranchiseReplyCommand> listReply(Map<String, Object> map);
	@Insert("INSERT INTO franchise_reply(freply_num, franchise_num, u_uid, freply_content, freply_nickname, freply_reg_date) VALUES (franchise_reply_seq.nextval, #{franchise_num}, #{u_uid}, #{freply_content}, #{freply_nickname}, sysdate)")
	public void insertReply(FC_FranchiseReplyCommand franchiseReply);
	@Select("SELECT count(*) FROM franchise_reply WHERE franchise_num=#{franchise_num}")
	public int getReplyRowCount(int franchise_num);
	@Delete("DELETE FROM franchise_reply WHERE freply_num = #{freply_num}")
	public void deleteReply(int freply_num);
	
}

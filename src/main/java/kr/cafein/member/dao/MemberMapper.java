package kr.cafein.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;

@Repository
public interface MemberMapper {
	@Insert("INSERT INTO u_user(u_uid,u_email,u_name,u_password,u_reg_date,u_level) VALUES (user_seq.nextval,#{u_email},#{u_name},#{u_password},sysdate,#{u_level})")
	public void insert(MemberCommand member);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectMember(String u_uid);
	@Select("SELECT u_uid FROM u_user WHERE u_email= #{u_email}")
	public String selectUid(String u_email);
	
	@Update("UPDATE u_user SET u_email=#{u_email},u_name=#{u_name},u_password=#{u_password} WHERE u_uid=#{u_uid}")
	public void update(MemberCommand member);
	@Delete("DELETE FROM u_user WHERE u_uid = #{u_uid}")
	public void delete(String u_uid);
	
	@Update("UPDATE u_user SET u_level=3 WHERE u_uid = #{u_uid}")
	public void deleteLevel(String u_uid);
   
	@Delete("DELETE FROM u_user WHERE u_uid = #{u_uid}")
	public void deleteAll(String u_uid);
	   
	
	// 관리자 페이지
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	@Select("SELECT count(*) FROM u_user")
	public int getMemberCount();
	
	@Select("SELECT * FROM u_user")
	public List<MemberCommand> getAllMemberList();
	
	//회원 로그인,회원가입,수정,탈퇴에 따른 로그 
	@Insert("INSERT INTO user_log (u_log_seq,u_uid,u_log_reg_date,u_log_change,u_log_message) VALUES (user_log_seq.nextval,#{u_uid},sysdate,#{u_log_change},#{u_log_message})")
	public void insertMemberUserLog(UserLogCommand userLog);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectMemberUserLogByUid(String u_uid);
}
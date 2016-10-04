package kr.cafein.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.MemberCommand;

@Repository
public interface MemberMapper {
	@Insert("INSERT INTO u_user(u_uid,u_email,u_name,u_password,u_reg_date,u_level) VALUES (user_seq.nextval,#{u_email},#{u_name},#{u_password},sysdate,#{u_level})")
	public void insert(MemberCommand member);
	@Select("SELECT * FROM u_user WHERE u_uid = #{u_uid}")
	public MemberCommand selectMember(String u_uid);
	@Select("SELECT u_uid FROM u_user WHERE u_email= #{u_email}")
	public String selectUid(String u_email);
	
	@Update("UPDATE u_user SET u_email=#{u_email},u_name=#{u_name},u_password=#{u_password},u_level=#{u_level} WHERE u_uid=#{u_uid}")
	public void update(MemberCommand member);
	
	
	@Update("UPDATE u_user SET u_level=4 WHERE u_uid = #{u_uid}")
	public void deleteLevel(String u_uid);
	
	@Delete("DELETE FROM u_user WHERE u_uid = #{u_uid}")
	public void deleteAll(String u_uid);
	
	
	
	
	// ������ ������
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	@Select("SELECT count(*) FROM u_user")
	public int getMemberCount();
	
	@Select("SELECT * FROM u_user")
	public List<MemberCommand> getAllMemberList();
}
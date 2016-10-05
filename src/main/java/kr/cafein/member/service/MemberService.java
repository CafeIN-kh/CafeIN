package kr.cafein.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;

//모든 메소드에 트랜잭션 처리 가능
@Transactional
public interface MemberService {

	public void insert(MemberCommand member);
	// 읽기전용
	@Transactional(readOnly = true)
	public MemberCommand selectMember(String u_uid);

	
	@Transactional(readOnly = true)
	public String selectUid(String u_email);
	
	public void update(MemberCommand member);
	public void delete(String u_uid);
	
	public void deleteLevel(String u_uid);
	public void deleteAll(String u_uid);
	
	// 관리자 페이지 회원정보 테이블
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	public int getMemberCount();
	
	public List<MemberCommand> getAllMemberList();

	//회원 로그인,회원가입,수정,탈퇴에 따른 로그 
	public void insertMemberUserLog(UserLogCommand userLog);
	public MemberCommand selectMemberUserLogByUid(String u_uid);
}

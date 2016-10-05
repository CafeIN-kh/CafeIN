package kr.cafein.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;

//��� �޼ҵ忡 Ʈ����� ó�� ����
@Transactional
public interface MemberService {

	public void insert(MemberCommand member);
	// �б�����
	@Transactional(readOnly = true)
	public MemberCommand selectMember(String u_uid);

	
	@Transactional(readOnly = true)
	public String selectUid(String u_email);
	
	public void update(MemberCommand member);
	public void delete(String u_uid);
	
	public void deleteLevel(String u_uid);
	public void deleteAll(String u_uid);
	
	// ������ ������ ȸ������ ���̺�
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	public int getMemberCount();
	
	public List<MemberCommand> getAllMemberList();

	//ȸ�� �α���,ȸ������,����,Ż�� ���� �α� 
	public void insertMemberUserLog(UserLogCommand userLog);
	public MemberCommand selectMemberUserLogByUid(String u_uid);
}

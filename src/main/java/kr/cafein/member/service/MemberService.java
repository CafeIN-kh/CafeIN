package kr.cafein.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.domain.MemberCommand;

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
	public void deleteLevel(String u_uid);
	public void deleteAll(String u_uid);
	
	// ������ ������ ȸ������ ���̺�
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	public int getMemberCount();
	
	public List<MemberCommand> getAllMemberList();

}

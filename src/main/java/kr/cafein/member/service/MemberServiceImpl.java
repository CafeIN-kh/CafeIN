package kr.cafein.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.MemberCommand;
import kr.cafein.domain.UserLogCommand;
import kr.cafein.member.dao.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberMapper memberMapper;

	
	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberCommand selectMember(String u_uid) {
		return memberMapper.selectMember(u_uid);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);
	}

	@Override
	public void delete(String u_uid) {
		/*// id�� �ۼ��� �θ���� ��ȣ�� ����
		List <Integer> seq = boardMapper.selectSeqById(id);
		// �ش� id�� �ۼ��� �θ�ۿ� �޸� ��� ����
		if(seq!=null && !seq.isEmpty()){
			boardMapper.deleteReplyBySeqList(seq);
		}
		
		// �ش� id�� �ۼ��� ��� ����
		boardMapper.deleteReplyById(id);
		// �ش� id�� �ۼ��� �θ�� ����
		boardMapper.deleteById(id);
		
		// �ش� id ����
		*/
		
		memberMapper.delete(u_uid);
	}

	@Override
	public String selectUid(String u_email) {
		// TODO Auto-generated method stub
		return memberMapper.selectUid(u_email);
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return memberMapper.getMemberCount();
	}

	@Override
	public List<MemberCommand> getMemberList(Map<String, Object> map) {
		
		return memberMapper.getMemberList(map);
	}

	@Override
	public List<MemberCommand> getAllMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.getAllMemberList();
	}

	@Override
	public void insertMemberUserLog(UserLogCommand userLog) {
		memberMapper.insertMemberUserLog(userLog);
	}

	@Override
	public MemberCommand selectMemberUserLogByUid(String u_uid) {
		return memberMapper.selectMemberUserLogByUid(u_uid);
	}

	@Override
	public void deleteLevel(String u_uid) {
		memberMapper.deleteLevel(u_uid);
	}

	@Override
	public void deleteAll(String u_uid) {
		memberMapper.deleteAll(u_uid);
	}




}

package kr.cafein.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.domain.MemberCommand;
import kr.cafein.member.dao.MemberMapper;
import kr.cafein.pcafe.dao.PCafeMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberMapper memberMapper;
	
	@Resource
	private PCafeMapper pcafeMapper;

	
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
	public void deleteLevel(String u_uid) {
		
		memberMapper.deleteLevel(u_uid); // update level =4  계정 정지
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
	public void deleteAll(String u_uid) {
		/*// id로 작성된 부모글의 번호를 구함
		List <Integer> seq = boardMapper.selectSeqById(id);
		// 해당 id로 작성된 부모글에 달린 댓글 삭제
		if(seq!=null && !seq.isEmpty()){
			boardMapper.deleteReplyBySeqList(seq);
		}
		
		// 해당 id로 작성된 댓글 삭제
		boardMapper.deleteReplyById(id);
		// 해당 id로 작성된 부모글 삭제
		boardMapper.deleteById(id);
		
		// 해당 id 삭제
		*/
		
		
		
		// 개인카페 게시글, 연결 댓글 삭제
		// 해당 회원이 작성한 pcafe_num 구하기
		List<Integer> pCafeSeq =  pcafeMapper.selectPCafeSeqByUid(u_uid);
		
		
		
		
		
		
		
		// 커스텀 좋아요, 즐겨찾기, 커스텀 넘을 지움, 커스텀 넘에연결된 댓글
		// 좋아요 즐겨찾기테이블에 있는 모든 정보 
		
		
		
		// user 테이블 삭제
		memberMapper.deleteAll(u_uid); 
	}




}

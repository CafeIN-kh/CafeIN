package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.domain.DeclaredCommand;

//모든 메소드에 트랜잭션 처리 가능

@Transactional
public interface DeclaredService {
	
	public String getMemberId(String u_uid);
	// 신고테이블 전체 리스트
	public List<DeclaredCommand> getDeclaredList(Map<String, Object> map);
	
	// 신고테이블 행 
	public int getDeclaredRowCount(Map<String,Object> map);
	
	// 신고테이블 중 처리 상태 업데이트
	public void updateState(Map<String,Object> map);
	// 처리 코맨트 업데이트
	public void updateComment(Map<String,Object> map);

}

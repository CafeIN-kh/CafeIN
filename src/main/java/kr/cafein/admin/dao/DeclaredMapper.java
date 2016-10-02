package kr.cafein.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.domain.DeclaredCommand;


@Repository  //@Repository는 일반적으로 DAO에 사용되며 DB Exception을 DataAccessException으로 변환한다.
public interface DeclaredMapper {

	// 신고테이블 
	// 관리자 페이지

	
	@Select("SELECT u_email from u_user where u_uid=#{u_uid}")
	public String getMemberId(String u_uid);
	
		public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
		public int getDeclaredRowCount(Map<String,Object> map);
		
		
		// 처리 상태 selectPicker로 변경 처리
		@Update("UPDATE declared SET d_state=#{d_state} WHERE d_seq=#{d_seq}")
		public void updateState(Map<String,Object> map);
		
		// 처리 상태에 대한 코멘트 (어떻게 처리하였다.)
		@Update("UPDATE declared SET d_comment=#{d_comment} WHERE d_seq=#{d_seq}")
		public void updateComment(Map<String,Object> map);

	
}

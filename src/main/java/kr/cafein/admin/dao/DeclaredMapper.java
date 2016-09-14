package kr.cafein.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.domain.DeclaredCommand;


@Repository  //@Repository는 일반적으로 DAO에 사용되며 DB Exception을 DataAccessException으로 변환한다.
public interface DeclaredMapper {

	// 신고테이블 
	// 관리자 페이지
		public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
		@Select("SELECT count(*) FROM declared")
		public int getDeclaredCount();
		
		@Select("SELECT * FROM declared")
		public List<DeclaredCommand> getAllDeclaredList();
	
}

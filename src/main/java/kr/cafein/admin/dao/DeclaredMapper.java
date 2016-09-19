package kr.cafein.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.domain.DeclaredCommand;


@Repository  //@Repository�� �Ϲ������� DAO�� ���Ǹ� DB Exception�� DataAccessException���� ��ȯ�Ѵ�.
public interface DeclaredMapper {

	// �Ű����̺� 
	// ������ ������
		public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
		@Select("SELECT count(*) FROM declared")
		public int getDeclaredCount();
		
		@Select("SELECT * FROM declared")
		public List<DeclaredCommand> getAllDeclaredList();
	
}

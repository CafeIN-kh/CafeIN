package kr.cafein.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.domain.DeclaredCommand;


@Repository  //@Repository�� �Ϲ������� DAO�� ���Ǹ� DB Exception�� DataAccessException���� ��ȯ�Ѵ�.
public interface DeclaredMapper {

	// �Ű����̺� 
	// ������ ������

	
	@Select("SELECT u_email from u_user where u_uid=#{u_uid}")
	public String getMemberId(String u_uid);
	
		public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
		public int getDeclaredRowCount(Map<String,Object> map);
		
		
		// ó�� ���� selectPicker�� ���� ó��
		@Update("UPDATE declared SET d_state=#{d_state} WHERE d_seq=#{d_seq}")
		public void updateState(Map<String,Object> map);
		
		// ó�� ���¿� ���� �ڸ�Ʈ (��� ó���Ͽ���.)
		@Update("UPDATE declared SET d_comment=#{d_comment} WHERE d_seq=#{d_seq}")
		public void updateComment(Map<String,Object> map);

	
}

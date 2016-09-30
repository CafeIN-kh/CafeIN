package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.domain.DeclaredCommand;

//��� �޼ҵ忡 Ʈ����� ó�� ����

@Transactional
public interface DeclaredService {
	
	public String getMemberId(String u_uid);
	// �Ű����̺� ��ü ����Ʈ
	public List<DeclaredCommand> getDeclaredList(Map<String, Object> map);
	
	// �Ű����̺� �� 
	public int getDeclaredRowCount(Map<String,Object> map);
	
	// �Ű����̺� �� ó�� ���� ������Ʈ
	public void updateState(Map<String,Object> map);
	// ó�� �ڸ�Ʈ ������Ʈ
	public void updateComment(Map<String,Object> map);

}

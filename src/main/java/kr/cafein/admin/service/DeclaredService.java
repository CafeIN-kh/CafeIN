package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.domain.DeclaredCommand;

//��� �޼ҵ忡 Ʈ����� ó�� ����

@Transactional
public interface DeclaredService {
	public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
	@Select("SELECT count(*) FROM declared")
	public int getDeclaredCount();
	
	@Select("SELECT * FROM declared")
	public List<DeclaredCommand> getAllDeclaredList();
}

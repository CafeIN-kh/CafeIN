package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.domain.DeclaredCommand;

//모든 메소드에 트랜잭션 처리 가능

@Transactional
public interface DeclaredService {
	public List<DeclaredCommand> getDeclaredList(Map<String,Object> map);
	
	public int getDeclaredCount();
	
	
	public List<DeclaredCommand> getAllDeclaredList();
}

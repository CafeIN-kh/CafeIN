package kr.cafein.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.dao.DeclaredMapper;
import kr.cafein.admin.domain.DeclaredCommand;

/*
 * @Service�� ������ Class�� �����Ͻ� ������ ���� Service�� ����� �ȴ�.
 *  Controller�� �ִ� @Autowired�� @Service("xxxService")�� ��ϵ� xxxService�� �������� ���ƾ� �ϸ� 
 *  Service�� �ִ� @Autowired�� @Repository("xxxDao")�� ��ϵ� xxDao�� �������� ���ƾ� �Ѵ�.
 * */
@Service("declaredService")
public class DeclaredServiceImpl implements  DeclaredService{

	
	@Resource
	private DeclaredMapper declaredMapper;
	
	@Override
	public int getDeclaredCount() {
		// TODO Auto-generated method stub
		return declaredMapper.getDeclaredCount();
	}
	
	
	/*@Override
	public List<DeclaredCommand> getDeclaredList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return declaredMapper.getDeclaredList(map);
	}*/



	@Override
	public List<DeclaredCommand> getAllDeclaredList() {
		// TODO Auto-generated method stub
		return declaredMapper.getAllDeclaredList();
	}

}

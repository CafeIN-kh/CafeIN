package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.dao.DeclaredMapper;
import kr.cafein.admin.domain.DeclaredCommand;


@Service("declaredService")
public class DeclaredServiceImpl implements  DeclaredService{

	
	@Resource
	private DeclaredMapper declaredMapper;
	

	
	@Override
	public List<DeclaredCommand> getDeclaredList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return declaredMapper.getDeclaredList(map);
	}



	@Override
	public void updateState(Map<String,Object> map) {
		
		 declaredMapper.updateState(map);
	}


	@Override
	public void updateComment(Map<String,Object> map) {
		
		declaredMapper.updateComment(map);
		
	}


	@Override
	public int getDeclaredRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return declaredMapper.getDeclaredRowCount(map);
	}



	@Override
	public String getMemberId(String u_uid) {
		// TODO Auto-generated method stub
		return declaredMapper.getMemberId(u_uid);
	}

}

package kr.cafein.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.dao.DeclaredMapper;
import kr.cafein.admin.domain.DeclaredCommand;

/*
 * @Service를 적용한 Class는 비지니스 로직이 들어가는 Service로 등록이 된다.
 *  Controller에 있는 @Autowired는 @Service("xxxService")에 등록된 xxxService와 변수명이 같아야 하며 
 *  Service에 있는 @Autowired는 @Repository("xxxDao")에 등록된 xxDao와 변수명이 같아야 한다.
 * */
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

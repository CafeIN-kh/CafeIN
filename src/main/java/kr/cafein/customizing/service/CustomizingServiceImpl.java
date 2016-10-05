package kr.cafein.customizing.service;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import kr.cafein.customizing.dao.CustomizingMapper;
import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;

@Service("customizingService")
public class CustomizingServiceImpl implements CustomizingService {
	@Resource
	private CustomizingMapper customizingMapper;

	@Override
	public void insert(CustomizingCommand customizing) {
		// TODO Auto-generated method stub
		customizingMapper.insert(customizing);
	}


	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.getRowCount(map);
	}



	@Override
	public List<CustomizingCommand> pagingList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.pagingList(map);
	
	
	}


	@Override
	public List<CustomizingCommand> searchList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.searchList(map);
	}


	@Override
	public CustomizingCommand selectBoard(Integer custom_num) {
		// TODO Auto-generated method stub
		return customizingMapper.selectBoard(custom_num);
	}


	@Override
	public List<CustomizingCommand> pagingVisitList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.pagingVisitList(map);
	}


	@Override
	public List<FranchiseCommand> selectBrand() {
		// TODO Auto-generated method stub
		return customizingMapper.selectBrand();
	}


	@Override
	public List<CustomizingCommand> pagingLikeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.pagingLikeList(map);
	}


	@Override
	public List<CustomizingCommand> pagingSearchLikeList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.pagingSearchLikeList(map);
	}


	@Override
	public void deleteCboard(int custom_num) {
		// TODO Auto-generated method stub
		customizingMapper.deleteCboard(custom_num);
	}


	@Override
	public List<CustomizingCommand> selectCafe(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return customizingMapper.selectCafe(map);
	}


	@Override
	public void deleteU_like(int custom_num) {
		// TODO Auto-generated method stub
		customizingMapper.deleteU_like(custom_num);
		
	}


	@Override
	public void deleteReply(int custom_num) {
		// TODO Auto-generated method stub
		customizingMapper.deleteReply(custom_num);
		
	}


	@Override
	public void deleteBookmark(int custom_num) {
		// TODO Auto-generated method stub
		customizingMapper.deleteBookmark(custom_num);
	}


	

}

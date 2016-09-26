package kr.cafein.customizing.service;


import java.util.List;
import java.util.Map;

import kr.cafein.domain.CustomizingCommand;
import kr.cafein.domain.FranchiseCommand;

public interface CustomizingService {
	
	
	public void insert(CustomizingCommand customizing);
	//public void updateVisit(Integer custom_num);
	public int getRowCount(Map<String,Object> map);
	public List<CustomizingCommand> searchList(Map<String,Object> map);
	public List<CustomizingCommand> pagingList(Map<String,Object> map);
	public CustomizingCommand selectBoard(Integer custom_num);
	public List<CustomizingCommand> pagingVisitList(Map<String,Object> map);
	public List<FranchiseCommand> selectBrand();
	public List<CustomizingCommand> pagingLikeList(Map<String,Object> map);
	public List<CustomizingCommand> pagingSearchLikeList(Map<String,Object> map);
	public void deleteCboard(int custom_num);
	public List<CustomizingCommand> selectCafe(Map<String,Object> map);}

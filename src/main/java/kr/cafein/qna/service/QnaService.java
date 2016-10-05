package kr.cafein.qna.service;


import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.qna.domain.QnaCommand;

public interface QnaService {
	
	public void insert(QnaCommand qna);
	
	//qna 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	//insert시 sysdate varchar2 형태로 가공. (사용자의 현재 날짜와 비교하기 위해서. sysdate 상태면 비교 힘듬)
	public void insertQnAUserCountLog();
	public void updateQnAUserCountLog();
	public UserCountLogCommand selectQnAUserCountLogByDate();
	
	//qna 등록,삭제,수정,신고에 따른 로그 
	public void insertQnaUserLog(UserMenuLogCommand userMenuLog);
}

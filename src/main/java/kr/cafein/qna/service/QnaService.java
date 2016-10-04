package kr.cafein.qna.service;


import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.qna.domain.QnaCommand;

public interface QnaService {
	
	public void insert(QnaCommand qna);
	
	//qna �������� �α�, ���� ��¥�� �����Ͱ� ������ insert, ������ update�� +1 ī��Ʈ
	//insert�� sysdate varchar2 ���·� ����. (������� ���� ��¥�� ���ϱ� ���ؼ�. sysdate ���¸� �� ����)
	public void insertQnAUserCountLog();
	public void updateQnAUserCountLog();
	public UserCountLogCommand selectQnAUserCountLogByDate();
	
	//qna ���,����,����,�Ű� ���� �α� 
	public void insertQnaUserLog(UserMenuLogCommand userMenuLog);
}

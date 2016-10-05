package kr.cafein.qna.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.qna.domain.QnaCommand;

@Repository
public interface QnaMapper {
	
	@Insert("INSERT INTO QNA(QA_NUM,QA_EMAIL,QA_TITLE,QA_CONTENT,qa_password,QA_REG_DATE,QA_F_OPTION,qa_answer) VALUES (qna_seq.nextval,#{email},#{title},#{content},#{password},sysdate,#{inline},#{qa_answer})")
	public void insert(QnaCommand qna);

	//qna 페이지뷰 로그, 오늘 날짜의 데이터가 없으면 insert, 있으면 update로 +1 카운트
	//insert시 sysdate varchar2 형태로 가공. (사용자의 현재 날짜와 비교하기 위해서. sysdate 상태면 비교 힘듬)
	@Insert("INSERT INTO user_count_log (ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) VALUES (user_count_log_seq.nextval,sysdate,0,0,0,0,0,0,0)")
	public void insertQnAUserCountLog();
	@Update("UPDATE user_count_log SET ucnt_total=ucnt_total+1,ucnt_log_qna=ucnt_log_qna+1 WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public void updateQnAUserCountLog();
	@Select("SELECT * FROM user_count_log WHERE TO_CHAR(ucnt_log_reg_date,'YY-MM-DD') = TO_CHAR(sysdate,'YY-MM-DD')")
	public UserCountLogCommand selectQnAUserCountLogByDate();
	
	//qna 등록,삭제,수정,신고에 따른 로그 
	@Insert("INSERT INTO user_menu_log (umenu_log_seq,umenu_log_reg_date,umenu_log_u_uid,umenu_name,umenu_log_state,umenu_log_message) VALUES (umenu_log_seq.nextval,sysdate,#{umenu_log_u_uid},#{umenu_name},#{umenu_log_state},#{umenu_log_message})")
	public void insertQnaUserLog(UserMenuLogCommand userMenuLog);
	
	
}





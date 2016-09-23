package kr.cafein.qna.dao;


import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import kr.cafein.qna.domain.QnaCommand;

@Repository
public interface QnaMapper {
	//ºÎ¸ð±Û
	
	@Insert("INSERT INTO QNA(QA_NUM,QA_EMAIL,QA_TITLE,QA_CONTENT,QA_PASSWORD,QA_REG_DATE,QA_F_OPTION) VALUES (qna_seq.nextval,#{email},#{title},#{content},#{password},sysdate,#{inline})")
	public void insert(QnaCommand qna);

	
	
	
}





package kr.cafein.admin.qna.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.qna.domain.QnaCommand;

@Repository
public interface QnaMapper {
	public List<QnaCommand> list(Map<String, Object> map);

	@Select("SELECT qa_num,qa_email,qa_title,qa_content,qa_reg_date,qa_f_option FROM qna")
	public List<QnaCommand> getQaList();
	
	@Delete ("delete from qna where qa_num=#{seq}")
	public void delete(Integer seq);
	
	@Select ("select * from qna where qa_num=#{seq}")
	public QnaCommand selectQna(Integer seq);

	@Update("update qna set qa_answer=1 where qa_num=#{seq}")
	public void updateQnaAnswer(Integer seq);
}

package kr.cafein.admin.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.cafein.admin.qna.domain.AdminQnaCommand;
import kr.cafein.admin.qna.domain.AdminQnaLogCommand;
import kr.cafein.domain.UserMenuLogCommand;

@Repository
public interface AdminQnaMapper {
	//public List<QnaCommand> list(Map<String, Object> map);

	@Select("SELECT qa_num,qa_email,qa_title,qa_content,qa_reg_date,qa_f_option,qa_answer FROM qna")
	public List<AdminQnaCommand> getQaList();
	
	@Delete ("delete from qna where qa_num=#{seq}")
	public void delete(Integer seq);
	
	@Select ("select * from qna where qa_num=#{seq}")
	public AdminQnaCommand selectQna(Integer seq);

	@Update("update qna set qa_answer=1 where qa_num=#{seq}")
	public void updateQnaAnswer(Integer seq);
	
	@Select("select * from qna_log")
	public List<AdminQnaLogCommand> getAdminQna_LogList();
	
	@Insert("insert into qna_log (qa_log_num, qa_log_uid, qa_log_reg_date, qa_log_change, qa_log_message,qa_num) values (qa_log_seq.nextval, #{qa_log_uid}, sysdate, #{qa_log_change}, #{qa_log_message},#{qa_num})")
	public void insertAdminQna_Log(AdminQnaLogCommand adminQnaLogCommand);
	
	@Select("select * from user_menu_log where umenu_name=5")
	public List<UserMenuLogCommand> getUserQna_LogList();
}

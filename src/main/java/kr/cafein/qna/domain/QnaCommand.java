package kr.cafein.qna.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
  
public class QnaCommand {
	
	private int num;
	private String email;
	private String title;
	private String content;
	private String password;
	private Date reg_date;
	private int inline;
	private int qa_answer;
	
	public int getQa_answer() {
		return qa_answer;
	}
	public void setQa_answer(int qa_answer) {
		this.qa_answer = qa_answer;
	}
	public int getInline() {
		return inline;
	}
	public void setInline(int inline) {
		this.inline = inline;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}

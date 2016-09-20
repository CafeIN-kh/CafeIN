package kr.cafein.admin.qna.domain;

import java.sql.Date;

public class QnaCommand {
	private int qa_num;
	private String qa_email;
	private String qa_title;
	private String qa_content;
	private String qa_password;
	private Date qa_reg_date;
	private int qa_f_option;

	
	public int getQa_answer() {
		return qa_answer;
	}
	public void setQa_answer(int qa_answer) {
		this.qa_answer = qa_answer;
	}

	private int qa_answer;
	
	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	public String getQa_email() {
		return qa_email;
	}
	public void setQa_email(String qa_email) {
		this.qa_email = qa_email;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getQa_password() {
		return qa_password;
	}
	public void setQa_password(String qa_password) {
		this.qa_password = qa_password;
	}
	public Date getQa_reg_date() {
		return qa_reg_date;
	}
	public void setQa_reg_date(Date qa_reg_date) {
		this.qa_reg_date = qa_reg_date;
	}
	public int getQa_f_option() {
		return qa_f_option;
	}
	public void setQa_f_option(int qa_f_option) {
		this.qa_f_option = qa_f_option;
	}
	
	@Override
	public String toString() {
		return "QnaCommand [qa_num=" + qa_num + ", qa_email=" + qa_email + ", qa_title=" + qa_title + ", qa_content="
				+ qa_content + ", qa_password=" + qa_password + ", qa_reg_date=" + qa_reg_date + ", qa_f_option="
				+ qa_f_option + ", qa_answer=" + qa_answer + "]";
	}
	
	
	

}

package kr.cafein.admin.qna.domain;

import java.sql.Date;

public class AdminQnaLogCommand {
	
	private int qa_log_num;
	private String qa_log_uid;
	private Date qa_log_reg_date;
	private int qa_log_change;
	private String qa_log_message;
	private int qa_num;
	private String qa_email;
	
	public String getQa_email() {
		return qa_email;
	}
	public void setQa_email(String qa_email) {
		this.qa_email = qa_email;
	}
	public int getQa_log_num() {
		return qa_log_num;
	}
	public void setQa_log_num(int qa_log_num) {
		this.qa_log_num = qa_log_num;
	}
	public String getQa_log_uid() {
		return qa_log_uid;
	}
	public void setQa_log_uid(String qa_log_uid) {
		this.qa_log_uid = qa_log_uid;
	}
	public Date getQa_log_reg_date() {
		return qa_log_reg_date;
	}
	public void setQa_log_reg_date(Date qa_log_reg_date) {
		this.qa_log_reg_date = qa_log_reg_date;
	}
	public int getQa_log_change() {
		return qa_log_change;
	}
	public void setQa_log_change(int qa_log_change) {
		this.qa_log_change = qa_log_change;
	}
	public String getQa_log_message() {
		return qa_log_message;
	}
	public void setQa_log_message(String qa_log_message) {
		this.qa_log_message = qa_log_message;
	}
	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	@Override
	public String toString() {
		return "AdminQnaLogCommand [qa_log_num=" + qa_log_num + ", qa_log_uid=" + qa_log_uid + ", qa_log_reg_date="
				+ qa_log_reg_date + ", qa_log_change=" + qa_log_change + ", qa_log_message=" + qa_log_message
				+ ", qa_num=" + qa_num + "]";
	}
	
	

}

package kr.cafein.admin.notice.domain;

import java.sql.Date;

public class AdminNoticeLogCommand {
	
	private int n_log_num;
	private String n_log_uid;
	private Date n_log_reg_date;
	private int n_log_change;
	private String n_log_message;
	
	public int getN_log_num() {
		return n_log_num;
	}
	public void setN_log_num(int n_log_num) {
		this.n_log_num = n_log_num;
	}
	public String getN_log_uid() {
		return n_log_uid;
	}
	public void setN_log_uid(String n_log_uid) {
		this.n_log_uid = n_log_uid;
	}
	public Date getN_log_reg_date() {
		return n_log_reg_date;
	}
	public void setN_log_reg_date(Date n_log_reg_date) {
		this.n_log_reg_date = n_log_reg_date;
	}
	public int getN_log_change() {
		return n_log_change;
	}
	public void setN_log_change(int n_log_change) {
		this.n_log_change = n_log_change;
	}
	public String getN_log_message() {
		return n_log_message;
	}
	public void setN_log_message(String n_log_message) {
		this.n_log_message = n_log_message;
	}
	@Override
	public String toString() {
		return "AdminNoticeLogCommand [n_log_num=" + n_log_num + ", n_log_uid=" + n_log_uid + ", n_log_reg_date="
				+ n_log_reg_date + ", n_log_change=" + n_log_change + ", n_log_message=" + n_log_message + "]";
	}
	
	

}

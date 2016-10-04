package kr.cafein.admin.event.domain;

import java.sql.Date;

public class AdminEventLogCommand {
	
	private int e_log_num;
	private String e_log_uid;
	private Date e_log_reg_date;
	private int e_log_change;
	private String e_log_message;
	
	public int getE_log_num() {
		return e_log_num;
	}
	public void setE_log_num(int e_log_num) {
		this.e_log_num = e_log_num;
	}
	public String getE_log_uid() {
		return e_log_uid;
	}
	public void setE_log_uid(String e_log_uid) {
		this.e_log_uid = e_log_uid;
	}
	public Date getE_log_reg_date() {
		return e_log_reg_date;
	}
	public void setE_log_reg_date(Date e_log_reg_date) {
		this.e_log_reg_date = e_log_reg_date;
	}
	public int getE_log_change() {
		return e_log_change;
	}
	public void setE_log_change(int e_log_change) {
		this.e_log_change = e_log_change;
	}
	public String getE_log_message() {
		return e_log_message;
	}
	public void setE_log_message(String e_log_message) {
		this.e_log_message = e_log_message;
	}
	@Override
	public String toString() {
		return "AdminEventLogCommand [e_log_num=" + e_log_num + ", e_log_uid=" + e_log_uid + ", e_log_reg_date="
				+ e_log_reg_date + ", e_log_change=" + e_log_change + ", e_log_message=" + e_log_message + "]";
	}
	
	

}

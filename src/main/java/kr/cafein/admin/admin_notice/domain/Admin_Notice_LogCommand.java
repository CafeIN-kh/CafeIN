package kr.cafein.admin.admin_notice.domain;

import java.sql.Date;

public class Admin_Notice_LogCommand {
	private int an_log_num;
	private String an_log_uid;
	private Date an_log_reg_date;
	private int an_log_change;
	private String an_log_message;
	
	public int getAn_log_num() {
		return an_log_num;
	}
	public void setAn_log_num(int an_log_num) {
		this.an_log_num = an_log_num;
	}
	public String getAn_log_uid() {
		return an_log_uid;
	}
	public void setAn_log_uid(String an_log_uid) {
		this.an_log_uid = an_log_uid;
	}
	public Date getAn_log_reg_date() {
		return an_log_reg_date;
	}
	public void setAn_log_reg_date(Date an_log_reg_date) {
		this.an_log_reg_date = an_log_reg_date;
	}
	public int getAn_log_change() {
		return an_log_change;
	}
	public void setAn_log_change(int an_log_change) {
		this.an_log_change = an_log_change;
	}
	public String getAn_log_message() {
		return an_log_message;
	}
	public void setAn_log_message(String an_log_message) {
		this.an_log_message = an_log_message;
	}
	@Override
	public String toString() {
		return "Admin_Notice_LogCommand [an_log_num=" + an_log_num + ", an_log_uid=" + an_log_uid + ", an_log_reg_date="
				+ an_log_reg_date + ", an_log_change=" + an_log_change + ", an_log_message=" + an_log_message + "]";
	}
	
	
	

}

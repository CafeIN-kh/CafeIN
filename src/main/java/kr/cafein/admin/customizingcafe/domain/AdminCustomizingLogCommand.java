package kr.cafein.admin.customizingcafe.domain;

import java.sql.Date;

public class AdminCustomizingLogCommand {

	private int c_log_seq;
	private int custom_num;
	private String u_uid;
	private Date c_log_reg_date;
	private int c_log_change;
	private String c_log_message;
	
	public int getC_log_seq() {
		return c_log_seq;
	}
	public void setC_log_seq(int c_log_seq) {
		this.c_log_seq = c_log_seq;
	}
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public Date getC_log_reg_date() {
		return c_log_reg_date;
	}
	public void setC_log_reg_date(Date c_log_reg_date) {
		this.c_log_reg_date = c_log_reg_date;
	}
	public int getC_log_change() {
		return c_log_change;
	}
	public void setC_log_change(int c_log_change) {
		this.c_log_change = c_log_change;
	}
	public String getC_log_message() {
		return c_log_message;
	}
	public void setC_log_message(String c_log_message) {
		this.c_log_message = c_log_message;
	}
	@Override
	public String toString() {
		return "AdminCustomizingLogCommand [c_log_seq=" + c_log_seq + ", custom_num=" + custom_num + ", u_uid=" + u_uid
				+ ", c_log_reg_date=" + c_log_reg_date + ", c_log_change=" + c_log_change + ", c_log_message="
				+ c_log_message + "]";
	}
	
	
	
}

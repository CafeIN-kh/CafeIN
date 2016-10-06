package kr.cafein.admin.privatecafe.domain;

import java.sql.Date;

public class PrivateLogCommand {


	private int p_log_seq;
	private int pcafe_num;
	private String u_uid;
	private Date p_log_reg_date;
	private int p_log_change;
	private String p_log_message;
	
	
	public int getP_log_seq() {
		return p_log_seq;
	}
	public void setP_log_seq(int p_log_seq) {
		this.p_log_seq = p_log_seq;
	}
	public int getPcafe_num() {
		return pcafe_num;
	}
	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public Date getP_log_reg_date() {
		return p_log_reg_date;
	}
	public void setP_log_reg_date(Date p_log_reg_date) {
		this.p_log_reg_date = p_log_reg_date;
	}
	public int getP_log_change() {
		return p_log_change;
	}
	public void setP_log_change(int p_log_change) {
		this.p_log_change = p_log_change;
	}
	public String getP_log_message() {
		return p_log_message;
	}
	public void setP_log_message(String p_log_message) {
		this.p_log_message = p_log_message;
	}
	
	
	@Override
	public String toString() {
		return "PrivateLogCommand [p_log_seq=" + p_log_seq + ", pcafe_num=" + pcafe_num + ", u_uid=" + u_uid
				+ ", p_log_reg_date=" + p_log_reg_date + ", p_log_change=" + p_log_change + ", p_log_message="
				+ p_log_message + "]";
	}
}

package kr.cafein.domain;

import java.sql.Date;

public class UserMenuLogCommand {

	private int umenu_log_seq;
	private Date umenu_log_reg_date;
	//���� u_uid
	private String umenu_log_u_uid;
	//umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
	private int umenu_name;
	//umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
	private int umenu_log_state;
	//��µ� �α� �޽���
	private String umenu_log_message;
	
	public int getUmenu_log_seq() {
		return umenu_log_seq;
	}
	public void setUmenu_log_seq(int umenu_log_seq) {
		this.umenu_log_seq = umenu_log_seq;
	}
	public Date getUmenu_log_reg_date() {
		return umenu_log_reg_date;
	}
	public void setUmenu_log_reg_date(Date umenu_log_reg_date) {
		this.umenu_log_reg_date = umenu_log_reg_date;
	}
	public String getUmenu_log_u_uid() {
		return umenu_log_u_uid;
	}
	public void setUmenu_log_u_uid(String umenu_log_u_uid) {
		this.umenu_log_u_uid = umenu_log_u_uid;
	}
	public int getUmenu_name() {
		return umenu_name;
	}
	public void setUmenu_name(int umenu_name) {
		this.umenu_name = umenu_name;
	}
	public int getUmenu_log_state() {
		return umenu_log_state;
	}
	public void setUmenu_log_state(int umenu_log_state) {
		this.umenu_log_state = umenu_log_state;
	}
	public String getUmenu_log_message() {
		return umenu_log_message;
	}
	public void setUmenu_log_message(String umenu_log_message) {
		this.umenu_log_message = umenu_log_message;
	}
	@Override
	public String toString() {
		return "UserMenuLogCommand [umenu_log_seq=" + umenu_log_seq + ", umenu_log_reg_date=" + umenu_log_reg_date
				+ ", umenu_log_u_uid=" + umenu_log_u_uid + ", umenu_name=" + umenu_name + ", umenu_log_state="
				+ umenu_log_state + ", umenu_log_message=" + umenu_log_message + "]";
	}
}

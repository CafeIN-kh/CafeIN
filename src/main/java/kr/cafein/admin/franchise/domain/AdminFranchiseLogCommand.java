package kr.cafein.admin.franchise.domain;

import java.sql.Date;

public class AdminFranchiseLogCommand {

	private int franchise_log_seq;
	private int franchise_num_log;
	private String u_uid;
	private Date franchise_reg_date_log;
	private int franchise_change_log;
	private String franchise_admin_log;
	private String franchise_message_log;
	
	public int getFranchise_log_seq() {
		return franchise_log_seq;
	}
	public void setFranchise_log_seq(int franchise_log_seq) {
		this.franchise_log_seq = franchise_log_seq;
	}
	public int getFranchise_num_log() {
		return franchise_num_log;
	}
	public void setFranchise_num_log(int franchise_num_log) {
		this.franchise_num_log = franchise_num_log;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public Date getFranchise_reg_date_log() {
		return franchise_reg_date_log;
	}
	public void setFranchise_reg_date_log(Date franchise_reg_date_log) {
		this.franchise_reg_date_log = franchise_reg_date_log;
	}
	public int getFranchise_change_log() {
		return franchise_change_log;
	}
	public void setFranchise_change_log(int franchise_change_log) {
		this.franchise_change_log = franchise_change_log;
	}
	public String getFranchise_admin_log() {
		return franchise_admin_log;
	}
	public void setFranchise_admin_log(String franchise_admin_log) {
		this.franchise_admin_log = franchise_admin_log;
	}
	public String getFranchise_message_log() {
		return franchise_message_log;
	}
	public void setFranchise_message_log(String franchise_message_log) {
		this.franchise_message_log = franchise_message_log;
	}
	
	
}

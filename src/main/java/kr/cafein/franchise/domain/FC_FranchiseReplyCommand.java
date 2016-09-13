package kr.cafein.franchise.domain;

import java.sql.Date;

public class FC_FranchiseReplyCommand {
	private int freply_num;
	private int franchise_num;
	private String u_uid;
	private String freply_content;
	private String freply_nickname;
	private Date freply_reg_date;
	public int getFreply_num() {
		return freply_num;
	}
	public void setFreply_num(int freply_num) {
		this.freply_num = freply_num;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public String getFreply_content() {
		return freply_content;
	}
	public void setFreply_content(String freply_content) {
		this.freply_content = freply_content;
	}
	public String getFreply_nickname() {
		return freply_nickname;
	}
	public void setFreply_nickname(String freply_nickname) {
		this.freply_nickname = freply_nickname;
	}
	public Date getFreply_reg_date() {
		return freply_reg_date;
	}
	public void setFreply_reg_date(Date freply_reg_date) {
		this.freply_reg_date = freply_reg_date;
	}
	@Override
	public String toString() {
		return "FranchiseReplyCommand [freply_num=" + freply_num + ", franchise_num=" + franchise_num + ", u_uid="
				+ u_uid + ", freply_content=" + freply_content + ", freply_nickname=" + freply_nickname
				+ ", freply_reg_date=" + freply_reg_date + "]";
	}
	
}

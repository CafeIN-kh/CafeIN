package kr.cafein.franchise.domain;

import java.sql.Date;

public class FC_FranchiseLikeCommand {
	private int like_num;
	private String u_uid;
	private int franchise_num;
	private Date like_reg_date;
	public int getLike_num() {
		return like_num;
	}
	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	public Date getLike_reg_date() {
		return like_reg_date;
	}
	public void setLike_reg_date(Date like_reg_date) {
		this.like_reg_date = like_reg_date;
	}
	@Override
	public String toString() {
		return "FC_FranchiseLikeCommand [like_num=" + like_num + ", u_uid=" + u_uid + ", franchise_num=" + franchise_num
				+ ", like_reg_date=" + like_reg_date + "]";
	}
	
	
}

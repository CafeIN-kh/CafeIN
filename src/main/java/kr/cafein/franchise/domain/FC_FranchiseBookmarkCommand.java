package kr.cafein.franchise.domain;

import java.sql.Date;

public class FC_FranchiseBookmarkCommand {
	private int bookmark_num;
	private String u_uid;
	private int franchise_num;
	private Date bookmark_reg_date;
	
	public int getBookmark_num() {
		return bookmark_num;
	}
	public void setBookmark_num(int bookmark_num) {
		this.bookmark_num = bookmark_num;
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
	public Date getBookmark_reg_date() {
		return bookmark_reg_date;
	}
	public void setBookmark_reg_date(Date bookmark_reg_date) {
		this.bookmark_reg_date = bookmark_reg_date;
	}
	@Override
	public String toString() {
		return "FC_FranchiseBookmarkCommand [bookmark_num=" + bookmark_num + ", u_uid=" + u_uid + ", franchise_num="
				+ franchise_num + ", bookmark_reg_date=" + bookmark_reg_date + "]";
	}
	
}

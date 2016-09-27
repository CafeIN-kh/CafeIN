package kr.cafein.domain;

import java.sql.Date;

public class BookmarkCommand {

	private int bookmark_num;
	private String u_uid;
	private int franchise_num;
	private int pcafe_num;
	public Date getBoorkmark_reg_date() {
		return boorkmark_reg_date;
	}
	public void setBoorkmark_reg_date(Date boorkmark_reg_date) {
		this.boorkmark_reg_date = boorkmark_reg_date;
	}

	private int custom_num;
	private Date boorkmark_reg_date;
	
	
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
	public int getPcafe_num() {
		return pcafe_num;
	}
	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	
	@Override
	public String toString() {
		return "BookmarkCommand [bookmark_num=" + bookmark_num + ", u_uid=" + u_uid + ", franchise_num=" + franchise_num
				+ ", pcafe_num=" + pcafe_num + ", custom_num=" + custom_num + "]";
	}
}

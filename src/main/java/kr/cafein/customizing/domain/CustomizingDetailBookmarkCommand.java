package kr.cafein.customizing.domain;

import java.sql.Date;

public class CustomizingDetailBookmarkCommand {
	private int bookmark_num;
	private String u_uid;
	private int custom_num;
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
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	public Date getBookmark_reg_date() {
		return bookmark_reg_date;
	}
	public void setBookmark_reg_date(Date bookmark_reg_date) {
		this.bookmark_reg_date = bookmark_reg_date;
	}
	
	@Override
	public String toString() {
		return "CustomizingDetailBookmarkCommand [bookmark_num=" + bookmark_num + ", u_uid=" + u_uid + ", custom_num="
				+ custom_num + ", bookmark_reg_date=" + bookmark_reg_date + "]";
	}
	
}

package kr.cafein.customizing.domain;

import java.sql.Date;

public class CustomizingDetailReplyCommand {
	private int creply_num;
	private int custom_num;
	private String u_uid;
	private String creply_content;
	private String creply_nickname;
	private Date creply_reg_date;
	
	public int getCreply_num() {
		return creply_num;
	}
	public void setCreply_num(int creply_num) {
		this.creply_num = creply_num;
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
	public String getCreply_content() {
		return creply_content;
	}
	public void setCreply_content(String creply_content) {
		this.creply_content = creply_content;
	}
	public String getCreply_nickname() {
		return creply_nickname;
	}
	public void setCreply_nickname(String creply_nickname) {
		this.creply_nickname = creply_nickname;
	}
	public Date getCreply_reg_date() {
		return creply_reg_date;
	}
	public void setCreply_reg_date(Date creply_reg_date) {
		this.creply_reg_date = creply_reg_date;
	}
	
	@Override
	public String toString() {
		return "CustomizingDetailReplyCommand [creply_num=" + creply_num + ", custom_num=" + custom_num + ", u_uid="
				+ u_uid + ", creply_content=" + creply_content + ", creply_nickname=" + creply_nickname
				+ ", creply_reg_date=" + creply_reg_date + "]";
	}
}

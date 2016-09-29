package kr.cafein.admin.customizingcafe.domain;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
  
public class AdminCustomizingReplyCommand {

	@NotNull
	private int creply_num;
	@NotNull
	private int u_uid;
	@NotNull
	private int custom_num;
	
	@NotEmpty
	private String creply_content;
	private int creply_nickname;
	private Date reg_date;
	private MultipartFile upload;
	public int getCreply_num() {
		return creply_num;
	}
	public void setCreply_num(int creply_num) {
		this.creply_num = creply_num;
	}
	public int getU_uid() {
		return u_uid;
	}
	public void setU_uid(int u_uid) {
		this.u_uid = u_uid;
	}
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	public String getCreply_content() {
		return creply_content;
	}
	public void setCreply_content(String creply_content) {
		this.creply_content = creply_content;
	}
	public int getCreply_nickname() {
		return creply_nickname;
	}
	public void setCreply_nickname(int creply_nickname) {
		this.creply_nickname = creply_nickname;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	@Override
	public String toString() {
		return "adminCustomizingReplyCommand [creply_num=" + creply_num + ", u_uid=" + u_uid + ", custom_num="
				+ custom_num + ", creply_content=" + creply_content + ", creply_nickname=" + creply_nickname
				+ ", reg_date=" + reg_date + ", upload=" + upload + "]";
	}
	
	
	
	
	

}

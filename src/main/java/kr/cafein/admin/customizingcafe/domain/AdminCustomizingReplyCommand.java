package kr.cafein.admin.customizingcafe.domain;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
  
public class AdminCustomizingReplyCommand {

	@NotNull
	private int creply_num;
	@NotNull
	private String u_uid;
	@NotNull
	private int custom_num;
	
	public Date getCreply_reg_date() {
		return creply_reg_date;
	}
	public void setCreply_reg_date(Date creply_reg_date) {
		this.creply_reg_date = creply_reg_date;
	}
	@NotEmpty
	private String creply_content;
	private String creply_nickname;
	private Date creply_reg_date;
	private MultipartFile upload;
	public int getCreply_num() {
		return creply_num;
	}
	public void setCreply_num(int creply_num) {
		this.creply_num = creply_num;
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
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	@Override
	public String toString() {
		return "AdminCustomizingReplyCommand [creply_num=" + creply_num + ", u_uid=" + u_uid + ", custom_num="
				+ custom_num + ", creply_content=" + creply_content + ", creply_nickname=" + creply_nickname
				+ ", creply_reg_date=" + creply_reg_date + ", upload=" + upload + "]";
	}
	
	
	
	
	

}

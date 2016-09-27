package kr.cafein.admin.admin_notice.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Admin_NoticeCommand {
	private int admin_notice_num;
	@NotEmpty
	private String admin_notice_title;
	@NotEmpty
	private String admin_notice_content;
	private Date admin_notice_reg_date;
	private int admin_notice_hit;
	private String admin_notice_img;
	private MultipartFile upload;
	public int getAdmin_notice_num() {
		return admin_notice_num;
	}
	public void setAdmin_notice_num(int admin_notice_num) {
		this.admin_notice_num = admin_notice_num;
	}
	public String getAdmin_notice_title() {
		return admin_notice_title;
	}
	public void setAdmin_notice_title(String admin_notice_title) {
		this.admin_notice_title = admin_notice_title;
	}
	public String getAdmin_notice_content() {
		return admin_notice_content;
	}
	public void setAdmin_notice_content(String admin_notice_content) {
		this.admin_notice_content = admin_notice_content;
	}
	public Date getAdmin_notice_reg_date() {
		return admin_notice_reg_date;
	}
	public void setAdmin_notice_reg_date(Date admin_notice_reg_date) {
		this.admin_notice_reg_date = admin_notice_reg_date;
	}
	public int getAdmin_notice_hit() {
		return admin_notice_hit;
	}
	public void setAdmin_notice_hit(int admin_notice_hit) {
		this.admin_notice_hit = admin_notice_hit;
	}
	public String getAdmin_notice_img() {
		return admin_notice_img;
	}
	public void setAdmin_notice_img(String admin_notice_img) {
		this.admin_notice_img = admin_notice_img;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	@Override
	public String toString() {
		return "Admin_NoticeCommand [admin_notice_num=" + admin_notice_num + ", admin_notice_title="
				+ admin_notice_title + ", admin_notice_content=" + admin_notice_content + ", admin_notice_reg_date="
				+ admin_notice_reg_date + ", admin_notice_hit=" + admin_notice_hit + ", admin_notice_img="
				+ admin_notice_img + ", upload=" + upload + "]";
	}
	

}

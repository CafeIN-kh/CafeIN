package kr.cafein.admin.notice.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class AdminNoticeCommand {
	private int notice_num;
	@NotEmpty
	private String notice_title;
	@NotEmpty
	private String notice_content;
	private Date notice_reg_date;
	private int notice_hit;
	private String notice_img;
	private MultipartFile upload;
	private String notice_uid;
	
	public String getNotice_uid() {
		return notice_uid;
	}
	public void setNotice_uid(String notice_uid) {
		this.notice_uid = notice_uid;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_reg_date() {
		return notice_reg_date;
	}
	public void setNotice_reg_date(Date notice_reg_date) {
		this.notice_reg_date = notice_reg_date;
	}
	public int getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}
	public String getNotice_img() {
		return notice_img;
	}
	public void setNotice_img(String notice_img) {
		this.notice_img = notice_img;
	}
	@Override
	public String toString() {
		return "NoticeCommand [notice_num=" + notice_num + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_reg_date=" + notice_reg_date + ", notice_hit=" + notice_hit
				+ ", notice_img=" + notice_img + ", upload=" + upload + "]";
	}
	
	
	


}

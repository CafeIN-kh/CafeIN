package kr.cafein.admin.privatecafe.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class PrivateCommand {
	private int pcafe_num;
	private String pcafe_name;
	private String pcafe_address;
	private String pcafe_phone;
	private String pcafe_time;
	private String pcafe_url;
	private String pcafe_introduce;
	private String pcafe_hash_tag;
	private String pcafe_img;
	private int pcafe_visit;
	private MultipartFile upload;
	private Date pcafe_reg_date;
	public int getPcafe_num() {
		return pcafe_num;
	}
	
	
	public MultipartFile getUpload() {
		return upload;
	}


	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}


	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public String getPcafe_name() {
		return pcafe_name;
	}
	public void setPcafe_name(String pcafe_name) {
		this.pcafe_name = pcafe_name;
	}
	public String getPcafe_address() {
		return pcafe_address;
	}
	public void setPcafe_address(String pcafe_address) {
		this.pcafe_address = pcafe_address;
	}
	public String getPcafe_phone() {
		return pcafe_phone;
	}
	public void setPcafe_phone(String pcafe_phone) {
		this.pcafe_phone = pcafe_phone;
	}
	public String getPcafe_time() {
		return pcafe_time;
	}
	public void setPcafe_time(String pcafe_time) {
		this.pcafe_time = pcafe_time;
	}
	public String getPcafe_url() {
		return pcafe_url;
	}
	public void setPcafe_url(String pcafe_url) {
		this.pcafe_url = pcafe_url;
	}
	public String getPcafe_introduce() {
		return pcafe_introduce;
	}
	public void setPcafe_introduce(String pcafe_introduce) {
		this.pcafe_introduce = pcafe_introduce;
	}
	public String getPcafe_hash_tag() {
		return pcafe_hash_tag;
	}
	public void setPcafe_hash_tag(String pcafe_hash_tag) {
		this.pcafe_hash_tag = pcafe_hash_tag;
	}
	public String getPcafe_img() {
		return pcafe_img;
	}
	public void setPcafe_img(String pcafe_img) {
		this.pcafe_img = pcafe_img;
	}
	public int getPcafe_visit() {
		return pcafe_visit;
	}
	public void setPcafe_visit(int pcafe_visit) {
		this.pcafe_visit = pcafe_visit;
	}
	public Date getPcafe_reg_date() {
		return pcafe_reg_date;
	}
	public void setPcafe_reg_date(Date pcafe_reg_date) {
		this.pcafe_reg_date = pcafe_reg_date;
	}
	@Override
	public String toString() {
		return "PrivateCommand [pcafe_num=" + pcafe_num + ", pcafe_name=" + pcafe_name + ", pcafe_address="
				+ pcafe_address + ", pcafe_phone=" + pcafe_phone + ", pcafe_time=" + pcafe_time + ", pcafe_url="
				+ pcafe_url + ", pcafe_introduce=" + pcafe_introduce + ", pcafe_hash_tag=" + pcafe_hash_tag
				+ ", pcafe_img=" + pcafe_img + ", pcafe_visit=" + pcafe_visit + ", pcafe_reg_date=" + pcafe_reg_date
				+ "]";
	}
	
	

}

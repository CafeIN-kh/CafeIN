package kr.cafein.admin.customizingcafe.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdminCustomizingDetailCommand {

	
	private int custom_num;

	private int franchise_num;

	private String u_uid;

	private String custom_name;
	private String custom_introduce;

	private String custom_recipe;

	private String custom_img;
	private String custom_hash_tag;
	private MultipartFile upload;
	private int custom_visit;

	private Date custom_reg_date;
	private String u_name;
	private String franchise_name;
	private int start;
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public String getCustom_introduce() {
		return custom_introduce;
	}
	public void setCustom_introduce(String custom_introduce) {
		this.custom_introduce = custom_introduce;
	}
	public String getCustom_recipe() {
		return custom_recipe;
	}
	public void setCustom_recipe(String custom_recipe) {
		this.custom_recipe = custom_recipe;
	}
	public String getCustom_img() {
		return custom_img;
	}
	public void setCustom_img(String custom_img) {
		this.custom_img = custom_img;
	}
	public String getCustom_hash_tag() {
		return custom_hash_tag;
	}
	public void setCustom_hash_tag(String custom_hash_tag) {
		this.custom_hash_tag = custom_hash_tag;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public int getCustom_visit() {
		return custom_visit;
	}
	public void setCustom_visit(int custom_visit) {
		this.custom_visit = custom_visit;
	}
	public Date getCustom_reg_date() {
		return custom_reg_date;
	}
	public void setCustom_reg_date(Date custom_reg_date) {
		this.custom_reg_date = custom_reg_date;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getFranchise_name() {
		return franchise_name;
	}
	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "AdminCustomizingDetailCommand [custom_num=" + custom_num + ", franchise_num=" + franchise_num
				+ ", u_uid=" + u_uid + ", custom_name=" + custom_name + ", custom_introduce=" + custom_introduce
				+ ", custom_recipe=" + custom_recipe + ", custom_img=" + custom_img + ", custom_hash_tag="
				+ custom_hash_tag + ", upload=" + upload + ", custom_visit=" + custom_visit + ", custom_reg_date="
				+ custom_reg_date + ", u_name=" + u_name + ", franchise_name=" + franchise_name + ", start=" + start
				+ "]";
	}
	
	
	
	
}

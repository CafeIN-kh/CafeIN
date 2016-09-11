package kr.cafein.domain;

import org.springframework.web.multipart.MultipartFile;

public class PCafeMenuCommand {

	private int pmenu_num;
	private int pcafe_num;
	private String pmenu_name;
	private int pmenu_price;
	private String pmenu_introduce;
	private String pmenu_img;
	private MultipartFile upload_menu;
	
	public int getPmenu_price() {
		return pmenu_price;
	}
	public void setPmenu_price(int pmenu_price) {
		this.pmenu_price = pmenu_price;
	}
	public int getPmenu_num() {
		return pmenu_num;
	}
	public void setPmenu_num(int pmenu_num) {
		this.pmenu_num = pmenu_num;
	}
	public int getPcafe_num() {
		return pcafe_num;
	}
	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public String getPmenu_name() {
		return pmenu_name;
	}
	public void setPmenu_name(String pmenu_name) {
		this.pmenu_name = pmenu_name;
	}
	public String getPmenu_introduce() {
		return pmenu_introduce;
	}
	public void setPmenu_introduce(String pmenu_introduce) {
		this.pmenu_introduce = pmenu_introduce;
	}
	public String getPmenu_img() {
		return pmenu_img;
	}
	public void setPmenu_img(String pmenu_img) {
		this.pmenu_img = pmenu_img;
	}
	public MultipartFile getUpload_menu() {
		return upload_menu;
	}
	public void setUpload_menu(MultipartFile upload_menu) {
		this.upload_menu = upload_menu;
	}
	
	@Override
	public String toString() {
		return "PCafeMenuCommand [pmenu_num=" + pmenu_num + ", pcafe_num=" + pcafe_num + ", pmenu_name=" + pmenu_name
				+ ", pmenu_price=" + pmenu_price + ", pmenu_introduce=" + pmenu_introduce + ", pmenu_img=" + pmenu_img
				+ ", upload_menu=" + upload_menu + "]";
	}
}

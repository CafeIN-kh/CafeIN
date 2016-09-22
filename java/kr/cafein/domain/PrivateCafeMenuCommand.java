package kr.cafein.domain;

import java.sql.Date;

public class PrivateCafeMenuCommand {
	
	private int pmenu_num;
	private int pcafe_num;
	private String pmenu_name;
	private String pmenu_img;
	private String pcafe_name;
	private Date pcafe_reg_date;
	private int pcount;
	
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
	public String getPmenu_img() {
		return pmenu_img;
	}
	public void setPmenu_img(String pmenu_img) {
		this.pmenu_img = pmenu_img;
	}
	public String getPcafe_name() {
		return pcafe_name;
	}
	public void setPcafe_name(String pcafe_name) {
		this.pcafe_name = pcafe_name;
	}
	public Date getPcafe_reg_date() {
		return pcafe_reg_date;
	}
	public void setPcafe_reg_date(Date pcafe_reg_date) {
		this.pcafe_reg_date = pcafe_reg_date;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	
	@Override
	public String toString() {
		return "PrivateCafeMenuCommand [pmenu_num=" + pmenu_num + ", pcafe_num=" + pcafe_num + ", pmenu_name="
				+ pmenu_name + ", pmenu_img=" + pmenu_img + ", pcafe_name=" + pcafe_name + ", pcafe_reg_date="
				+ pcafe_reg_date + ", pcount=" + pcount + "]";
	}
}

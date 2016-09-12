package kr.cafein.domain;

import java.sql.Date;

public class PrivateCafeCommand {
	
	private int pcafe_num;
	private String pcafe_name;
	private String pcafe_introduce;
	private Date pcafe_reg_date;
	private String pcafe_img;
	private int count;
	
	public int getPcafe_num() {
		return pcafe_num;
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
	public String getPcafe_introduce() {
		return pcafe_introduce;
	}
	public void setPcafe_introduce(String pcafe_introduce) {
		this.pcafe_introduce = pcafe_introduce;
	}
	public Date getPcafe_reg_date() {
		return pcafe_reg_date;
	}
	public void setPcafe_reg_date(Date pcafe_reg_date) {
		this.pcafe_reg_date = pcafe_reg_date;
	}
	public String getPcafe_img() {
		return pcafe_img;
	}
	public void setPcafe_img(String pcafe_img) {
		this.pcafe_img = pcafe_img;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "PrivateCafeCommand [pcafe_num=" + pcafe_num + ", pcafe_name=" + pcafe_name + ", pcafe_introduce="
				+ pcafe_introduce + ", pcafe_reg_date=" + pcafe_reg_date + ", pcafe_img=" + pcafe_img + ", count="
				+ count + "]";
	}
	

	
}

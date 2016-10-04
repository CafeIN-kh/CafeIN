package kr.cafein.admin.customizingcafe.domain;

import java.sql.Date;

public class AdminCustomizingListCommand {
	private int custom_num;
	private String franchise_name;
	private String custom_name;
	private Date custom_reg_date;
	private int custom_visit;
	
	
	
	public int getCustom_num() {
		return custom_num;
	}


	


	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}


	public String getFranchise_name() {
		return franchise_name;
	}


	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}


	public String getCustom_name() {
		return custom_name;
	}


	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}


	public Date getCustom_reg_date() {
		return custom_reg_date;
	}


	public void setCustom_reg_date(Date custom_reg_date) {
		this.custom_reg_date = custom_reg_date;
	}


	public int getCustom_visit() {
		return custom_visit;
	}


	public void setCustom_visit(int custom_visit) {
		this.custom_visit = custom_visit;
	}


	@Override
	public String toString() {
		return "AdminCustomizingListCommand [custom_num=" + custom_num + ", franchise_name=" + franchise_name
				+ ", custom_name=" + custom_name + ", custom_reg_date=" + custom_reg_date + ", custom_visit="
				+ custom_visit + ", franchise_num="  + "]";
	}


	
}

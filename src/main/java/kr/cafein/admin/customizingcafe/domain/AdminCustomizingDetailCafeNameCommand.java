package kr.cafein.admin.customizingcafe.domain;

public class AdminCustomizingDetailCafeNameCommand {
	
	private String franchise_name;
	private int franchise_num;
	@Override
	public String toString() {
		return "AdminCustomizingDetailCafeNameCommand [franchise_name=" + franchise_name + ", franchise_num="
				+ franchise_num + "]";
	}
	public String getFranchise_name() {
		return franchise_name;
	}
	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	
}

package kr.cafein.domain;

public class FranchiseMenuCommand {
	
	private int fmenu_num;
	private int franchise_num;
	private String fmenu_name;
	private String fmenu_img;
	private String franchise_name;
	private int fcount;
	
	public int getFmenu_num() {
		return fmenu_num;
	}
	public void setFmenu_num(int fmenu_num) {
		this.fmenu_num = fmenu_num;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	public String getFmenu_name() {
		return fmenu_name;
	}
	public void setFmenu_name(String fmenu_name) {
		this.fmenu_name = fmenu_name;
	}
	public String getFmenu_img() {
		return fmenu_img;
	}
	public void setFmenu_img(String fmenu_img) {
		this.fmenu_img = fmenu_img;
	}
	public String getFranchise_name() {
		return franchise_name;
	}
	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}
	public int getFcount() {
		return fcount;
	}
	public void setFcount(int fcount) {
		this.fcount = fcount;
	}
	
	@Override
	public String toString() {
		return "FranchiseMenuCommand [fmenu_num=" + fmenu_num + ", franchise_num=" + franchise_num + ", fmenu_name="
				+ fmenu_name + ", fmenu_img=" + fmenu_img + ", franchise_name=" + franchise_name + ", fcount=" + fcount + "]";
	}
}

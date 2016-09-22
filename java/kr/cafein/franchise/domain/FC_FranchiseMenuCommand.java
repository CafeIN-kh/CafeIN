package kr.cafein.franchise.domain;

public class FC_FranchiseMenuCommand {
	private int fmenu_num;
	private int franchise_num;
	private String fmenu_name;
	private	int fmenu_price;
	private String fmenu_img;
	private String fmenu_introduce;
	
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
	public int getFmenu_price() {
		return fmenu_price;
	}
	public void setFmenu_price(int fmenu_price) {
		this.fmenu_price = fmenu_price;
	}
	public String getFmenu_img() {
		return fmenu_img;
	}
	public void setFmenu_img(String fmenu_img) {
		this.fmenu_img = fmenu_img;
	}
	public String getFmenu_introduce() {
		return fmenu_introduce;
	}
	public void setFmenu_introduce(String fmenu_introduce) {
		this.fmenu_introduce = fmenu_introduce;
	}
	@Override
	public String toString() {
		return "FranchiseMenuCommand [fmenu_num=" + fmenu_num + ", franchise_num=" + franchise_num + ", fmenu_name="
				+ fmenu_name + ", fmenu_price=" + fmenu_price + ", fmenu_img=" + fmenu_img + ", fmenu_introduce="
				+ fmenu_introduce + "]";
	}
}

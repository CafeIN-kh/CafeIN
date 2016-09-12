package kr.cafein.domain;

public class MainBookmarkCommand {
	
	//private int bookmark_num;
	//private String u_uid;
	private int franchise_num;
	private int pcafe_num;
	private int custom_num;
	private int count;
	
	
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	public int getPcafe_num() {
		return pcafe_num;
	}
	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "BookmarkCommand [franchise_num=" + franchise_num + ", pcafe_num=" + pcafe_num + ", custom_num="
				+ custom_num + ", count=" + count + "]";
	}
	
	
}

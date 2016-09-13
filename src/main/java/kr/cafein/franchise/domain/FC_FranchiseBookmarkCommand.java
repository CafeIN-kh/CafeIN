package kr.cafein.franchise.domain;

public class FC_FranchiseBookmarkCommand {
	private int bookmark_num;
	private String u_uid;
	private int franchise_num;
	
	public int getBookmark_num() {
		return bookmark_num;
	}
	public void setBookmark_num(int bookmark_num) {
		this.bookmark_num = bookmark_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public int getFranchise_num() {
		return franchise_num;
	}
	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}
	@Override
	public String toString() {
		return "FranchiseBookmarkCommand [bookmark_num=" + bookmark_num + ", u_uid=" + u_uid + ", franchise_num="
				+ franchise_num + "]";
	}
}

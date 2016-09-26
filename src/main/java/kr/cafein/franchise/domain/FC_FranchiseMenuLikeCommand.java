package kr.cafein.franchise.domain;

public class FC_FranchiseMenuLikeCommand {
	private int like_num;
	private String u_uid;
	private int fmenu_num;
	
	public int getLike_num() {
		return like_num;
	}
	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public int getFmenu_num() {
		return fmenu_num;
	}
	public void setFmenu_num(int fmenu_num) {
		this.fmenu_num = fmenu_num;
	}
	@Override
	public String toString() {
		return "FC_FranchiseMenuLikeCommand [like_num=" + like_num + ", u_uid=" + u_uid + ", fmenu_num=" + fmenu_num
				+ "]";
	}
}

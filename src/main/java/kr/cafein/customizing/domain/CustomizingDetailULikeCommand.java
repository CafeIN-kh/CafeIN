package kr.cafein.customizing.domain;

public class CustomizingDetailULikeCommand {

	private int like_num;
	private String u_uid;
	private int custom_num;
	
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
	public int getCustom_num() {
		return custom_num;
	}
	public void setCustom_num(int custom_num) {
		this.custom_num = custom_num;
	}
	@Override
	public String toString() {
		return "CustomizingDetailULikeCommand [like_num=" + like_num + ", u_uid=" + u_uid + ", custom_num=" + custom_num
				+ "]";
	}

}

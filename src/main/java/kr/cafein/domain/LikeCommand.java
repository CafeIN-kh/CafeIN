package kr.cafein.domain;

import java.sql.Date;

public class LikeCommand {
	
	private int like_num;
	private String u_uid;
	private int franchise_num;
	private int pcafe_num;
	private int custom_num;
	private int fmenu_num;
	private int pmenu_num;
	private Date like_reg_date;
	
	public Date getLike_reg_date() {
		return like_reg_date;
	}
	public void setLike_reg_date(Date like_reg_date) {
		this.like_reg_date = like_reg_date;
	}
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
	public int getFmenu_num() {
		return fmenu_num;
	}
	public void setFmenu_num(int fmenu_num) {
		this.fmenu_num = fmenu_num;
	}
	public int getPmenu_num() {
		return pmenu_num;
	}
	public void setPmenu_num(int pmenu_num) {
		this.pmenu_num = pmenu_num;
	}
	
	@Override
	public String toString() {
		return "LikeCommand [like_num=" + like_num + ", u_uid=" + u_uid + ", franchise_num=" + franchise_num
				+ ", pcafe_num=" + pcafe_num + ", custom_num=" + custom_num + ", fmenu_num=" + fmenu_num
				+ ", pmenu_num=" + pmenu_num + "]";
	}
}

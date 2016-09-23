package kr.cafein.domain;

import java.sql.Date;

public class BookmarkAndMypageCommand {

	private int bookmark_num;
	private String u_uid;
	private int franchise_num;
	private int pcafe_num;
	private int custom_num;
	private Date bookmark_reg_date;	
	
	//개인카페 jsp에 뿌려줄 값
	private String pcafe_name;
	private String pcafe_img;
	
	//프렌차이즈 jsp에 뿌려줄 값
	private String franchise_name;
	private String franchise_img;
	
	//커스텀 jsp에 뿌려줄 값
	private int custom_fnum;	//위의 franchise_num과 이름 같아져서 sql에서 이름 custom_fnum으로 변경해줌
	private String custom_name;	
	private String custom_introduce;
	private String custom_img;
	
	public String getCustom_introduce() {
		return custom_introduce;
	}
	public void setCustom_introduce(String custom_introduce) {
		this.custom_introduce = custom_introduce;
	}
	public int getCustom_fnum() {
		return custom_fnum;
	}
	public void setCustom_fnum(int custom_fnum) {
		this.custom_fnum = custom_fnum;
	}
	public String getCustom_name() {
		return custom_name;
	}
	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}
	public String getCustom_img() {
		return custom_img;
	}
	public void setCustom_img(String custom_img) {
		this.custom_img = custom_img;
	}
	public String getFranchise_name() {
		return franchise_name;
	}
	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}
	public String getFranchise_img() {
		return franchise_img;
	}
	public void setFranchise_img(String franchise_img) {
		this.franchise_img = franchise_img;
	}
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
	public String getPcafe_name() {
		return pcafe_name;
	}
	public void setPcafe_name(String pcafe_name) {
		this.pcafe_name = pcafe_name;
	}
	public String getPcafe_img() {
		return pcafe_img;
	}
	public void setPcafe_img(String pcafe_img) {
		this.pcafe_img = pcafe_img;
	}
	
	public Date getBookmark_reg_date() {
		return bookmark_reg_date;
	}
	public void setBookmark_reg_date(Date bookmark_reg_date) {
		this.bookmark_reg_date = bookmark_reg_date;
	}
	@Override
	public String toString() {
		return "BookmarkAndMypageCommand [bookmark_num=" + bookmark_num + ", u_uid=" + u_uid + ", franchise_num="
				+ franchise_num + ", pcafe_num=" + pcafe_num + ", custom_num=" + custom_num + ", bookmark_reg_date="
				+ bookmark_reg_date + ", pcafe_name=" + pcafe_name + ", pcafe_img=" + pcafe_img + ", franchise_name="
				+ franchise_name + ", franchise_img=" + franchise_img + ", custom_fnum=" + custom_fnum
				+ ", custom_name=" + custom_name + ", custom_introduce=" + custom_introduce + ", custom_img="
				+ custom_img + "]";
	}
}

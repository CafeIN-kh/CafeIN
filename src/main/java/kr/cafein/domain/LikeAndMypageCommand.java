package kr.cafein.domain;

import java.sql.Date;

public class LikeAndMypageCommand {
	
	private int like_num;
	private String u_uid;
	//카페
	private int franchise_num;
	private int pcafe_num;
	//메뉴
	private int custom_num;
	private int fmenu_num;
	private int pmenu_num;
	private Date like_reg_date;
	
	//카페 카테고리에 따라 jsp에 뿌려줄 값
	private String pcafe_name;
	private String pcafe_img;
	private String franchise_name;
	private String franchise_img;
	
	//카페메뉴 카테고리에 따라 jsp에 뿌려줄 값
	private int custom_fnum;	//위의 franchise_num과 이름 같아져서 sql에서 이름 custom_fnum으로 변경해줌
	private String custom_name;	
	private String custom_introduce;
	private String custom_img;
	private int pmenu_pnum;		//위의 pcafe_num과 이름 같아져서 sql에서 이름 pmenu_pnum으로 변경해줌
	private String pmenu_name;	
	private String pmenu_introduce;
	private String pmenu_img;
	private int fmenu_fnum;		//위의 franchise_num과 이름 같아져서 sql에서 이름 fmenu_fnum으로 변경해줌
	private String fmenu_name;	
	private String fmenu_introduce;
	private String fmenu_img;
	
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
	public Date getLike_reg_date() {
		return like_reg_date;
	}
	public void setLike_reg_date(Date like_reg_date) {
		this.like_reg_date = like_reg_date;
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
	public String getCustom_introduce() {
		return custom_introduce;
	}
	public void setCustom_introduce(String custom_introduce) {
		this.custom_introduce = custom_introduce;
	}
	public String getCustom_img() {
		return custom_img;
	}
	public void setCustom_img(String custom_img) {
		this.custom_img = custom_img;
	}
	public int getPmenu_pnum() {
		return pmenu_pnum;
	}
	public void setPmenu_pnum(int pmenu_pnum) {
		this.pmenu_pnum = pmenu_pnum;
	}
	public String getPmenu_name() {
		return pmenu_name;
	}
	public void setPmenu_name(String pmenu_name) {
		this.pmenu_name = pmenu_name;
	}
	public String getPmenu_introduce() {
		return pmenu_introduce;
	}
	public void setPmenu_introduce(String pmenu_introduce) {
		this.pmenu_introduce = pmenu_introduce;
	}
	public String getPmenu_img() {
		return pmenu_img;
	}
	public void setPmenu_img(String pmenu_img) {
		this.pmenu_img = pmenu_img;
	}
	public int getFmenu_fnum() {
		return fmenu_fnum;
	}
	public void setFmenu_fnum(int fmenu_fnum) {
		this.fmenu_fnum = fmenu_fnum;
	}
	public String getFmenu_name() {
		return fmenu_name;
	}
	public void setFmenu_name(String fmenu_name) {
		this.fmenu_name = fmenu_name;
	}
	public String getFmenu_introduce() {
		return fmenu_introduce;
	}
	public void setFmenu_introduce(String fmenu_introduce) {
		this.fmenu_introduce = fmenu_introduce;
	}
	public String getFmenu_img() {
		return fmenu_img;
	}
	public void setFmenu_img(String fmenu_img) {
		this.fmenu_img = fmenu_img;
	}
	@Override
	public String toString() {
		return "LikeAndMypageCommand [like_num=" + like_num + ", u_uid=" + u_uid + ", franchise_num=" + franchise_num
				+ ", pcafe_num=" + pcafe_num + ", custom_num=" + custom_num + ", fmenu_num=" + fmenu_num
				+ ", pmenu_num=" + pmenu_num + ", like_reg_date=" + like_reg_date + ", pcafe_name=" + pcafe_name
				+ ", pcafe_img=" + pcafe_img + ", franchise_name=" + franchise_name + ", franchise_img=" + franchise_img
				+ ", custom_fnum=" + custom_fnum + ", custom_name=" + custom_name + ", custom_introduce="
				+ custom_introduce + ", custom_img=" + custom_img + ", pmenu_pnum=" + pmenu_pnum + ", pmenu_name="
				+ pmenu_name + ", pmenu_introduce=" + pmenu_introduce + ", pmenu_img=" + pmenu_img + ", fmenu_fnum="
				+ fmenu_fnum + ", fmenu_name=" + fmenu_name + ", fmenu_introduce=" + fmenu_introduce + ", fmenu_img="
				+ fmenu_img + "]";
	}
}

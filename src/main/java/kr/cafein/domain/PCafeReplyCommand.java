package kr.cafein.domain;

import java.sql.Date;

public class PCafeReplyCommand {

	private int preply_num;
	private int pcafe_num;
	private String u_uid;
	private String preply_content;
	private String preply_nickname;
	private Date preply_reg_date;
	
	public int getPreply_num() {
		return preply_num;
	}
	public void setPreply_num(int preply_num) {
		this.preply_num = preply_num;
	}
	public int getPcafe_num() {
		return pcafe_num;
	}
	public void setPcafe_num(int pcafe_num) {
		this.pcafe_num = pcafe_num;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public String getPreply_content() {
		return preply_content;
	}
	public void setPreply_content(String preply_content) {
		this.preply_content = preply_content;
	}
	public String getPreply_nickname() {
		return preply_nickname;
	}
	public void setPreply_nickname(String preply_nickname) {
		this.preply_nickname = preply_nickname;
	}
	
	public Date getPreply_reg_date() {
		return preply_reg_date;
	}
	public void setPreply_reg_date(Date preply_reg_date) {
		this.preply_reg_date = preply_reg_date;
	}
	/*public String getPreply_reg_date() {
		return preply_reg_date;
	}
	public void setPreply_reg_date(String preply_reg_date) {
		this.preply_reg_date = DurationFromNow.getTimeDiffLabel(preply_reg_date);
	}*/
	@Override
	public String toString() {
		return "PCafeReplyCommand [preply_num=" + preply_num + ", pcafe_num=" + pcafe_num + ", u_uid=" + u_uid
				+ ", preply_content=" + preply_content + ", preply_nickname=" + preply_nickname + ", preply_reg_date="
				+ preply_reg_date + "]";
	}
}

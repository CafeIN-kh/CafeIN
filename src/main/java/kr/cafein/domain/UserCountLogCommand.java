package kr.cafein.domain;

import java.util.Date;

public class UserCountLogCommand {

	private int ucnt_log_seq;
	private Date ucnt_log_reg_date;
	//sysdate 저장할때 to_char(sysdate,'yyyy-mm-dd')형태로 바꿔서 db에 넣어주므로 string 형태임.
	//private String ucnt_log_reg_date;	
	private int ucnt_total;
	private int ucnt_log_main;
	private int ucnt_log_franchise;
	private int ucnt_log_private;
	private int ucnt_log_custom;
	private int ucnt_log_qna;
	private int ucnt_log_notice;
	
	//현재 날짜와 db의 ucnt_log_reg_date와 비교할 변수
	//private Date today_reg_date;
	
	public int getUcnt_log_seq() {
		return ucnt_log_seq;
	}
	public Date getUcnt_log_reg_date() {
		return ucnt_log_reg_date;
	}
	public void setUcnt_log_reg_date(Date ucnt_log_reg_date) {
		this.ucnt_log_reg_date = ucnt_log_reg_date;
	}
	public void setUcnt_log_seq(int ucnt_log_seq) {
		this.ucnt_log_seq = ucnt_log_seq;
	}
	public int getUcnt_total() {
		return ucnt_total;
	}
	public void setUcnt_total(int ucnt_total) {
		this.ucnt_total = ucnt_total;
	}
	public int getUcnt_log_main() {
		return ucnt_log_main;
	}
	public void setUcnt_log_main(int ucnt_log_main) {
		this.ucnt_log_main = ucnt_log_main;
	}
	public int getUcnt_log_franchise() {
		return ucnt_log_franchise;
	}
	public void setUcnt_log_franchise(int ucnt_log_franchise) {
		this.ucnt_log_franchise = ucnt_log_franchise;
	}
	public int getUcnt_log_private() {
		return ucnt_log_private;
	}
	public void setUcnt_log_private(int ucnt_log_private) {
		this.ucnt_log_private = ucnt_log_private;
	}
	public int getUcnt_log_custom() {
		return ucnt_log_custom;
	}
	public void setUcnt_log_custom(int ucnt_log_custom) {
		this.ucnt_log_custom = ucnt_log_custom;
	}
	public int getUcnt_log_qna() {
		return ucnt_log_qna;
	}
	public void setUcnt_log_qna(int ucnt_log_qna) {
		this.ucnt_log_qna = ucnt_log_qna;
	}
	public int getUcnt_log_notice() {
		return ucnt_log_notice;
	}
	public void setUcnt_log_notice(int ucnt_log_notice) {
		this.ucnt_log_notice = ucnt_log_notice;
	}
	@Override
	public String toString() {
		return "UserCountLogCommand [ucnt_log_seq=" + ucnt_log_seq + ", ucnt_log_reg_date=" + ucnt_log_reg_date
				+ ", ucnt_total=" + ucnt_total + ", ucnt_log_main=" + ucnt_log_main + ", ucnt_log_franchise="
				+ ucnt_log_franchise + ", ucnt_log_private=" + ucnt_log_private + ", ucnt_log_custom=" + ucnt_log_custom
				+ ", ucnt_log_qna=" + ucnt_log_qna + ", ucnt_log_notice=" + ucnt_log_notice + "]";
	}
	
}

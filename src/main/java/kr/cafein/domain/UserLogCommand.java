package kr.cafein.domain;

import java.sql.Date;

public class UserLogCommand {
	
	private int u_log_seq;
	private String u_uid;
	private Date u_log_reg_date;
	//현재 상태 : 0[회원가입] 1[로그인] 2[수정] 3[탈퇴]
	private int u_log_change;
	//출력될 로그 메시지
	//- 예시) [사용자이메일] 사용자가 로그인을 하였습니다.
	private String u_log_message;
	
	public int getU_log_seq() {
		return u_log_seq;
	}
	public void setU_log_seq(int u_log_seq) {
		this.u_log_seq = u_log_seq;
	}
	public String getU_uid() {
		return u_uid;
	}
	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}
	public Date getU_log_reg_date() {
		return u_log_reg_date;
	}
	public void setU_log_reg_date(Date u_log_reg_date) {
		this.u_log_reg_date = u_log_reg_date;
	}
	public int getU_log_change() {
		return u_log_change;
	}
	public void setU_log_change(int u_log_change) {
		this.u_log_change = u_log_change;
	}
	public String getU_log_message() {
		return u_log_message;
	}
	public void setU_log_message(String u_log_message) {
		this.u_log_message = u_log_message;
	}
}

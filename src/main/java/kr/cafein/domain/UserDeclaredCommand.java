package kr.cafein.domain;

import java.sql.Date;

public class UserDeclaredCommand {
	
	private int d_seq;
	//신고글 경로 0[프랜차이즈 댓글] 1[개인카페 댓글] 2[커스터마이징 댓글]
	private int d_target_path;
	//신고 대상(댓글)의 상위 경로 시퀀스(카페 시퀀스)
	private int d_target_num;
	//신고한 댓글의 시퀀스
	private int d_target_id;
	//신고를 한 회원 시퀀스
	private String d_mem_id;
	//신고 당한 회원 시퀀스
	private String d_target_mem_id;
	private Date d_reg_date;
	private String d_content;
	//d_state[처리상태] = 0.처리 전, 1.처리 중,2.처리 완료, 3처리 보류, 4. 처리 취소
	private int d_state;
	//출력할 내용
	private String d_comment;
	
	public int getD_seq() {
		return d_seq;
	}
	public void setD_seq(int d_seq) {
		this.d_seq = d_seq;
	}
	public int getD_target_path() {
		return d_target_path;
	}
	public void setD_target_path(int d_target_path) {
		this.d_target_path = d_target_path;
	}
	public int getD_target_num() {
		return d_target_num;
	}
	public void setD_target_num(int d_target_num) {
		this.d_target_num = d_target_num;
	}
	public int getD_target_id() {
		return d_target_id;
	}
	public void setD_target_id(int d_target_id) {
		this.d_target_id = d_target_id;
	}
	public String getD_mem_id() {
		return d_mem_id;
	}
	public void setD_mem_id(String d_mem_id) {
		this.d_mem_id = d_mem_id;
	}
	public String getD_target_mem_id() {
		return d_target_mem_id;
	}
	public void setD_target_mem_id(String d_target_mem_id) {
		this.d_target_mem_id = d_target_mem_id;
	}
	public Date getD_reg_date() {
		return d_reg_date;
	}
	public void setD_reg_date(Date d_reg_date) {
		this.d_reg_date = d_reg_date;
	}
	public String getD_content() {
		return d_content;
	}
	public void setD_content(String d_content) {
		this.d_content = d_content;
	}
	public int getD_state() {
		return d_state;
	}
	public void setD_state(int d_state) {
		this.d_state = d_state;
	}
	public String getD_comment() {
		return d_comment;
	}
	public void setD_comment(String d_comment) {
		this.d_comment = d_comment;
	}
	@Override
	public String toString() {
		return "UserDeclaredCommand [d_seq=" + d_seq + ", d_target_path=" + d_target_path + ", d_target_num="
				+ d_target_num + ", d_target_id=" + d_target_id + ", d_mem_id=" + d_mem_id + ", d_target_mem_id="
				+ d_target_mem_id + ", d_reg_date=" + d_reg_date + ", d_content=" + d_content + ", d_state=" + d_state
				+ ", d_comment=" + d_comment + "]";
	}
}

package kr.cafein.admin.qna.domain;

public class AdminQnaEmailCommand {
	private String q_em_email;
	private String q_em_subject;
	private String q_em_content;
	private int q_em_num;
	
	public int getQ_em_num() {
		return q_em_num;
	}
	public void setQ_em_num(int q_em_num) {
		this.q_em_num = q_em_num;
	}
	public String getQ_em_email() {
		return q_em_email;
	}
	public void setQ_em_email(String q_em_email) {
		this.q_em_email = q_em_email;
	}
	public String getQ_em_subject() {
		return q_em_subject;
	}
	public void setQ_em_subject(String q_em_subject) {
		this.q_em_subject = q_em_subject;
	}
	public String getQ_em_content() {
		return q_em_content;
	}
	public void setQ_em_content(String q_em_content) {
		this.q_em_content = q_em_content;
	}
	@Override
	public String toString() {
		return "QnaEmailCommand [q_em_email=" + q_em_email + ", q_em_subject=" + q_em_subject + ", q_em_content="
				+ q_em_content + ", q_em_num=" + q_em_num + "]";
	}
	

	
	
	

}

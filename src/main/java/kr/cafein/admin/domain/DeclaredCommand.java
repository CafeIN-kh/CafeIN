package kr.cafein.admin.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class DeclaredCommand {
	
	private int d_seq;			//�Ű����� ������
	@NotEmpty
	private int d_target_id; 	//�Ű��� ���,�Խñ��� (seq)   pk
	@NotEmpty
	private int d_target_path; 	//�Ű��� ���(target_type :  - 0���������� ��� 1- ����ī�� ��� 2- Ŀ���͸���¡ ���)
	@NotEmpty
	private String d_mem_id;  		//�Ű��� �� ȸ�� ���̵�(seq) pk
	private String d_target_mem_id; //�Ű� ���� ȸ�����̵�(seq) Ȥ�� �Խ�Ʈ (Null:Guest, Not Null:ȸ��)
	private Date d_reg_date;
	private String d_content;
	private int d_state;		 //ó������(0.ó�� ��, 1.ó�� ��,2.ó�� �Ϸ�, 3ó�� ����, 4. ó�� ���)
	
	
	
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
	public int getD_seq() {
		return d_seq;
	}
	public void setD_seq(int d_seq) {
		this.d_seq = d_seq;
	}
	public int getD_target_id() {
		return d_target_id;
	}
	public void setD_target_id(int d_target_id) {
		this.d_target_id = d_target_id;
	}
	public int getD_target_path() {
		return d_target_path;
	}
	public void setD_target_path(int d_target_path) {
		this.d_target_path = d_target_path;
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
	
	@Override
	public String toString() {
		return "DeclaredCommand [d_seq=" + d_seq + ", d_target_id=" + d_target_id + ", d_target_path=" + d_target_path
				+ ", d_mem_id=" + d_mem_id + ", d_target_mem_id=" + d_target_mem_id + ", d_reg_date=" + d_reg_date
				+ ", d_content=" + d_content + ", d_state=" + d_state + "]";
	}
	
	
	
}
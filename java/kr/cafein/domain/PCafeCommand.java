package kr.cafein.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class PCafeCommand {

	private int pcafe_num;
	private String u_uid;
	@NotEmpty
	private String pcafe_name;
	private String pcafe_address;
	private String pcafe_phone;
	private String pcafe_time;
	private String pcafe_url;
	private String pcafe_introduce;
	private String pcafe_hash_tag;
	//카페 등록 파일 첨부(contact.js에서 구분을 위해)
	private MultipartFile upload;
	//카페 수정 파일 첨부(contact.js에서 구분을 위해) - null 값들어가면 오류나서 따로 뺌
	//private MultipartFile upload_modify;
	private String pcafe_img;
	private int pcafe_visit;
	private Date pcafe_reg_date;
	
	//좋아요수 select 한거 담을 그릇
	private int pc_reply_cnt;
	//댓글수 select 한거 담을 그릇
	private int pc_like_cnt;
	//영업 시작시간 pcafe_time = pcafe_time_start ~ pcafe_time_end 해줄것임
	private String pcafe_time_start;
	//영업 마감시간 
	private String pcafe_time_end;

	
	/*public MultipartFile getUpload_modify() {
		return upload_modify;
	}
	public void setUpload_modify(MultipartFile upload_modify) {
		this.upload_modify = upload_modify;
	}*/
	public String getPcafe_time_start() {
		return pcafe_time_start;
	}
	public void setPcafe_time_start(String pcafe_time_start) {
		this.pcafe_time_start = pcafe_time_start;
	}
	public String getPcafe_time_end() {
		return pcafe_time_end;
	}
	public void setPcafe_time_end(String pcafe_time_end) {
		this.pcafe_time_end = pcafe_time_end;
	}
	public int getPcafe_num() {
		return pcafe_num;
	}
	public int getPc_reply_cnt() {
		return pc_reply_cnt;
	}
	public void setPc_reply_cnt(int pc_reply_cnt) {
		this.pc_reply_cnt = pc_reply_cnt;
	}
	public int getPc_like_cnt() {
		return pc_like_cnt;
	}
	public void setPc_like_cnt(int pc_like_cnt) {
		this.pc_like_cnt = pc_like_cnt;
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
	public String getPcafe_name() {
		return pcafe_name;
	}
	public void setPcafe_name(String pcafe_name) {
		this.pcafe_name = pcafe_name;
	}
	public String getPcafe_address() {
		return pcafe_address;
	}
	public void setPcafe_address(String pcafe_address) {
		this.pcafe_address = pcafe_address;
	}
	public String getPcafe_phone() {
		return pcafe_phone;
	}
	public void setPcafe_phone(String pcafe_phone) {
		this.pcafe_phone = pcafe_phone;
	}
	public String getPcafe_time() {
		return pcafe_time;
	}
	public void setPcafe_time(String pcafe_time) {
		this.pcafe_time = pcafe_time;
	}
	public String getPcafe_url() {
		return pcafe_url;
	}
	public void setPcafe_url(String pcafe_url) {
		this.pcafe_url = pcafe_url;
	}
	public String getPcafe_introduce() {
		return pcafe_introduce;
	}
	public void setPcafe_introduce(String pcafe_introduce) {
		this.pcafe_introduce = pcafe_introduce;
	}
	public String getPcafe_hash_tag() {
		return pcafe_hash_tag;
	}
	public void setPcafe_hash_tag(String pcafe_hash_tag) {
		this.pcafe_hash_tag = pcafe_hash_tag;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getPcafe_img() {
		return pcafe_img;
	}
	public void setPcafe_img(String pcafe_img) {
		this.pcafe_img = pcafe_img;
	}
	public int getPcafe_visit() {
		return pcafe_visit;
	}
	public void setPcafe_visit(int pcafe_visit) {
		this.pcafe_visit = pcafe_visit;
	}
	public Date getPcafe_reg_date() {
		return pcafe_reg_date;
	}
	public void setPcafe_reg_date(Date pcafe_reg_date) {
		this.pcafe_reg_date = pcafe_reg_date;
	}
	@Override
	public String toString() {
		return "PCafeCommand [pcafe_num=" + pcafe_num + ", u_uid=" + u_uid + ", pcafe_name=" + pcafe_name
				+ ", pcafe_address=" + pcafe_address + ", pcafe_phone=" + pcafe_phone + ", pcafe_time=" + pcafe_time
				+ ", pcafe_url=" + pcafe_url + ", pcafe_introduce=" + pcafe_introduce + ", pcafe_hash_tag="
				+ pcafe_hash_tag + ", upload=" + upload + ", pcafe_img=" + pcafe_img + ", pcafe_visit=" + pcafe_visit
				+ ", pcafe_reg_date=" + pcafe_reg_date + ", pc_reply_cnt=" + pc_reply_cnt + ", pc_like_cnt="
				+ pc_like_cnt + ", pcafe_time_start=" + pcafe_time_start + ", pcafe_time_end=" + pcafe_time_end + "]";
	}
	
	//@Override
	/*public String toString() {
		return "PCafeCommand [pcafe_num=" + pcafe_num + ", u_uid=" + u_uid + ", pcafe_name=" + pcafe_name
				+ ", pcafe_address=" + pcafe_address + ", pcafe_phone=" + pcafe_phone + ", pcafe_time=" + pcafe_time
				+ ", pcafe_url=" + pcafe_url + ", pcafe_introduce=" + pcafe_introduce + ", pcafe_hash_tag="
				+ pcafe_hash_tag + ", upload=" + upload + ", upload_modify=" + upload_modify + ", pcafe_img="
				+ pcafe_img + ", pcafe_visit=" + pcafe_visit + ", pcafe_reg_date=" + pcafe_reg_date + ", pc_reply_cnt="
				+ pc_reply_cnt + ", pc_like_cnt=" + pc_like_cnt + ", pcafe_time_start=" + pcafe_time_start
				+ ", pcafe_time_end=" + pcafe_time_end + "]";
	}*/
}

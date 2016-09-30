package kr.cafein.admin.main.domain;

public class AdminMainNoticeCommand {

	private String admin_notice_title;
	private String admin_notice_content;
	
	public String getAdmin_notice_title() {
		return admin_notice_title;
	}
	public void setAdmin_notice_title(String admin_notice_title) {
		this.admin_notice_title = admin_notice_title;
	}
	public String getAdmin_notice_content() {
		return admin_notice_content;
	}
	public void setAdmin_notice_content(String admin_notice_content) {
		this.admin_notice_content = admin_notice_content;
	}
	@Override
	public String toString() {
		return "AdminMainNoticeCommand [admin_notice_title=" + admin_notice_title + ", admin_notice_content="
				+ admin_notice_content + "]";
	}

	
}

package kr.cafein.admin.custom.chart.domain;

public class AdminCustomBookmarkCommand {

	private String bookmark_reg_date;
	private int count;
	public String getBookmark_reg_date() {
		return bookmark_reg_date;
	}
	public void setBookmark_reg_date(String bookmark_reg_date) {
		this.bookmark_reg_date = bookmark_reg_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdminPcafeBookmarkCommand [bookmark_reg_date=" + bookmark_reg_date + ", count=" + count + "]";
	}
}

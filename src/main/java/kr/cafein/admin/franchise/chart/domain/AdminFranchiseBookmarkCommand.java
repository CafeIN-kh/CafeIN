package kr.cafein.admin.franchise.chart.domain;

public class AdminFranchiseBookmarkCommand {

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
		return "AdminFranchiseBookmarkCommand [bookmark_reg_date=" + bookmark_reg_date + ", count=" + count + "]";
	}	
}

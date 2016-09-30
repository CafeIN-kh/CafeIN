package kr.cafein.admin.franchise.chart.domain;

public class AdminFranchiseDeClaredCommand {
	private String reg_date;
	private int count;
	
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdminFranchiseDeClaredCommand [reg_date=" + reg_date + ", count=" + count + "]";
	}
	
	
}

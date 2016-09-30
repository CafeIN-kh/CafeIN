package kr.cafein.admin.main.domain;

public class AdminMainPTotalCommand {
	
	private int ucnt_total;

	public int getUcnt_total() {
		return ucnt_total;
	}

	public void setUcnt_total(int ucnt_total) {
		this.ucnt_total = ucnt_total;
	}

	@Override
	public String toString() {
		return "AdminMainPTotalCommand [ucnt_total=" + ucnt_total + "]";
	}
	
	
}

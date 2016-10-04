package kr.cafein.admin.pcafe.chart.domain;

public class AdminPcafeChartCommand {

	private String reg_date;
	private int ucnt_log_private;
	
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getUcnt_log_private() {
		return ucnt_log_private;
	}
	public void setUcnt_log_private(int ucnt_log_private) {
		this.ucnt_log_private = ucnt_log_private;
	}
	@Override
	public String toString() {
		return "AdminPcafeChartCommand [reg_date=" + reg_date + ", ucnt_log_private=" + ucnt_log_private + "]";
	}

	
}

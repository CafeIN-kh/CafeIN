package kr.cafein.admin.main.domain;

public class AdminMainCustomizingTotalCommand {
	private String reg_date;
	private int ucnt_log_custom;

	public int getUcnt_log_custom() {
		return ucnt_log_custom;
	}

	public void setUcnt_log_custom(int ucnt_log_custom) {
		this.ucnt_log_custom = ucnt_log_custom;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "AdminMainCustomizingTotalCommand [reg_date=" + reg_date + ", ucnt_log_custom=" + ucnt_log_custom + "]";
	}
	
}

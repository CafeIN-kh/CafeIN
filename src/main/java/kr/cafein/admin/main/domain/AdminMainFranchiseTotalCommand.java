package kr.cafein.admin.main.domain;

public class AdminMainFranchiseTotalCommand {

	private String reg_date;
	private int ucnt_log_franchise;

	public int getUcnt_log_franchise() {
		return ucnt_log_franchise;
	}

	public void setUcnt_log_franchise(int ucnt_log_franchise) {
		this.ucnt_log_franchise = ucnt_log_franchise;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "AdminMainFranchiseTotalCommand [reg_date=" + reg_date + ", ucnt_log_franchise=" + ucnt_log_franchise
				+ "]";
	}


	
	
}

package kr.cafein.admin.custom.chart.domain;

public class AdminCustomTotalCountCommand {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminPcafeTotalCountCommand [count=" + count + "]";
	}


}

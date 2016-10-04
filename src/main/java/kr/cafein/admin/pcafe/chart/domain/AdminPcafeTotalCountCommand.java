package kr.cafein.admin.pcafe.chart.domain;

public class AdminPcafeTotalCountCommand {

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

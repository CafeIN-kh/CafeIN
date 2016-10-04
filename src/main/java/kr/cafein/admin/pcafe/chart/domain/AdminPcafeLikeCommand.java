package kr.cafein.admin.pcafe.chart.domain;

public class AdminPcafeLikeCommand {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminPcafeLikeCommand [count=" + count + "]";
	}

}

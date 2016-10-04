package kr.cafein.admin.custom.chart.domain;

public class AdminCustomLikeCommand {
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

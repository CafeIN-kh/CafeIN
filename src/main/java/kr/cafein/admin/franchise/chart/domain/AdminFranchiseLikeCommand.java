package kr.cafein.admin.franchise.chart.domain;

public class AdminFranchiseLikeCommand {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminFranchiseLikeDayCommand [count=" + count + "]";
	}
}

package kr.cafein.admin.main.domain;

public class AdminMainCountCommand {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AdminMainCountCommand [count=" + count + "]";
	}
}

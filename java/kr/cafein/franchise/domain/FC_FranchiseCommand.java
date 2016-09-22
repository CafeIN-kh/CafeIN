package kr.cafein.franchise.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class FC_FranchiseCommand {
	@NotEmpty
	private int franchise_num;
	@NotEmpty
	private String franchise_name;
	@NotEmpty
	private String franchise_img;
	@NotEmpty
	private String franchise_introduce;
	
	private int franchise_visit;
	
	public int getFranchise_num() {
		return franchise_num;
	}

	public void setFranchise_num(int franchise_num) {
		this.franchise_num = franchise_num;
	}

	public String getFranchise_name() {
		return franchise_name;
	}

	public void setFranchise_name(String franchise_name) {
		this.franchise_name = franchise_name;
	}

	public String getFranchise_img() {
		return franchise_img;
	}

	public void setFranchise_img(String franchise_img) {
		this.franchise_img = franchise_img;
	}

	public String getFranchise_introduce() {
		return franchise_introduce;
	}

	public void setFranchise_introduce(String franchise_introduce) {
		this.franchise_introduce = franchise_introduce;
	}

	public int getFranchise_visit() {
		return franchise_visit;
	}

	public void setFranchise_visit(int franchise_visit) {
		this.franchise_visit = franchise_visit;
	}

	@Override
	public String toString() {
		return "FranchiseCommand [franchise_num=" + franchise_num + ", franchise_name=" + franchise_name
				+ ", franchise_img=" + franchise_img + ", franchise_introduce=" + franchise_introduce
				+ ", franchise_visit=" + franchise_visit + "]";
	}
}

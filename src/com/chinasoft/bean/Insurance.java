package com.chinasoft.bean;

public class Insurance {

	// 保险编号
	private int insuranceID;
	// 保险名称
	private String insuranceName;
	// 保险金额
	private double insuranceMoney;

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public double getInsuranceMoney() {
		return insuranceMoney;
	}

	public void setInsuranceMoney(double insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}

}

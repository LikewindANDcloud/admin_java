package com.chinasoft.bean;

public class Orders {

	// 订单编号
	private int orderID;
	// 线路编号
	private int lineID;
	// 线路名
	private String lineName;
	// 下单用户编号
	private int userID;
	// 用户姓名
	private String userName;
	// 出游日期
	private String outDate;
	// 返程日期
	private String returnDate;
	// 保险编号
	private int insuranceID;
	// 保险名
	private String insuranceName;
	// 出游总人数
	private int sumPerson;
	// 总价格
	private double sumPrice;
	// 打折后最终价格
	private double finalPrice;
	// 下单时间
	private String orderTime;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public int getSumPerson() {
		return sumPerson;
	}

	public void setSumPerson(int sumPerson) {
		this.sumPerson = sumPerson;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

}

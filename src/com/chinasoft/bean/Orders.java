package com.chinasoft.bean;

public class Orders {

	// �������
	private int orderID;
	// ��·���
	private int lineID;
	// ��·��
	private String lineName;
	// �µ��û����
	private int userID;
	// �û�����
	private String userName;
	// ��������
	private String outDate;
	// ��������
	private String returnDate;
	// ���ձ��
	private int insuranceID;
	// ������
	private String insuranceName;
	// ����������
	private int sumPerson;
	// �ܼ۸�
	private double sumPrice;
	// ���ۺ����ռ۸�
	private double finalPrice;
	// �µ�ʱ��
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

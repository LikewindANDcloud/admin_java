package com.chinasoft.bean;

public class Lines {

	// ��·���
	private int lineID;
	// ��·����
	private String lineName;
	// ��·���ͱ��
	private int lineTypeID;
	// ��·��������
	private String lineTypeTitle;
	// ���η�ʽ���
	private int outTypeID;
	// ���η�ʽ����
	private String outTypeTitle;
	// ��ǰ��·�۸�
	private double beforePrice;
	// �ۺ���·�۸�
	private double nowPrice;
	// �������б��
	private int cityID;
	// ������������
	private String cityName;
	// Ĭ�ϾƵ���
	private int hotelID;
	// Ĭ�ϾƵ�����
	private String hotelName;
	// ������Ƭ
	private String picUrl;

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public int getLineTypeID() {
		return lineTypeID;
	}

	public void setLineTypeID(int lineTypeID) {
		this.lineTypeID = lineTypeID;
	}

	public String getLineTypeTitle() {
		return lineTypeTitle;
	}

	public void setLineTypeTitle(String lineTypeTitle) {
		this.lineTypeTitle = lineTypeTitle;
	}

	public int getOutTypeID() {
		return outTypeID;
	}

	public void setOutTypeID(int outTypeID) {
		this.outTypeID = outTypeID;
	}

	public String getOutTypeTitle() {
		return outTypeTitle;
	}

	public void setOutTypeTitle(String outTypeTitle) {
		this.outTypeTitle = outTypeTitle;
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public double getBeforePrice() {
		return beforePrice;
	}

	public void setBeforePrice(double beforePrice) {
		this.beforePrice = beforePrice;
	}

	public double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}

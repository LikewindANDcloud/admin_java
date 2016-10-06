package com.chinasoft.bean;

public class Lines {

	// 线路编号
	private int lineID;
	// 线路名称
	private String lineName;
	// 线路类型编号
	private int lineTypeID;
	// 线路类型名称
	private String lineTypeTitle;
	// 出游方式编号
	private int outTypeID;
	// 出游方式名称
	private String outTypeTitle;
	// 折前线路价格
	private double beforePrice;
	// 折后线路价格
	private double nowPrice;
	// 所属城市编号
	private int cityID;
	// 所属城市名称
	private String cityName;
	// 默认酒店编号
	private int hotelID;
	// 默认酒店名称
	private String hotelName;
	// 景点照片
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

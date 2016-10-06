package com.chinasoft.bean;

public class Users {

	// 用户编号
	private int userID;
	// 用户帐号
	private String userNumber;
	// 用户密码
	private String userPwd;
	// 用户姓名
	private String userName;
	// 用户证件号
	private String userIdentity;
	// 用户手机号
	private String userTel;
	// 用户性别
	private String userSex;
	// 用户会员级别ID
	private int vipID;
	// 用户会员等级名称
	private String userVipTitle;
	//订单量
	private int orderNum;
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getVipID() {
		return vipID;
	}

	public void setVipID(int vipID) {
		this.vipID = vipID;
	}

	public String getUserVipTitle() {
		return userVipTitle;
	}

	public void setUserVipTitle(String userVipTitle) {
		this.userVipTitle = userVipTitle;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

}

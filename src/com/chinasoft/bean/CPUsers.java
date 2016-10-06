package com.chinasoft.bean;

import java.util.List;

public class CPUsers {

	/* 复合对象，用来传递用户信息分页数据 */

	// Users对象集合
	private List<Users> list;
	// users表总数据量
	private int uDataCount;
	// 总页数
	private int pageCount;
	// 每页数据量
	private int pageSize;
	// 当前页编号
	private int pageIndex;

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public int getuDataCount() {
		return uDataCount;
	}

	public void setuDataCount(int uDataCount) {
		this.uDataCount = uDataCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}

package com.chinasoft.bean;

import java.util.List;

public class CPUsers {

	/* ���϶������������û���Ϣ��ҳ���� */

	// Users���󼯺�
	private List<Users> list;
	// users����������
	private int uDataCount;
	// ��ҳ��
	private int pageCount;
	// ÿҳ������
	private int pageSize;
	// ��ǰҳ���
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

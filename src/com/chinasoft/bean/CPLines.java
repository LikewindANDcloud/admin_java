package com.chinasoft.bean;

import java.util.List;

public class CPLines {

	/* ���϶������ڴ�����·��ҳ���� */

	// Lines���󼯺�
	private List<Lines> list;
	// lines����������
	private int lDataCount;
	// ��ҳ��
	private int pageCount;
	// ÿҳ������
	private int pageSize;
	// ��ǰҳ���
	private int pageIndex;

	public List<Lines> getList() {
		return list;
	}

	public void setList(List<Lines> list) {
		this.list = list;
	}

	public int getlDataCount() {
		return lDataCount;
	}

	public void setlDataCount(int lDataCount) {
		this.lDataCount = lDataCount;
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

package com.chinasoft.bean;

import java.util.List;

public class CPOrders {
	// Lines对象集合
		private List<Orders> list;
		public List<Orders> getList() {
			return list;
		}
		public void setList(List<Orders> list) {
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
		// lines表数据总量
		private int lDataCount;
		// 总页数
		private int pageCount;
		// 每页数据量
		private int pageSize;
		// 当前页编号
		private int pageIndex;
}

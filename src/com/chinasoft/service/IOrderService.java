package com.chinasoft.service;

import java.util.List;

import com.chinasoft.bean.CPOrders;
import com.chinasoft.bean.Orders;

public interface IOrderService {
	public CPOrders getOrders(int pageIndex,int pageSize);
	public CPOrders getOrders(int pageIndex,int pageSize,List<Orders> list);
}

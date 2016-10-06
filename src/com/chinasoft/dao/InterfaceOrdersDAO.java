package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Orders;

public interface InterfaceOrdersDAO {

	//查询订单列表
	public List<Orders> getList();
	
	//删除订单
	public int getDel(int orderid);
	
	//增加订单
	public int getInsert(Orders ord);
	//根据id查询某一订单
	public Orders getOrderById(int orderId);
	//根据用户名查询订单
	public List<Orders> getOrderByUserName(String userName);
	//修改订单信息
	public int updateOrder(Orders ord);
}

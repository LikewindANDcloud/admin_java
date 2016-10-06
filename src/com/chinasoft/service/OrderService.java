package com.chinasoft.service;

import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.CPOrders;
import com.chinasoft.bean.Orders;
import com.chinasoft.dao.OrdersDAO;

public class OrderService implements IOrderService{

	@Override
	public CPOrders getOrders(int pageIndex,int pageSize ) {
		// TODO Auto-generated method stub
		CPOrders co=new CPOrders();
		co.setPageIndex(pageIndex);
		co.setPageSize(pageSize);
		OrdersDAO od=new OrdersDAO();
		List<Orders> orderList=od.getList();
		if(orderList!=null){
			co.setlDataCount(orderList.size());
			if(orderList.size()%pageSize==0){
				co.setPageCount(orderList.size()/pageSize);
			}else{
				co.setPageCount(orderList.size()/pageSize+1);
			}
		}
		List<Orders> smallList=new ArrayList<Orders>();
		for(int i=(pageIndex-1)*pageSize;i<orderList.size()&&i<pageIndex*pageSize;i++){
			smallList.add(orderList.get(i));
		}
		co.setList(smallList);
		return co;
	}

	@Override
	public CPOrders getOrders(int pageIndex, int pageSize, List<Orders> list) {
		// TODO Auto-generated method stub
		CPOrders co=new CPOrders();
		co.setPageIndex(pageIndex);
		co.setPageSize(pageSize);
		if(list!=null){
			co.setlDataCount(list.size());
			if(list.size()%pageSize==0){
				co.setPageCount(list.size()/pageSize);
			}else{
				co.setPageCount(list.size()/pageSize+1);
			}
		}
		List<Orders> smallList=new ArrayList<Orders>();
		for(int i=(pageIndex-1)*pageSize;i<list.size()&&i<pageIndex*pageSize;i++){
			smallList.add(list.get(i));
		}
		co.setList(smallList);
		return co;
	}

}

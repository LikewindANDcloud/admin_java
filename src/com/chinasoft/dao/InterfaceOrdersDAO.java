package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Orders;

public interface InterfaceOrdersDAO {

	//��ѯ�����б�
	public List<Orders> getList();
	
	//ɾ������
	public int getDel(int orderid);
	
	//���Ӷ���
	public int getInsert(Orders ord);
	//����id��ѯĳһ����
	public Orders getOrderById(int orderId);
	//�����û�����ѯ����
	public List<Orders> getOrderByUserName(String userName);
	//�޸Ķ�����Ϣ
	public int updateOrder(Orders ord);
}

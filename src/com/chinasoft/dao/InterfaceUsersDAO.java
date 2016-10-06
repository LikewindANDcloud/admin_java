package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Users;

public interface InterfaceUsersDAO {

	//��ѯ�û��б�
	public List<Users> getList(String sql);
	
	//��ѯ�û���������������
	public int getUDataCount(String sql);
	
	//ɾ��ĳ�û���ͨ���û���ɾ����
	public int getDelUsers(String sql);
	
	//�޸��û���Ϣ
	public int getUpdateUsers(Users user);
	
	//ע��Ϸ���ѯ
	public boolean getFind(String sql);
	
	//ע��
	public int getRegUsers(Users user);
	
	//��¼
	public Users getLogin(String sql);
	
	//����id��������Ա�ȼ�
	public int updateUsers(int userId,int vipId);
	//����Id����ĳ�û��Ķ�����
	public int getOrderNumById(int userId);
}

package com.chinasoft.dao;

import com.chinasoft.bean.Admin;

public interface InterfaceAdminDAO {

	//����Ա��¼
	public Admin getLogin(String adminname,String adminpwd);
	
	//����Ա�޸�����
	public int getUpdate(String sql);
	
}

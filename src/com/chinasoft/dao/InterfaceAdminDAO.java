package com.chinasoft.dao;

import com.chinasoft.bean.Admin;

public interface InterfaceAdminDAO {

	//管理员登录
	public Admin getLogin(String adminname,String adminpwd);
	
	//管理员修改密码
	public int getUpdate(String sql);
	
}

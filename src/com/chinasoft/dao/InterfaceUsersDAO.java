package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Users;

public interface InterfaceUsersDAO {

	//查询用户列表
	public List<Users> getList(String sql);
	
	//查询用户表所有数据条数
	public int getUDataCount(String sql);
	
	//删除某用户（通过用户名删除）
	public int getDelUsers(String sql);
	
	//修改用户信息
	public int getUpdateUsers(Users user);
	
	//注册合法查询
	public boolean getFind(String sql);
	
	//注册
	public int getRegUsers(Users user);
	
	//登录
	public Users getLogin(String sql);
	
	//根据id来升级会员等级
	public int updateUsers(int userId,int vipId);
	//根据Id来查某用户的订单量
	public int getOrderNumById(int userId);
}

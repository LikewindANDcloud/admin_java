package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Insurance;

public interface InterfaceInsuranceDAO {

	//查询保险列表
	public List<Insurance> getList(String sql);
	
	//增加保险列表
	public int getInsert(Insurance ins);
	
	//删除保险列表
	public int getDel(String sql);
	
	//修改保险列表
	public int getUpdate(Insurance ins);
	//根据保险名查询保险id
	public int getInsurId(String insurname);
	
}

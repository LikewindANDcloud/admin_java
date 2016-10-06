package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Lines;

public interface InterfaceLinesDAO {

	//查询线路列表
	public List<Lines> getList();
	//根据线路名查询线路列表
	public List<Lines> getList(String linename);
	//查询某行线路的所有信息(通过线路名称)
	public Lines getLineInfo(String sql);
	
	//删除某线路的信息
	public int getDelLine(int lineid);
	
	//修改某线路的信息
	public int getUpdateLine(Lines line);
	
	//增加线路
	public int getInsertLine(Lines line);
	
}

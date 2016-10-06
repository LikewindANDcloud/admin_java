package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Insurance;

public interface InterfaceInsuranceDAO {

	//��ѯ�����б�
	public List<Insurance> getList(String sql);
	
	//���ӱ����б�
	public int getInsert(Insurance ins);
	
	//ɾ�������б�
	public int getDel(String sql);
	
	//�޸ı����б�
	public int getUpdate(Insurance ins);
	//���ݱ�������ѯ����id
	public int getInsurId(String insurname);
	
}

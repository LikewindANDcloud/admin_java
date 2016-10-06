package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.bean.Lines;

public interface InterfaceLinesDAO {

	//��ѯ��·�б�
	public List<Lines> getList();
	//������·����ѯ��·�б�
	public List<Lines> getList(String linename);
	//��ѯĳ����·��������Ϣ(ͨ����·����)
	public Lines getLineInfo(String sql);
	
	//ɾ��ĳ��·����Ϣ
	public int getDelLine(int lineid);
	
	//�޸�ĳ��·����Ϣ
	public int getUpdateLine(Lines line);
	
	//������·
	public int getInsertLine(Lines line);
	
}

package com.chinasoft.service;

import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.CPLines;
import com.chinasoft.bean.Lines;
import com.chinasoft.dao.InterfaceLinesDAO;
import com.chinasoft.dao.LinesDAO;

public class LineService implements ILineService{

	@Override
	public CPLines getLine(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		CPLines cl=new CPLines();
		cl.setPageIndex(pageIndex);
		cl.setPageSize(pageSize);
		InterfaceLinesDAO ild=new LinesDAO();
		List<Lines> list=ild.getList();
		if(list!=null){
			cl.setlDataCount(list.size());
			if(list.size()%pageSize==0){
				cl.setPageCount(list.size()/pageSize);
			}else{
				cl.setPageCount(list.size()/pageSize+1);
			}
		}
		List<Lines> smallList=new ArrayList<Lines>();
		for(int i=(pageIndex-1)*pageSize;i<list.size()&&i<pageIndex*pageSize;i++){
			smallList.add(list.get(i));
		}
		cl.setList(smallList);
		return cl;
	}

	@Override
	public CPLines getLine(int pageIndex, int pageSize, List<Lines> list) {
		// TODO Auto-generated method stub
		CPLines cl=new CPLines();
		cl.setPageIndex(pageIndex);
		cl.setPageSize(pageSize);
		if(list!=null){
			cl.setlDataCount(list.size());
			if(list.size()%pageSize==0){
				cl.setPageCount(list.size()/pageSize);
			}else{
				cl.setPageCount(list.size()/pageSize+1);
			}
		}
		List<Lines> smallList=new ArrayList<Lines>();
		for(int i=(pageIndex-1)*pageSize;i<list.size()&&i<pageIndex*pageSize;i++){
			smallList.add(list.get(i));
		}
		cl.setList(smallList);
		return cl;
	}

}

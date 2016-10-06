package com.chinasoft.service;

import java.util.List;

import com.chinasoft.bean.CPLines;
import com.chinasoft.bean.Lines;

public interface ILineService {
	public CPLines getLine(int pageIndex, int pageSize);
	public CPLines getLine(int pageIndex, int pageSize,List<Lines> list);
}

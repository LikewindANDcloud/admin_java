package com.chinasoft.service;

import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.CPUsers;
import com.chinasoft.bean.Users;

public class UsersService implements IUserService{

	@Override
	public CPUsers getUsers(int pageIndex, int pageSize, List<Users> list) {
		// TODO Auto-generated method stub
		CPUsers cu=new CPUsers();
		cu.setPageIndex(pageIndex);
		cu.setPageSize(pageSize);
		if(list!=null){
			cu.setPageCount(list.size()%pageSize==0?list.size()/pageSize:list.size()/pageSize+1);
			cu.setuDataCount(list.size());
		}
		List<Users> smallList=new ArrayList<Users>();
		for(int i=(pageIndex-1)*pageSize;i<list.size()&&i<pageIndex*pageSize;i++){
			smallList.add(list.get(i));
		}
		cu.setList(smallList);
		return cu;
	}

}

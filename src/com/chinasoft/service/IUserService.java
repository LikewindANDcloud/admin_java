package com.chinasoft.service;

import java.util.List;

import com.chinasoft.bean.CPUsers;
import com.chinasoft.bean.Users;

public interface IUserService {
	public CPUsers getUsers(int pageIndex, int pageSize, List<Users> list);
}

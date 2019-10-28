package com.test.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.system.dao.UserDaoI;
import com.test.system.entity.SysUser;
import com.test.system.service.UserServiceI;


@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserDaoI userDao;
	
	@Override
	public SysUser selectById(Integer id) {
		return userDao.selectById(id);
	}

	@Override
	public SysUser login(String username, String password) {
		SysUser u = userDao.login(username, password);
		return u;
	}

}
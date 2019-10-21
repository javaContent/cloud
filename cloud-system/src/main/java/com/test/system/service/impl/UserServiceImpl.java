package com.test.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.system.dao.UserDaoI;
import com.test.system.entity.User;
import com.test.system.service.UserServiceI;


@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserDaoI userDao;
	
	@Override
	public User selectById(Integer id) {
		return userDao.selectById(id);
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.login(username, password);
		return u;
	}

}
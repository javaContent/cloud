package com.test.registry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.registry.dao.UserDaoI;
import com.test.registry.entity.User;
import com.test.registry.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserDaoI userDao;
	
	@Override
	public User selectById(Integer id) {
		return userDao.selectById(id);
	}

}

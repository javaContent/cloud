package com.test.system.service;

import com.test.system.entity.User;

public interface UserServiceI {
	
	public User selectById(Integer id);
	
	public User login(String username, String password);

}

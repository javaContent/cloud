package com.test.system.service;

import com.test.system.api.entity.SysUser;

//import com.test.system.entity.SysUser;

public interface UserServiceI {
	
	public SysUser selectById(Integer id);
	
	public SysUser login(String username, String password);

}

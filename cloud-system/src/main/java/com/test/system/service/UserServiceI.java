package com.test.system.service;

import com.test.system.api.entity.SysUser;


public interface UserServiceI {
	
	public SysUser selectById(Integer id);
	
	public SysUser login(String username, String password);

	public SysUser register(SysUser sysUser);

}

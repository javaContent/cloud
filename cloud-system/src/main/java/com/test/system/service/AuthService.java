package com.test.system.service;

import com.test.system.api.entity.SysUser;


public interface AuthService {
	
	SysUser register(SysUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);

}

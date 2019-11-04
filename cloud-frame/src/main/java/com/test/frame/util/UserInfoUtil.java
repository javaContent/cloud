package com.test.frame.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.frame.helper.RedisClient;
import com.test.system.api.entity.SysUser;

@Component
public class UserInfoUtil {
	
	@Autowired
	RedisClient redisClient;
	
	public SysUser getUserByToken(String accessToken) {
		return (SysUser) redisClient.getValue(accessToken);
	}
	
	public void setUserByToken(String accessToken,SysUser sysUser) {
		redisClient.setValue(accessToken, sysUser, 10*60*1000);
	}
	
	/**
	 * 刷新存活时间
	 * @param accessToken
	 */
	public void refTime(String accessToken) {
		redisClient.setExpire(accessToken, 10*60*1000);
	}
	
	
	
	
}

package com.test.frame.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.common.constant.CommonConst;
import com.test.frame.helper.RedisClient;
import com.test.system.api.entity.SysUser;

/**
 * 用户信息缓存类
 * @author Administrator
 *
 */
@Component
public class UserInfoHelper {
	
	@Autowired
	RedisClient redisClient;
	/**
	 * 获取用户信息缓存
	 * @param accessToken
	 * @return
	 */
	public SysUser getUserByToken(String accessToken) {
		return (SysUser) redisClient.getValue(CommonConst.SESSION_USER + "_" + accessToken);
	}
	/**
	 * 设置用户信息缓存
	 * @param accessToken
	 * @param sysUser
	 */
	public void setUserByToken(String accessToken,SysUser sysUser) {
		redisClient.setValue(CommonConst.SESSION_USER + "_" + accessToken, sysUser, 10*60*1000);
	}
	
	/**
	 * 刷新用户信息缓存存活时间
	 * @param accessToken
	 */
	public void refTime(String accessToken) {
		redisClient.setExpire(CommonConst.SESSION_USER + "_" + accessToken, 10*60*1000);
	}
	
}

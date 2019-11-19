package com.test.common.constant;

public interface CommonConst {
	
	String ACCESS_TOCKEN = "Authorization";
	
	String tokenHead ="Bearer";
	
	String SESSION_USER = "sessionUser";
	
	/*token在Redis存活时长*/
	Integer SESSION_TIME = 15*60*1000;
	
	//登陆地址
	String LOGIN_URL = "/auth/login";
	//刷新token
	String REFRESH_URL = "/auth/refresh";
	//注册
	String REGISTER_URL = "/auth/register";
	//注销
	String OUTLOGIN_URL = "/auth/outLogin";

}

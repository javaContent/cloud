package com.test.system.api.fallback;

import org.springframework.stereotype.Component;

import com.test.system.api.service.LoginService;

@Component
public class FeignFallBack implements LoginService {

	@Override
	public Boolean isLogin(String accessToken) {
		return false;
	}
	
	

}

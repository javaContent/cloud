package com.test.system.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.test.common.constant.CommonConst;
import com.test.system.api.fallback.FeignFallBack;

@FeignClient(value = "system",fallback = FeignFallBack.class)
public interface LoginService {
	
	@RequestMapping(value = "/auth/isLogin",method=RequestMethod.GET)
    public Boolean isLogin(@RequestHeader(CommonConst.ACCESS_TOCKEN)  String accessToken);

}

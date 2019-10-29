package com.test.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.system.entity.Result;
import com.test.system.helper.RedisClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录管理")
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	RedisClient redisClient;
	
	@ApiOperation(value = "Redis")
    @RequestMapping(value = "/redis/setVal", method = RequestMethod.POST)
    public Result setVal(String key,String value) {
		redisClient.setValue(key, value, 60*1000);
		return Result.success();
    }
	
	@ApiOperation(value = "Redis")
    @RequestMapping(value = "/redis/getVal", method = RequestMethod.GET)
    public Result getVal(String key) {
		String val = redisClient.getValue(key,String.class);
		return Result.success(val);
    }

}

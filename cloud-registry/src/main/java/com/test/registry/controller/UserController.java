package com.test.registry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.registry.entity.User;
import com.test.registry.service.UserServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录管理")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceI userService; 
	
	@ApiOperation(value = "根据id获取用户名")
	@RequestMapping(value="/getName", method = RequestMethod.GET)
	@ResponseBody
	public String getUserName() {
		User user = userService.selectById(1);
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return user.getUserName();
	}
	
	@ApiOperation(value = "登录")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public User login(@RequestBody @Valid User user) {
		boolean isUser = userService.login(user);
		if(isUser) {
			return user;
		}
		return null;
	}

}

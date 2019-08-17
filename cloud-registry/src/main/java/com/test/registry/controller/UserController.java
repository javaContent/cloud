package com.test.registry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.registry.entity.User;
import com.test.registry.service.UserServiceI;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceI userService; 
	
	@RequestMapping("/getName")
	@ResponseBody
	public String getUserName() {
		User user = userService.selectById(1);
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return user.getUserName();
	}

}

package com.test.system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.system.api.entity.SysUser;
//import com.test.system.entity.SysUser;
import com.test.system.service.UserServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "系统接口")
@RestController
@RequestMapping("/api/system")
public class SystemController {
	
	@Autowired
	private UserServiceI userService; 
	
	@ApiOperation(value = "获取用户名")
	@RequestMapping(value="getUserName", method = RequestMethod.GET)
	@ResponseBody
	public String login() {
		SysUser user = userService.selectById(1);
		return user.getUserName();
	}

}

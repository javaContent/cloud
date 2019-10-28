package com.test.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.test.system.entity.SysUser;
import com.test.system.service.UserServiceI;
import com.test.system.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import javax.validation.Valid;

@Api(description = "登录接口")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UserServiceI service;

	@ApiOperation(value = "登录")
	@RequestMapping(value="", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody @Valid SysUser user) {
		SysUser userDO = service.login(user.getUserName(),  user.getPassword());
		String token = JwtUtil.createToken(userDO.getUserName());
        return token;
	}


}

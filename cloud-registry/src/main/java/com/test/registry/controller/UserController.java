package com.test.registry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.common.constant.CommonConst;
import com.test.frame.helper.UserInfoHelper;
import com.test.system.api.entity.SysUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录管理")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInfoHelper userInfoHelper;
	
	@ApiOperation(value = "根据id获取用户名")
	@RequestMapping(value="/getName", method = RequestMethod.GET)
	@ResponseBody
	public String getUserName(HttpServletRequest request) {
		String token = request.getHeader(CommonConst.ACCESS_TOCKEN);
		SysUser user = userInfoHelper.getUserByToken(token);
//		User user = userService.selectById(1);
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		return user.getUserName();
	}
	
}

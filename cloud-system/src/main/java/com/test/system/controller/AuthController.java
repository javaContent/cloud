package com.test.system.controller;

import javax.servlet.http.HttpServletRequest;


import com.test.system.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.test.common.constant.CommonConst;
import com.test.common.entity.Result;
import com.test.system.api.entity.SysUser;
//import com.test.system.entity.SysUser;
import com.test.system.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录管理")
@RestController
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
    @Autowired
    private AuthService authService;

    @Autowired
    private UserServiceI userService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public Result<?> createAuthenticationToken(String username,String password) 
    		throws AuthenticationException{
        logger.info("登陆：" +username);
        final String token = authService.login(username,password);
        return Result.success(token);
    }
 
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/auth/refresh", method = RequestMethod.GET)
    public Result<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(CommonConst.ACCESS_TOCKEN);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return Result.err();
        } else {
        	return Result.success(refreshedToken);
        }
    }
 
    @ApiOperation(value = "注册")
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public Result<SysUser> register(@RequestBody SysUser addedUser) throws AuthenticationException{
        logger.info("注册：" +addedUser.getUserName());
        return Result.success(authService.register(addedUser));
    }
    
    @ApiOperation(value = "是否登录")
    @RequestMapping(value = "auth/isLogin", method = RequestMethod.POST)
    public Boolean isLogin() throws AuthenticationException{
        return true;
    }

    @ApiOperation(value = "获取用户名")
    @RequestMapping(value="/auth/getUserName", method = RequestMethod.GET)
    @ResponseBody
    public String login() {
        SysUser user = userService.selectById(1);
        return user.getUserName();
    }

}

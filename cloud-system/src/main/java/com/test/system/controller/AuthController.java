package com.test.system.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.system.api.entity.SysUser;
//import com.test.system.entity.SysUser;
import com.test.system.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录管理")
@RestController
public class AuthController {
	
    private String tokenHeader = "Authorization";
 
    @Autowired
    private AuthService authService;
 
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(String username,String password) 
    		throws AuthenticationException{
        final String token = authService.login(username,password);
        // Return the token
//        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        return ResponseEntity.ok(token);
    }
 
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/auth/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        	return ResponseEntity.ok(refreshedToken);
        }
    }
 
    @ApiOperation(value = "注册")
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public SysUser register(@RequestBody SysUser addedUser) throws AuthenticationException{
        return authService.register(addedUser);
    }
    
    @ApiOperation(value = "是否登录")
    @RequestMapping(value = "auth/isLogin", method = RequestMethod.POST)
    public Boolean isLogin() throws AuthenticationException{
        return true;
    }

}

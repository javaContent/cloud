package com.test.system.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.test.common.constant.CommonConst;
import com.test.common.enums.ErrorCodeEnum;
import com.test.common.exception.BusinessException;
import com.test.frame.helper.RedisClient;
import com.test.system.api.entity.SysUser;
import com.test.system.dao.UserDaoI;
import com.test.system.entity.AuthUser;
//import com.test.system.entity.SysUser;
import com.test.system.service.AuthService;
import com.test.system.util.JwtTokenUtil;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private UserDetailsService userDetailsService;
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	@Autowired
    private UserDaoI userDao;
	@Autowired
	RedisClient redisClient;
 
    @Override
    public SysUser register(SysUser userToAdd) {
        final String username = userToAdd.getUserName();
        if(userDao.findByUserName(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        return userDao.save(userToAdd);
    }
 
    @Override
    public String login(String username, String password) {
    	try {
	        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
	        // Perform the security
	        final Authentication authentication = authenticationManager.authenticate(upToken);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        // Reload password post-security so we can generate token
	        final AuthUser authUser = (AuthUser) userDetailsService.loadUserByUsername(username);
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	        
	        request.getSession().setAttribute(CommonConst.SESSION_USER,authUser);
	        SysUser user = new SysUser();
	        BeanUtils.copyProperties(authUser, user);
	        
	        final String token = jwtTokenUtil.generateToken(authUser);
	        redisClient.setValue(CommonConst.SESSION_USER + "_" +token, user, CommonConst.SESSION_TIME);
	        
	        return token;
    	} catch (Exception e) {
			throw new BusinessException(ErrorCodeEnum.LOGIN_ERR, "登陆失败");
		}
    }
 
    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(CommonConst.tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        AuthUser user = (AuthUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        throw new BusinessException(ErrorCodeEnum.LOGIN_ERR, "token刷新失败");
    }

}

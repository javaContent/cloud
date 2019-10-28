package com.test.system.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.system.dao.UserDaoI;
import com.test.system.entity.SysUser;
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
 
//    @Value("${jwt.tokenHead}")
    private String tokenHead = "Bearer";
 
 
    @Override
    public SysUser register(SysUser userToAdd) {
        final String username = userToAdd.getUsername();
        if(userDao.findByUserName(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
//        userToAdd.setRoles(asList("ROLE_USER"));
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
	        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        final String token = jwtTokenUtil.generateToken(userDetails);
	        return token;
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
 
    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        SysUser user = (SysUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

}

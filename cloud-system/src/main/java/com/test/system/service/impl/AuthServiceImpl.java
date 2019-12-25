package com.test.system.service.impl;

import com.test.common.constant.CommonConst;
import com.test.common.enums.ErrorCodeEnum;
import com.test.common.exception.BusinessException;
import com.test.frame.helper.UserInfoHelper;
import com.test.system.api.entity.SysUser;
import com.test.system.dao.operation.OperationUserDaoI;
import com.test.system.dao.query.QueryUserDaoI;
import com.test.system.entity.AuthUser;
import com.test.system.rabbitMq.sender.RabbitMQSend;
import com.test.system.service.AuthService;
import com.test.system.util.JwtTokenUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//import com.test.system.entity.SysUser;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private UserDetailsService customUserService;
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	@Autowired
    private QueryUserDaoI queryUserDao;
    @Autowired
    private OperationUserDaoI operationUserDao;

	@Autowired
	UserInfoHelper userInfoHelper;

    @Autowired
    RabbitMQSend rabbitMQSend;
 
    @Override
    public SysUser register(SysUser userToAdd) {
        final String username = userToAdd.getUserName();
        if(queryUserDao.findByUserName(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        rabbitMQSend.SendMsg(userToAdd);
        operationUserDao.save(userToAdd);
        return userToAdd;

    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
    	try {
	        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
	        // Perform the security
	        final Authentication authentication = authenticationManager.authenticate(upToken);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        // Reload password post-security so we can generate token
	        final AuthUser authUser = (AuthUser) customUserService.loadUserByUsername(username);
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

	        request.getSession().setAttribute(CommonConst.SESSION_USER,authUser);
	        SysUser sysUser = new SysUser();
	        BeanUtils.copyProperties(authUser, sysUser);

	        final String token = jwtTokenUtil.generateToken(authUser);
	        userInfoHelper.setUserByToken(token, sysUser);
	        return token;
    	} catch (Exception e) {
			throw new BusinessException(ErrorCodeEnum.LOGIN_ERR, "登陆失败");
		}
    }
 
    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(CommonConst.tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        AuthUser user = (AuthUser) customUserService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        throw new BusinessException(ErrorCodeEnum.LOGIN_ERR, "token刷新失败");
    }

}

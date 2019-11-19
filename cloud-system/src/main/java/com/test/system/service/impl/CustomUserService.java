package com.test.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.system.api.entity.SysRole;
import com.test.system.api.entity.SysUser;
import com.test.system.dao.UserDaoI;
import com.test.system.entity.AuthUser;

public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDaoI userDao;
	
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userDao.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        SysRole role = new SysRole();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        List<SysRole> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUserName()+";password:"+user.getPassword());
        System.out.println("size:"+user.getRoles().size());
        System.out.println("role:"+user.getRoles().get(0).getName());
        
        AuthUser authUser = new AuthUser();
        BeanUtils.copyProperties(user, authUser);
        return authUser;
    }

}

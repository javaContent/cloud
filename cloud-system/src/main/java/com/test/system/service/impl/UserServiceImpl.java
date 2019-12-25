package com.test.system.service.impl;

import com.test.system.dao.operation.OperationUserDaoI;
import com.test.system.dao.query.QueryUserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.system.api.entity.SysUser;
//import com.test.system.entity.SysUser;
import com.test.system.service.UserServiceI;


@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private QueryUserDaoI queryUserDao;
	@Autowired
	private OperationUserDaoI operationUserDao;
	
	@Override
	public SysUser selectById(Integer id) {
		try {
			queryUserDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryUserDao.selectById(id);
	}

	@Override
	public SysUser login(String username, String password) {
		SysUser u = queryUserDao.login(username, password);
		return u;
	}

	@Override
	public SysUser register(SysUser sysUser) {
		operationUserDao.save(sysUser);
		return sysUser;
	}

}
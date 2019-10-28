package com.test.system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.test.system.entity.SysUser;


@Mapper
public interface UserDaoI {
	
	public SysUser selectById(Integer id);
	
	public SysUser login(@Param(value="userName") String userName, @Param(value="password") String password);
	
	public SysUser findByUserName(String userName);
	
	public SysUser save(SysUser sysUser);

}

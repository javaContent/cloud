package com.test.system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.test.system.entity.User;


@Mapper
public interface UserDaoI {
	
	public User selectById(Integer id);
	
	public User login(@Param(value="userName") String userName, @Param(value="password") String password);

}

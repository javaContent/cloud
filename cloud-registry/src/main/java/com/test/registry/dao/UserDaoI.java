package com.test.registry.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.registry.entity.User;

@Mapper
public interface UserDaoI {
	
	public User selectById(Integer id);

}

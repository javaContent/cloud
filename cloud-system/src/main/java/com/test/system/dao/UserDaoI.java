//package com.test.system.dao;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import com.test.system.api.entity.SysUser;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@Mapper
//public interface UserDaoI {
//
//	public SysUser selectById(Integer id);
//
//	public SysUser login(@Param(value="userName") String userName, @Param(value="password") String password);
//
//	public SysUser findByUserName(String userName);
//
//	public int save(SysUser sysUser);
//
//	public List<SysUser> queryList();
//
//}

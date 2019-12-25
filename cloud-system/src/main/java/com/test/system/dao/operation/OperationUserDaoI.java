package com.test.system.dao.operation;

import com.test.system.api.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OperationUserDaoI {
	
	public int save(SysUser sysUser);

	public int delete(Integer userId);

	public int update(SysUser sysUser);

}

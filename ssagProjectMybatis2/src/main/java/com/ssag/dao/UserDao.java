package com.ssag.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssag.model.UserVo;

@Mapper
@Repository("userDao")
public interface UserDao {
	
	public void insertUser(UserVo userVo) throws DataAccessException;
	UserVo readAccount(String id) throws DataAccessException;

	
}

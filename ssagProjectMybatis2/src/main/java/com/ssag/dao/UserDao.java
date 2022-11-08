package com.ssag.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssag.model.UserVo;
import com.ssag.sercurity.service.CustomUserDetails;

@Mapper
@Repository("userDao")
public interface UserDao {
	
	public void insertUser(UserVo userVo) throws DataAccessException;
	UserVo readAccount(String id) throws DataAccessException;
	CustomUserDetails getUserById(String id) throws DataAccessException;

	
}

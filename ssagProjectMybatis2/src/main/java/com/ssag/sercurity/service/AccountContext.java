package com.ssag.sercurity.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ssag.model.UserVo;

import lombok.Data;

@Data
public class AccountContext extends User{

	private UserVo userVo;
	
	public AccountContext(UserVo userVo, List<GrantedAuthority> roles) {
		super(userVo.getId(),userVo.getPassword(), roles);
		this.userVo = userVo;
	}
	
	public UserVo getUserVo() {
		return userVo;
	}
	
}

package com.ssag.sercurity.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ssag.model.UserVo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class AccountContext extends User{

	
	private UserVo userVo;
	private CustomUserDetails userDetails;
	
	public AccountContext(UserVo userVo, List<GrantedAuthority> roles) {
		super(userVo.getId(),userVo.getPassword(), roles); //security user를 구현한 것
		this.userVo = userVo;
	}

	@Override
	public String toString() {
		return "AccountContext [userVo=" + userVo + ", userDetails=" + userDetails + "]";
	}

	
	
//	public AccountContext(CustomUserDetails userDetails) {
//		super(userDetails.getName(),userDetails.getPassword(), userDetails.getAuthorities()); //security user를 구현한 것
//		this.userDetails = userDetails;
//	}
	
//	public UserVo getUserVo() {
//		return userVo;
//	}
//	
}

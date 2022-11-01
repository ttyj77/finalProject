package com.ssag.sercurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssag.dao.UserDao;
import com.ssag.model.UserVo;
import com.ssag.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsSercive implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		UserVo userVo = userService.findById(id);
		System.out.println("USerDetailsService FindByID "+userVo);
//		Account account = userRepository.findById(id);
		
		if(userVo == null) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(userVo.getRole()));
		
		AccountContext accountContext = new  AccountContext(userVo, roles);
		
		return accountContext;
	}

}

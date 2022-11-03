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
		
//		UserVo userVo = userService.findById(id);
		UserVo op = userService.findById(id);
		
		System.out.println("USerDetailsService FindByID "+op);
//		Account account = userRepository.findById(id);
		
		if(op == null) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(op.getRole()));
		
		AccountContext accountContext = new  AccountContext(op, roles);
//		accountContext.getUserVo();
		
		System.out.println("이렇게 하면 accountContext에 뭐가 담길까" + accountContext.getUserVo().getName());
		System.out.println("USerDetailsService FindByID "+op.getName());
		
		return accountContext;
	}

}
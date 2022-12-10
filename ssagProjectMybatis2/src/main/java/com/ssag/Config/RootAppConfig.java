package com.ssag.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.ssag.model.UserVo;

@Configuration
public class RootAppConfig {

	@Bean("loginUserBean")
	@SessionScope
	public UserVo loginUserBean() {
		return new UserVo();
	}
	
	
	
}

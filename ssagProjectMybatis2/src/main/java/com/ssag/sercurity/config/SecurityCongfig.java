package com.ssag.sercurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssag.sercurity.provider.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityCongfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationDetailsSource authenticationDetailsSource;
	
//	@Bean
//	public BCryptPasswordEncoder encodePwd() {
//		return new BCryptPasswordEncoder();
//	}
//	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 

		http.authorizeRequests()
				.antMatchers("/","/users","/index","/ingredientList","/myFridgeBox")
				.permitAll()
				.antMatchers("/css/**","/js/**","/image/**", "/fonts/**").permitAll()
				.antMatchers("/mypage").hasRole("USER")
				.antMatchers("/messages").hasRole("MANAGER")
				.antMatchers("/config").hasAnyRole("ADMIN","1")
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.authenticationDetailsSource(authenticationDetailsSource)
				.defaultSuccessUrl("/afterLogin")
				.permitAll();

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new CustomAuthenticationProvider();
	}
}

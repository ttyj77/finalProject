package com.ssag.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ssag.config.auth.PrincipalDetails;
import com.ssag.dao.UserDao;
import com.ssag.model.UserVo;

//시큐리티가 filter가지고 있는데 그 중에 BasicAuthenticationFilter 라는 것이 있음
//권한이나 인증이 필요한 특정 주소를 요청했을 때 위 필터를 무조건 타게되어있음
//만약 권한이 인증이 필요한 주소가 아니면 이 필터를 안탄다.
public class JwtAuthorizationFilter extends BasicAuthenticationFilter{

	private UserDao userDao;
	@Autowired
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager,UserDao userDao) {
		super(authenticationManager);
		this.userDao = userDao;
		
	}

	//인증이나 권한이 필요한 주소요청이 있을 때 해당 필터를 타게됨
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		super.doFilterInternal(request, response, chain);
		System.out.println("인증이나 권한이 필요한 주소");
		
		String jwtHeader = request.getHeader("Authorization");
		System.out.println("jwtHeader : "+ jwtHeader);
		
		//Header가 있는지 확인
		if(jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
			chain.doFilter(request, response);
			return;
		}
		
		//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
		String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
		String username = JWT.require(Algorithm.HMAC512("cos")).build().verify(jwtToken).getClaim("username").asString();
		
		// 사용자가 인증이 되었기 때문에 강제로 만들어도 됨 (서명이 정상적으로 됨)
		if(username != null) {
			UserVo userVo = userDao.findByUsername(username);
			PrincipalDetails principalDetails = new PrincipalDetails(userVo);
			
			// Jwt 토큰 서명을 통해서 서명이 정상이면 Authentication객체를 만들어 준다.						  비번 null  해도 됨
			Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null,principalDetails.getAuthorities());
			
			//강제로 시큐리티의 세션에 접근해서 Authenticaion 객체를 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			chain.doFilter(request, response);
		}
		
		
	}
}

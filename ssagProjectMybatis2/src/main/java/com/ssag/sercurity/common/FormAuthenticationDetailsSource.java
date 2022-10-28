package com.ssag.sercurity.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class FormAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>{

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		// TODO Auto-generated method stub
		return new FormWebAuthenticationDetails(context);
	}

}

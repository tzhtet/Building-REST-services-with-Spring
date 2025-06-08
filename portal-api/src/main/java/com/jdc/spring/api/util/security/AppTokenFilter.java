package com.jdc.spring.api.util.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AppTokenFilter  extends OncePerRequestFilter {
	
	private final AppTokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {		
		
		var token = request.getHeader("Authorization");
		
		if(StringUtils.hasLength(token)) {
			var authorization = tokenProvider.parseAccessToken(token);
			
			if(null != authorization) {
				SecurityContextHolder.getContext()
				.setAuthentication(authorization);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	

}

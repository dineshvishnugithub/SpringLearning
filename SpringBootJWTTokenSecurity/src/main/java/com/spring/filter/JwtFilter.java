package com.spring.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.security.CustomUserDetailService;
import com.spring.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
    private JwtUtil objJwtUtil;
	
	@Autowired
	CustomUserDetailService objUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {

	  String authorizationHeader = httpServletRequest.getHeader("Authorization");
	  String token = null;
	  String userName = null;
	  if(null!=authorizationHeader && authorizationHeader.startsWith("Bearer")) {
		  token = authorizationHeader.substring(7);
		  userName = objJwtUtil.extractUsername(token);
	  }
	  if(null!=userName && SecurityContextHolder.getContext().getAuthentication()==null) {
		  UserDetails objUser = objUserDetailsService.loadUserByUsername(userName);
		  if(objJwtUtil.validateToken(token, objUser)) {
			  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(objUser.getUsername(), null, objUser.getAuthorities());
			  usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
			  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		  }
	  }
	  filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

}

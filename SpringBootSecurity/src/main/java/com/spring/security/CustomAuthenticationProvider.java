package com.spring.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		System.out.println("CustomAuthenticationProvider name:: " + name);
		System.out.println("CustomAuthenticationProvider pwd:: " + pwd);
		
		//custom pwd chk login
		if("dinesh".equals(name) && "1234".equals(pwd)) {
			Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
			Authentication custAuth = new UsernamePasswordAuthenticationToken(name, pwd, authorities);
			System.out.println("CustomAuthenticationProvider custAuth:: " + custAuth);
			return custAuth;
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

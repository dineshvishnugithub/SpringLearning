package com.spring.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		if(name.equals("vishnu")) {
			roles=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			
			// set default undecrypted pwd and set it and it will fail as it is not decrytped pwd
			//will get below logs
			//2021-03-29 08:18:28.668  WARN 10592 --- [nio-8084-exec-3] o.s.s.c.bcrypt.BCryptPasswordEncoder     : Encoded password does not look like BCrypt
//			return new User(name, "myPwd", roles);
			
			//so now setting the encrypted password
			BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
			String password = pwdEncoder.encode("1234");
			return new User(name, password, roles);			
		}
		
		throw new UsernameNotFoundException("User not found" + name);
	}

}

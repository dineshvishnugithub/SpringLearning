package com.spring.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.entity.CustomUser;
import com.spring.repository.CustomDaoRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	CustomDaoRepository objCustomDaoRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		CustomUser objUser = objCustomDaoRepository.findByUserName(userName);
		return new User(objUser.getUserName(), objUser.getPassword(), new ArrayList<>());
	}

}

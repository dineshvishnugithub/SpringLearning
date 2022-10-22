package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CustomDao;
import com.spring.entity.Users;

@Service
public class CustomService {
	
	@Autowired
	CustomDao objDao;
	
	public Users addUser(Users objUser) {
		return objDao.save(objUser);
	}
	
	public List<Users> getUsers(){
		List<Users> objUserList = objDao.findAll();
		return objUserList;
	}
	
	public void deleteUser(Users user) {
		objDao.delete(user);
	}
	
	public Users findUserByName(String name) {
		return objDao.findByName(name);
	}

}

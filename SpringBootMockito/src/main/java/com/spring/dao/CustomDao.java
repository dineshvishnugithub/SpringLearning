package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Users;

public interface CustomDao extends JpaRepository<Users, Integer>{
   
	Users findByName(String name);
}

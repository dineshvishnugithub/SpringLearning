package com.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Employees;

@Repository
public interface DataRepositoryInterface extends JpaRepository<Employees, Integer>{
	
	Page<Employees> findByEmployeeIdContaining(int employeeId, Pageable pageable);
	
	Page<Employees> findByManagerIdContaining(int employeeId, Pageable pageable);    
}

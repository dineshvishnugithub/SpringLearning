package com.spring.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.hibernate.annotations.Type;
import java.lang.Integer;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
 
    @Id
    @Column(name = "EMPLOYEE_ID", unique=true, nullable = false)
	private int employeeId;
    
    @Column(name = "FIRST_NAME", nullable = true)
	private String firstName;
    
    @Column(name = "LAST_NAME", nullable = false)
	private String lastName;
    
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phoneNumber;
    
    @Column(name = "HIRE_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate hireDate;
    
    @Column(name = "JOB_ID", unique=true, nullable = false)
    private String jobID;
    
    @Column(name = "SALARY", nullable = true)    
    private BigDecimal salary;
    
    @Column(name = "COMMISSION_PCT", nullable = true)    
    private BigDecimal commissionPct;
    
    @Column(name = "MANAGER_ID")
    private java.lang.Integer managerId;
    
    @Column(name = "DEPARTMENT_ID")
    private java.lang.Integer departmentId;
    
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getHireDate() {
		System.out.println("hireDate:: " + hireDate);
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}
	public java.lang.Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(java.lang.Integer managerId) {
		this.managerId = managerId;
	}
	public java.lang.Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(java.lang.Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate hireDate, String jobID, BigDecimal salary, BigDecimal commissionPct, java.lang.Integer managerId, java.lang.Integer departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobID = jobID;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	
	public Employee(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	public Employee() {
		super();
	}
}

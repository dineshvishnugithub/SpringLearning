package com.spring.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class EmployeesPOJO {
    
	@Value("${employeeId}")
	private int employeeId;
	@Value("${firstName}")
	private String firstName;
	@Value("${lastName}")
	private String lastName;
	@Value("${email}")
    private String email;
	@Value("${phoneNumber}")
    private String phoneNumber;
	@Value("${hireDate}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date hireDate;
	@Value("${jobID}")
    private String jobID;
	@Value("${salary}")
    private BigDecimal salary;
	@Value("${commissionPct}")
    private BigDecimal commissionPct;
	@Value("${managerId}")
    private int managerId;
	@Value("${departmentId}")
    private int departmentId;
    
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
	public Date getHireDate() {
		System.out.println("hireDate:: " + hireDate);
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public EmployeesPOJO(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			Date hireDate, String jobID, BigDecimal salary, BigDecimal commissionPct, int managerId, int departmentId) {
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
	
	public EmployeesPOJO(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public EmployeesPOJO(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public EmployeesPOJO() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}

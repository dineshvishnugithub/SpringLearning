package com.spring.lesson.date;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerDate {
	
	private Date objDate;
	private BigDecimal objSalary;
	private String objStringDate;
	private long objLongDate;
	private java.sql.Date objSqlDate;

	public CustomerDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDate(Date objDate) {
		super();
		this.objDate = objDate;
	}

	public Date getObjDate() {
		return objDate;
	}

	public void setObjDate(Date objDate) {
		this.objDate = objDate;
	}

	public BigDecimal getObjSalary() {
		return objSalary;
	}

	public void setObjSalary(BigDecimal objSalary) {
		this.objSalary = objSalary;
	}

	public String getObjStringDate() {
		return objStringDate;
	}

	public void setObjStringDate(String objStringDate) {
		this.objStringDate = objStringDate;
	}
	
	public long getObjLongDate() {
		return objLongDate;
	}

	public void setObjLongDate(long objLongDate) {
		this.objLongDate = objLongDate;
	}

	public java.sql.Date getObjSqlDate() {
		return objSqlDate;
	}

	public void setObjSqlDate(java.sql.Date objSqlDate) {
		this.objSqlDate = objSqlDate;
	}
}

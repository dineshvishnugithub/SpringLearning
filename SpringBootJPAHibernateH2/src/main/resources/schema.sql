 DROP TABLE IF EXISTS EMPLOYEES;
 
 CREATE TABLE EMPLOYEES( 
    EMPLOYEE_ID INT PRIMARY KEY, 
	FIRST_NAME VARCHAR(250) NOT NULL, 
	LAST_NAME VARCHAR(250) NOT NULL,
	EMAIL VARCHAR(250) NOT NULL,
	PHONE_NUMBER VARCHAR(250) NOT NULL,
	HIRE_DATE DATE, 
	JOB_ID VARCHAR(250) default null, 
	SALARY DOUBLE,
	COMMISSION_PCT DOUBLE, 
	MANAGER_ID INT, 
	DEPARTMENT_ID INT
  );
 alter table employees add constraint EMPID unique (employee_id);
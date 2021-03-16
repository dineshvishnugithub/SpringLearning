package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDAOImplementation extends AbstractDAO implements EmployeeDao {

    public void saveEmployee(Employee employee) {
        persist(employee);
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }
 
    public void deleteEmployeeByEmployeeId(int empId) {
        Query query = getSession().createSQLQuery("delete from Employees where employee_id = :empId");
        query.setInteger("empId", empId);
        query.executeUpdate();
    }
 
     
    public Employee findByEmployeeId(int empId){
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("employeeId",empId));
        return (Employee) criteria.uniqueResult();
    }
     
    public void updateEmployee(Employee employee){
        getSession().update(employee);
    }

}

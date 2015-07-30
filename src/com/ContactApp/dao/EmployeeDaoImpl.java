package com.ContactApp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.mail.event.ConnectionEvent;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ContactApp.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
	}
	public boolean LoginEmployee(String Emp_User_Name , String Emp_User_Pwd){
		
		boolean b = false;
		
		List<Employee> emp =new ArrayList<Employee>();
		
	//	sessionFactory.getCurrentSession().createQuery("")
		
		
		
		return b;
	}
}
package com.ContactApp.dao;

import java.util.List;

import com.ContactApp.model.Employee;


public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
	
	public boolean LoginEmployee(String Emp_User_Name , String Emp_User_Pwd);
}

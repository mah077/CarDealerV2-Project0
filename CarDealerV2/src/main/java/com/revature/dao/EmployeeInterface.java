package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeInterface {

	public void addEmployee(Employee e);
	
	public void removeEmployee(int i);
	
	public void viewOneEmployee(int i);
	
	public List<Employee> getAllEmployee();
	
	public void viewOffers();
	
	
}

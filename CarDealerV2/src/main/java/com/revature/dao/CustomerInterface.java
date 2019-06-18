package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerInterface {

	public void addCustomer(Customer c);
	
	public void removeCustomer(int i);
	
	public void viewOwneCar(int i);
	
	public List<Customer> getAllCustomers();
	
	
	
}

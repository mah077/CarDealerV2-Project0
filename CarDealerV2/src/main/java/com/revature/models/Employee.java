package com.revature.models;


public class Employee extends Person {
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	private  int employeeID;
	
	public Employee( int employeeID, String fname, String lname, String username, String password) {
		super(fname, lname, username, password);
		 this.employeeID=employeeID;
	}

	public Employee() {
		
	}

	public int getEmployeeID() {
		return employeeID;
	}

	
	
	}
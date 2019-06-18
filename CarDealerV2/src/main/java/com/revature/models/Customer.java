package com.revature.models;

public class Customer extends Person{

	private  int customerID;
	
		public Customer(int customerID,String fname, String lname, String username, String password) {
		super(fname, lname, username, password);
		this.customerID=customerID;
	}

	


	public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}




	public Customer() {
		super();
		
	}

	public int getCustomerID() {
		return customerID;
	}
	
}

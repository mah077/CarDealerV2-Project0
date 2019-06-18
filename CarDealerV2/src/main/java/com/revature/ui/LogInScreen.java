package com.revature.ui;

import java.util.Scanner;
import com.revature.dao.CustomerDao;
import com.revature.dao.EmployeeDao;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.Services;
import com.revature.util.LoggingUtil;

public class LogInScreen {
	public static Employee emp=new Employee();
	public static Customer cust=new Customer();
	public static EmployeeDao ed= new EmployeeDao();
	public static CustomerDao cd=new CustomerDao();
	public static MainScreen ms=new MainScreen();
	public static EmployeeScreen es=new EmployeeScreen();
	public static CustomerScreen cs=new CustomerScreen();
	public static Services s=new Services();
	
	char checkchoice;
	private static Scanner input;
	public static Customer c=new Customer();
	
	public void CreateAccount() {
		LoggingUtil.trace("Creating account");
		input = new Scanner(System.in);
	
		int checkUser;
		String checkpass;
		System.out.println("**********************************************************************");
		System.out.println("\tWELCOME TO HIAZI CARDEALER COMPANY...:)");
		System.out.println("**********************************************************************\n\n");
		System.out.println("***********************************PRESS '1' EMPLOYEE ACCOUNT"
				+ "\n***********************************PRESS'2'CUSTOMER ACCOUNT"
				+ "\n***********************************PRESS '3' GO BACK\nPRESS HERE:");
		do { 
			checkUser=input.nextInt();
			switch(checkUser) {	
			case 1:
				System.out.println("Enter an ID");
				System.out.print(">>>>>");emp.setEmployeeID(input.nextInt());
				System.out.println("Enter you first name:");
				System.out.print(">>>>>");emp.setFname(input.nextLine());
				System.out.print(">>>>>");emp.setFname(input.nextLine());
				System.out.println("Enter you last name:");
				System.out.print(">>>>>");emp.setLname(input.nextLine());
				do{System.out.println("Enter your email(employee@emp.com):");
				emp.setUsername(input.nextLine());}while(!emp.getUsername().contains("@emp.com"));
				do{System.out.println("Enter you password:");
				System.out.print(">>>>>");emp.setPassword(input.nextLine());
				System.out.println("re-enter your password:");	
				System.out.print(">>>>>");checkpass=input.nextLine();
				
				ed.addEmployee(emp);
			
				if(!emp.getPassword().equals(checkpass)) System.out.println("Passwords Not matched");			
				}while(!emp.getPassword().equals(checkpass));
				
					EmpCheckLogin();  break;
			case 2:
				System.out.println("Enter an ID");
				System.out.print(">>>>>");cust.setCustomerID(input.nextInt());
				System.out.println("Enter you first name:");
				System.out.print(">>>>>");cust.setFname(input.nextLine());
				System.out.print(">>>>>");cust.setFname(input.nextLine());
				System.out.println("Enter you last name:");
				System.out.print(">>>>>");cust.setLname(input.nextLine());
				do{System.out.println("Enter your email(customer@cust.com):");
				System.out.print(">>>>>");cust.setUsername(input.nextLine());}while(!cust.getUsername().contains("@cust.com"));
				
				do{System.out.println("Enter you password:");
				System.out.print(">>>>>");cust.setPassword(input.nextLine());
				System.out.println("re-enter your password:");
				System.out.print(">>>>>");checkpass=input.nextLine();
				if(!cust.getPassword().equals(checkpass)) System.out.println("Passwords Not matched");			
				}while(!cust.getPassword().equals(checkpass));
				cd.addCustomer(cust);
				CustCheckLogin();	
				 break;		
		
			
			case 3:   ms.pageoneScreen();
					break;
			
			default : System.out.println("Invalid choise");		}
		}while(checkUser!=1 && checkUser!=2 && checkUser!=3);	
	}// end method create account

	public void CheckLogin()
	{
		
		
		input = new Scanner(System.in);
		int checkans;
		System.out.println("\t\t===============================");
		System.out.println("\n\t\t\tWELCOME BACK\n");
		System.out.println("\t\t===============================");
		System.out.println("***********************************1-PRESS '1' EMPLOYEE"
				+ "\n***********************************2-PRESS '2' CUSTOMER"
				+ "\n***********************************3-PRESS '3' GO BACK TO THE PAGE ");
		do{	System.out.print(">>>>>");checkans=input.nextInt();
		
		switch(checkans) {
		case 1:  EmpCheckLogin();	break;	
		case 2:  CustCheckLogin();	break;	
		case 3:  ms.pageoneScreen();	break;	
		default: System.out.println("Invalid choice\n***********************************1-PRESS '1' EMPLOYEE"
				+ "\n***********************************2-PRESS '2' CUSTOMER"
				+ "\n***********************************3-PRESS '3' GO BACK TO THE PAGE");}
		
		}while(checkans!=1 && checkans!=2&& checkans!=3);
		
		
	}// end method check in		
	

	private void CustCheckLogin() {
		LoggingUtil.trace("Customer log in");
		input = new Scanner(System.in);
		System.out.println("Customer Login Page");
		String email;	String pass;	
		int i=0;//counter from tries
	  do {  System.out.println("Email: ");
		System.out.print(">>>>>");email=input.nextLine(); c.setUsername(email);
		if(email.isEmpty()) {System.out.println("\n\nNo Dont put empty email"); break; }
		System.out.println("Passowrd");
		System.out.print(">>>>>");pass=input.nextLine();
	    i++; 
	    if (s.checkUserCust(email, pass)==false) {
	    	System.out.println("Invalid Username or Pass"); 
	    	System.out.println(i);
	    }
	    else {  cs.choosechoice();// go to customer screen
	   	       break; }	   
	  }while(i<4);
	  ms.pageoneScreen();
	}

	private void EmpCheckLogin() {
		LoggingUtil.trace("Employee log in");
		input = new Scanner(System.in);
		System.out.println("Employee Login Page");
		String email;	String pass;	
		int i=0;//counter from tries
		
		  do {System.out.println("Email: ");
			System.out.print(">>>>>");email=input.nextLine();
			if(email.isEmpty()) {System.out.println("\n\nNo Dont put empty email"); break; }
			System.out.println("Passowrd");
			System.out.print(">>>>>"); pass=input.nextLine();
		    i++; 
		    if (s.checkUserEmp(email, pass)==false) {
		    	System.out.println("Invalid Username or Pass"); 
		    
		    }
		    else {  es.choosechoice();;// go to employee screen
		   	       break; }	   
		  }while(i<4);
		  ms.pageoneScreen();   
		}

	   
	  
	
}
	


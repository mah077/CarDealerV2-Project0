package com.revature.ui;

import java.util.Scanner;
import com.revature.dao.CustomerDao;
import com.revature.dao.EmployeeDao;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.LoggingUtil;

public class MainScreen {
	public static LogInScreen lis=new LogInScreen();
	public static Employee emp=new Employee();
	public static Customer cust=new Customer();
	public static EmployeeDao ed= new EmployeeDao();
	public static CustomerDao cd=new CustomerDao();
	char checkchoice;
	private static Scanner input;
	
	public void pageoneScreen() {
		
		input = new Scanner(System.in);
		do { LoggingUtil.trace("First page");
			System.out.println("Please choose the following letters:\n"
					+"***********************************1-PRESS 'y' to LOGIN\n"
					+"***********************************2-PRESS 'n' to CREATE ACCOUNT '\n"
					+"***********************************3-PRESS 'e' to EXIT"
					+ "\nPRESS HERE:");
			System.out.print(">>>>>");
			checkchoice=input.next().charAt(0);			
			switch(checkchoice){	
			case 'y':  lis.CheckLogin(); 	break;
			case 'n': lis.CreateAccount(); break;
			case 'e': System.out.println("You have Exited \n"); 
						System.out.println("Thank you for visiting");						
						System.exit(1); break;				
			default : System.out.println("Invalid Choice");
			}// end switch			
		}while(checkchoice!='y' && checkchoice!='n' && checkchoice!='e' );
	  }	//end method pageoneScreen

}

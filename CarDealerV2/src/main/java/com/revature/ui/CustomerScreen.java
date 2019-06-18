package com.revature.ui;

import java.util.Scanner;

import com.revature.dao.CarDao;
import com.revature.dao.CustomerDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.OfferDao;
import com.revature.models.Offer;
import com.revature.services.CarLotservice;

public class CustomerScreen {
	public static MainScreen ms=new MainScreen();
	public static OfferDao od=new OfferDao();
	public static CarDao card=new CarDao();
	public static CustomerDao cd=new CustomerDao();
	public static CarLotservice cls=new CarLotservice();
	public static EmployeeDao ed =new EmployeeDao();
	
	public static char choice;
	public static Scanner input;

	public void choosechoice() {
		 input= new Scanner(System.in);
		 System.out.println("Customer Side");
		 do {	 System.out.println("Please choose one of the following\n"
		 		+ "***********************************Case 1: view Cars"
		 		+ "\n***********************************Case 2: Make Offer"
		 		+ "\n***********************************Case 3: View your Car"
		 		+ "\n***********************************Case 4: view offer result"
		 		+ "\n***********************************Case 5: LOG-OUT"
		 		+ "\n***********************************Enter you choice: ");
		 
		 System.out.print(">>>>>");choice=input.next().charAt(0);
		 
		 switch(choice) {
		 
		 
		case '1' : viewCars(); break;
			
		case '2' : MakeOffer(); break;
			
		case '3' : viewyourCars(); break;
		
		case '4': offerResult(); break;
	
		case '5' : System.out.println("You have Exited"); ms.pageoneScreen(); break;
			
		default: System.out.println("Ivalid choice");
		 }						 
		 }while(choice!='1' && choice!='2' && choice!='3' && choice!='4' && choice!='5' );
		
	}

	private void viewyourCars() {
		input =new Scanner(System.in);
		System.out.println("Enter you ID");
		System.out.print(">>>>>");	int i=input.nextInt();
		card.viewOneCar(i);
		choosechoice();
	}

	private void offerResult() {
		input=new Scanner(System.in);
		System.out.println("please inter your id");
		System.out.print(">>>>>");int i=input.nextInt();
		cd.viewOwneCar(i);// view his offer i should change the name latter
		//od.viewOwnerOffer(i);
		choosechoice();
		
	}


	private void MakeOffer() {
		input=new Scanner(System.in);
		System.out.println("Put the car ID you would like to make an Offer");
		System.out.print(">>>>>");int z=input.nextInt();
		System.out.println("Enter you ID");
		System.out.print(">>>>>");int y=input.nextInt();
		System.out.println("Enter your price");
		System.out.print(">>>>>");double x=input.nextDouble();
		System.out.println();
		od.AddOffer(new Offer(z,y,x));
		choosechoice();
		
	}

	private void viewCars() {
		card.getAllCars();
		choosechoice();
	}

}

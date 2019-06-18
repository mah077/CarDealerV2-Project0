package com.revature.ui;


import java.util.Scanner;

import com.revature.dao.CarDao;
import com.revature.dao.CustomerDao;
import com.revature.dao.EmployeeDao;
import com.revature.dao.OfferDao;
import com.revature.models.Car;
import com.revature.services.CarLotservice;
import com.revature.services.OfferService;




public class EmployeeScreen {
	private static char choice;
	private static Scanner input;
	public static MainScreen ms=new MainScreen();
	public static OfferDao od=new OfferDao();
	public static CarDao card=new CarDao();
	public static CustomerDao cd=new CustomerDao();
	public static CarLotservice cls=new CarLotservice();
	public static EmployeeDao ed =new EmployeeDao();
	public static OfferService os= new OfferService();
	
	public void choosechoice() {
		 input= new Scanner(System.in);
		 System.out.println("Employee Side");
		 do {	
			 System.out.println("Please choose one of the following\n"
		 		+ "***********************************Case 1: view Cars"
		 		+ "\n***********************************Case 2: Add Car"
		 		+ "\n***********************************Case 3: Remove Car"
		 		+ "\n***********************************Case 4: view Offer"
		 		+ "\n***********************************Case 5: view Payments"
		 		+ "\n***********************************Case 6: View customers"
		 		+ "\n***********************************Case 7: LOG-OUT"
		 		+ "\n***********************************Enter you choise: ");
		 
				System.out.print(">>>>>");choice=input.next().charAt(0);
		 
		 switch(choice) {
		 
		 
		case '1' : viewCars(); break;
			
		case '2' : addCar(); break;
			
		case '3' : removeCar(); break;
			
		case '4' : viewtOffers(); break;
		
		case '5' : viewAllPayments(); break;
		
		case '6' : viewCustomers(); break;
			
		case '7' : System.out.println("You have Exited"); ms.pageoneScreen(); break;
			
		default: System.out.println("ivalid choice");
		 }						 
		 }while(choice!='1' && choice!='2' && choice!='3' && choice!='4' && choice!='5' && choice!='6' && choice!='7' );
		
	}


	private void viewAllPayments() {
		System.out.println("Payments Table:");
		od.viewAllPaiments();
		choosechoice();
	}


	private void viewCustomers() {
		cd.getAllCustomers();
		choosechoice();
	}


	private void viewtOffers() {
		input=new Scanner(System.in);
		od.getAllOffers(); 
		
		System.out.println("\nwould you like to accept offers? '1' yes '2' no");
		System.out.print(">>>>>");int x=input.nextInt();
		if(x==1) {  
			System.out.println("What Offer you wanna accept ?");
			System.out.print(">>>>>");
			int a=input.nextInt();
			System.out.println("please type accept or reject. press any key to leave");
			System.out.print(">>>>>");
			String st=input.nextLine();
			st=input.nextLine();
			
			if(st.equals("accept"))  {	
				os.acceptOffer(a, st);
				System.out.println("Offer is "+st+"ed");
				choosechoice();
			}
				else if(st.equals("reject")) {
					os.acceptOffer(a, st);
					System.out.println("Offer is "+st+"ed");
					choosechoice();
			}			
		
		else {
			System.out.println("Offers are Pending...");
			
		choosechoice();
		}
	}	System.out.println("The offer still pending....");
		choosechoice();
	}


	private void removeCar() {
		System.out.println("Enter Car ID to remove it: ");
		 input= new Scanner(System.in);	
			System.out.print(">>>>>"); int i=input.nextInt();
		 System.out.println("REMOVING.....");
		card.removeCar(i);
		choosechoice();
	}


	private void addCar() {
		 input= new Scanner(System.in);
		 String type;String color;int id; double price;
		 System.out.println("Enter Type, Color, and ID");
		 System.out.println("Enter Type: ");
			System.out.print(">>>>>"); type=input.nextLine();
		 System.out.println("Enter color: ");
			System.out.print(">>>>>");color=input.nextLine();
		 System.out.println("Enter ID: ");
			System.out.print(">>>>>"); id=input.nextInt();
		 System.out.println("Enter price ");
			System.out.print(">>>>>"); price=input.nextDouble();		
		card.addCar(new Car(id,type,color,price));
		choosechoice();
	}


	private void viewCars() {
		card.getAllCars();
		choosechoice();
	}

}

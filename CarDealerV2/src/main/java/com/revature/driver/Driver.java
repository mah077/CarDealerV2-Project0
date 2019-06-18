package com.revature.driver;

import com.revature.ui.MainScreen;
import com.revature.util.LoggingUtil;


public class Driver {
	public static MainScreen ms=new MainScreen();
	
	public static void main(String[] args) {
		LoggingUtil.trace("Start APP");
		System.out.println("==================================================================================================================");
		System.out.println("\t\t\t\tWelcome To CarDealer Shop");
		System.out.println("==================================================================================================================");
	
		ms.pageoneScreen();
		
		 

	}
}

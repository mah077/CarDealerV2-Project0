package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Car;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class CarDao implements CarInterface {
	Connection conn = ConnectionFactory.getConnection();
	public static Customer c=new Customer();
	@Override
	public void addCar(Car c) {
		int i=c.getCarID();
		String s1 =c.getMake();
		String s2=c.getColor();
		double d=c.getPrice();
		PreparedStatement stmt;
		String sql = "insert into carShape "+ "(car_id, maker, color,price)" + " values (?, ?, ?,?)";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setString(2, s1);
			stmt.setString(3, s2);
			stmt.setDouble(4, d);
			stmt.executeUpdate();
		
		} catch (SQLException e) {
		LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeCar(int i) {
		String sql= "delete from carShape where car_id = " + i;		
		Statement stmt;
		
		try {
			stmt=conn.createStatement();		
			stmt.execute(sql);		
		
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	@Override
	public List<Car> getAllCars() {
		
		List<Car> carlist = new ArrayList<Car>();	
		 String sql = "select * from carshape ";	
		 Statement stmt;
	
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("\ncar_ID"+"\t\t"+"Make"+ "\t\t" + "Color"+"\t\t"+"Price\n");
		if(rs.next()==false){System.out.println("\tNO CARS\n\n");
		}else
			do { carlist.add(new Car(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDouble(4)));
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2) + "\t\t" + rs.getString(3)+"\t\t"+rs.getDouble(4)+"\n");
			}	while(rs.next());
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			System.out.println("no Query");
			e.printStackTrace();
		}	
		return carlist;
	}

	@Override
	public void viewOneCar(int i) {
		String sql= "select  car.maker, car.color, o.offer_price" + 
				" from offer o, customercardealer c, carshape car"+ 
				" where  o.status ='accept' and o.customer_id = c.customer_id and o.car_id = car.car_id and c.customer_id= " + i ;	
		Statement stmt;
		
		try {
			stmt=conn.createStatement();			
			ResultSet rs=stmt.executeQuery(sql);		
			
			if(rs.next()==false) {System.out.println("\n\tNO CARS\n");}
			else
			do {	
			System.out.println(rs.getString("maker")+"\t"+rs.getString("color")+"\t"+rs.getDouble("offer_price"));
			}while(rs.next());
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}	
	}
}

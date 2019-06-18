package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Offer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class OfferDao implements OfferInterface {
	public static Customer c= new Customer();
	Connection conn = ConnectionFactory.getConnection();
	Offer of = new Offer();
	@Override
	public void AddOffer(Offer o) {

		int i = of.getOfferID();
		int c = o.getCar_id();
		int cu = o.getCustomer_id();
		double pr = o.getPrice();
		String b = of.isStatus();

		PreparedStatement stmt;
		String sql = "insert into offer " + "(offer_id, status, offer_price, car_id, customer_id)"
				+ " values (?, ?, ?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setString(2, b);
			stmt.setDouble(3, pr);
			stmt.setInt(4, c);
			stmt.setInt(5, cu);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeOffer(int i) {

		String sql = "delete from offer where offer_id = " + i;

		Statement stmt;

		try {
			stmt = conn.createStatement();

			stmt.execute(sql);

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Offer> getAllOffers() {
	
		List<Offer> offer = new ArrayList<Offer>();
		
		 String sql = "select * from offer ";	
		 Statement stmt;
	
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()==false) {System.out.println("No cars");}
			else {	
			System.out.println("offer_ID"+"\t"+"Status"+ "\t\t" + "Offer"+"\t\t"+"car_id"+"\t\t"+"cust_id");	
			do {
				offer.add(new Offer( /* rs.getInt(1), rs.getString(2), */  rs.getInt(4),rs.getInt(5),rs.getDouble(3)));
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2) + "\t\t" + rs.getDouble(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5));
			}while(rs.next());
			}//end else	
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			System.out.println("no Query");
			e.printStackTrace();
		}
		
		return offer;
	}

	@Override
	public void viewOwnerOffer(int i) {
		String sql = "select * from offer where status = 'accept' and offer_id = " +i;

		Statement stmt;

		try {
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next())
				System.out.println(rs.getInt("offer_id") + "\t" + rs.getString("status") + "\t\t"
						+ rs.getDouble("offer_price") + "\t\t" + rs.getInt("car_id") + "\t\t" + rs.getInt("customer_id"));
			else
				System.out.println("No Cars to view");

		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void viewAllPaiments() {
		 String sql="select c.firstname,c.lastname ,  o.offer_price, o.status, car.maker\r\n" + 
		 		"from offer o, customercardealer c, carshape car\r\n" + 
		 		"where o.customer_id = c.customer_id \r\n" + 
		 		"and o.car_id= car.car_id \r\n" + 
		 		"and c.customer_id = o.customer_id and o.status='accept';";
		 Statement stmt;
				
		 try {
			stmt=conn.createStatement();
			 ResultSet rs=stmt.executeQuery(sql);
			 if(rs.next()==false) {System.out.println("No Payments yet");}
			do {
					System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3)+"\t\t"
						+rs.getString(4)+"\t\t"+rs.getString(5));
			 
			}while(rs.next());
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
	
		
	}
}

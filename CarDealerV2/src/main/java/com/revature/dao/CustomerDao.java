package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class CustomerDao implements CustomerInterface {
	Connection conn = ConnectionFactory.getConnection();
	public static Customer c=new Customer();

	@Override
	public void addCustomer(Customer c) {
	
		int id=c.getCustomerID(); String fn=c.getFname();String ln=c.getLname() ; String us=c.getUsername(); String pass=c.getPassword();	
		String sql="insert into customerCarDealer (customer_id,firstname,lastname,username,userpassword)"+" values(?,?,?,?,?)";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2,fn);
			stmt.setString(3,ln);
			stmt.setString(4, us);
			stmt.setString(5, pass);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}		
	}

	@Override
	public void removeCustomer(int i) {

	String sql= "delete from customercardealer where customer_id = " + i;		
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
	public void viewOwneCar(int i) {
	System.out.println("testing id");
	String sql= "select c.firstname,c.lastname ,c.username,  o.offer_price, o.status, car.maker, car.color\r\n" + 
			"from offer o, customercardealer c, carshape car\r\n" + 
			"where o.customer_id = c.customer_id \r\n" + 
			"and o.car_id= car.car_id \r\n" + 
			"and c.customer_id= "+i;
		
		Statement stmt;
		
		try {
			stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);
		
			if(rs.next()==false) {System.out.println("NO OFFERS YET");}
			do {	
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4)+"\t\t"
				+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\n");
			}while(rs.next());
			
		
		
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		List<Customer> customerlist= new ArrayList<Customer>();
		Statement stmt;
		
		String sql="select * from customercardealer";
		
		try {
			stmt=conn.createStatement();		
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("Cust_ID"+"\t"+"FN"+ "\t" + "LN"+"\t"+"User");
			while(rs.next()) {
			customerlist.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2) + "\t" + rs.getString(3)+"\t"+rs.getString(4));
			}
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		return customerlist;
		
		
		
		
	}
}

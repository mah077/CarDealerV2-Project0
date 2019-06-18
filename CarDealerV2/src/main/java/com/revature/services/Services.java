package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class Services implements ServicesInterface {

	Connection conn = ConnectionFactory.getConnection();

	@Override
	public boolean checkUserEmp(String u,String p) {
		LoggingUtil.trace("Checking Authentication form employee");
		String sql = "select username ,userpassword from employeecardealer where username = ?";
		PreparedStatement stmt=null;
		int flag =0;
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, u);
			
			ResultSet rs =stmt.executeQuery();
			String cp="";
			
			while(rs.next()) {
				 cp =rs.getString("userpassword");
			}	
				if(cp.equals(p))
				{
					flag=2;
				
				}			
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		if(flag==2)
			return true; 
		else
		
		return false;
	}
	@Override
	public boolean checkUserCust(String user,String pass) {
		LoggingUtil.trace("Checking Authentication form employee");
		String sql = "select username ,userpassword from Customercardealer where username = ?";
		PreparedStatement stmt=null;
		int flag =0;
		try {
			stmt=conn.prepareStatement(sql);		
			stmt.setString(1, user);
			
			ResultSet rs =stmt.executeQuery();
			String cp="";
			
			while(rs.next()) {
				 cp =rs.getString("userpassword");
			}	
				if(cp.equals(pass))
				{
					flag=2;				
				}			
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		if(flag==2)
			return true; 
		else
		
		return false;
	}

	
	public boolean ifIsAnEmp(int user)
	{
		
			String sql= "select * from employeeCarDealer where employee_id = " + user;
		
		Statement stmt;
		int flag=0;
		try {
			stmt=conn.createStatement();		
			ResultSet rs=stmt.executeQuery(sql);

				if(rs.next())
					flag=1;
		
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		if (flag==1)
			return true ;
			else 
				return false;
		
		
	}
	

	public boolean acceptOffer(int i,String it) {
		
		String sql="update offer set status = ? where offer_id = "+i;
		PreparedStatement stmt;
		int flag=0;
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, it);
			stmt.executeUpdate();
			flag =1;
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		if (flag==1)
			return true;
		else return false;
		
		
		
		
		
	}
	
	
	
	
}

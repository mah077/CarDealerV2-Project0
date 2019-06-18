package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class EmployeeDao implements EmployeeInterface {
	Connection conn = ConnectionFactory.getConnection();
	@Override
	public void addEmployee(Employee e) {
	
int id=e.getEmployeeID(); String fn=e.getFname();String ln=e.getLname() ; String us=e.getUsername(); String pass=e.getPassword();
		
		String sql="insert into employeeCarDealer (employee_id,firstname,lastname,username,userpassword)"+" values(?,?,?,?,?)";
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2,fn);
			stmt.setString(3,ln);
			stmt.setString(4, us);
			stmt.setString(5, pass);
			stmt.executeUpdate();
			
			}catch(SQLException ex) 
		{
		  LoggingUtil.error(ex.getMessage());
		  ex.printStackTrace();}
	}
	@Override
	public void removeEmployee(int i) {

		String sql= "delete from employeecardealer where employee_id = " + i;	
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
	public List<Employee> getAllEmployee() {
		List<Employee> emplist= new ArrayList<Employee>();
		Statement stmt;
		
		
		String sql="select * from employeecardealer";
		
		try {
			stmt=conn.createStatement();		
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("Emp_ID"+"\t"+"FN"+ "\t" + "LN"+"\t"+"User");
			while(rs.next()) {
			emplist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2) + "\t" + rs.getString(3)+"\t"+rs.getString(4));
			}
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		return emplist;
	}
	@Override
	public void viewOffers() {
		String sql="select * from offer";
		Statement stmt;
		
		  try { 
			  
	stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
		  
		  while(rs.next()) {
		  
		  System.out.println(rs.getInt(1)+"\t"+rs.getBoolean(2) + "\t" +
		  rs.getDouble(3)+"\t"+rs.getInt(4)+rs.getInt(5));
		 
		  }
		  if(rs.next()==false) {System.out.println("There is no offer");}

		  } catch (SQLException e) {
		  LoggingUtil.error(e.getMessage());
		  e.printStackTrace(); }

	}
	@Override
	public void viewOneEmployee(int i) {
	String sql= "select * from employeeCarDealer where employee_id = " + i;
		
		Statement stmt;
		
		try {
			stmt=conn.createStatement();		
			ResultSet rs=stmt.executeQuery(sql);

				if(rs.next())
			System.out.println(rs.getInt("employee_id")+"\t"+rs.getString("firstname")+"\t"+rs.getString("lastname")+"\t"+rs.getString("username"));
		
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	

}

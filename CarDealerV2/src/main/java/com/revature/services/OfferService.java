package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class OfferService implements OfferInterface {

	Connection conn = ConnectionFactory.getConnection();
	@Override
	public void acceptOffer(int i,String it) {
		
		String sql="update offer set status = ? where offer_id = "+i;
		PreparedStatement stmt;
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, it);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			LoggingUtil.error(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
	}



	
	
	
}

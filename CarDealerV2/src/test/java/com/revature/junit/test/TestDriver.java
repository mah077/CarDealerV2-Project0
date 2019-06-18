package com.revature.junit.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.revature.services.Services;

public class TestDriver {
	private static Services s;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			s=new Services();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEmployeeLogIn() {
		
	assertEquals(true, s.checkUserEmp("moh@emp.com", "123"));
		
	}
	@Test
	public void testCustomerLogIn() {
		
		assertEquals(true, s.checkUserCust("adam@cust.com", "123"));
			
		}
	
	@Test
	public void testIsEmployee() {
		
		assertEquals(true, s.ifIsAnEmp(1));
		
	}
	@Test
	public void testIsAccepted() {

		assertEquals(true, s.acceptOffer(100,"Accept"));
		
	}
	
	
}

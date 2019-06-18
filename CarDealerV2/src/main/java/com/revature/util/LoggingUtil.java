package com.revature.util;

import org.apache.log4j.Logger;


public class LoggingUtil {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void trace(String msg) {
		log.trace(msg);
	}
	
	public static void debug(String msg) {
		log.debug(msg);
	}
	
	public static void info(String msg) {
		log.info(msg);
	}
	
	public static void warn(String msg) {
		log.warn(msg);
	}
	
	public static void error(String msg) {
		log.error(msg);
	}
	
	public static void fatal(String msg) {
		log.fatal(msg);
	}
	
//  NO RGS CONSTRUCTORS FOR PLACES YOU DONT WANT LOGS TO PRINT OUT
	
	public static void trace() {
		
	}
	public static void debug() {
		
	}
	public static void info() {
		
	}
	public static void error() {
		
	}
	public static void warm() 
	{
		
	}
	public static void fatal() {
		
	}
}



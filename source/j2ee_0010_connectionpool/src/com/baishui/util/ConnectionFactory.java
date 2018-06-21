package com.baishui.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
 

public class ConnectionFactory {

	private static Connection conn = null;
	
	static{
		 try {
			  System.out.println("----------DataBase Connectioning...------------------------------");
			  Context initContext = new InitialContext();   
			 Context envContext = (Context) initContext.lookup("java:/comp/env");   
			DataSource ds = (DataSource)envContext.lookup("jdbc/commerce"); 
	            conn = ds.getConnection();
	            System.out.println("----------DataBase Connection Success------------------------------");
	        
		  } catch (Exception ex) { 
	           ex.printStackTrace();
	        } 
	}
	
	public static Connection getConnection(){
		return conn; 
	}
	
	
}

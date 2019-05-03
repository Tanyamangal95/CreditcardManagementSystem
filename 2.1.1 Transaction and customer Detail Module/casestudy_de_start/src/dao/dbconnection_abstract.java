package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public abstract class dbconnection_abstract {
	public  Connection con = null;
	public  ResultSet rs ;
	public PreparedStatement ps;
	    
	protected void myconnection() throws Exception {
		try {
	   // step 1
	   FileReader f = new FileReader("db.properties");
	   // will hold properties of f 
	   Properties p = new Properties();
	   // p loads properties
	   p.load(f);
	   // step 2
	   con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));        
	   }catch(Exception e) {
		   System.out.println("Cannot connect to the database!");
	   }
	}
}


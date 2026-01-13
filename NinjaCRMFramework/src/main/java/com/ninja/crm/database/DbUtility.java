package com.ninja.crm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DbUtility {
 public static void main(String[] args) throws SQLException {
	 Driver d = new Driver();
	 DriverManager.registerDriver(d); 
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fireflink","root", "root");
	 //INSERT into DB
	 PreparedStatement ps = conn.prepareStatement("INSERT INTO MOUSUMI(ROLLNUM,STUDENT) VALUES (?,?)");
	 ps.setString(1,"3");
	 ps.setString(2,"Riju");
	 ps.executeUpdate();
	 
	 
	 //Fetch Data
	 Statement stat = conn.createStatement();
	 ResultSet result = stat.executeQuery("SELECT STUDENT,ROLLNUM FROM MOUSUMI");
	 while(result.next()) {
		 System.out.println(result.getString("student")+ "|" + result.getString("ROLLNUM"));
	 }
	 ps.close();
	 conn.close();
	 
}
}

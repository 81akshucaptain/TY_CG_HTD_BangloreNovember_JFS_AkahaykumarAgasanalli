package com.caps.jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserLogin {
	public static void main(String[] args) {
		//Connection is interface
		Connection con=null;
		//Statement us also interface
		java.sql.PreparedStatement pstmt=null;
		//ResulSet is also interface
		ResultSet rs=null;
		
		Scanner sc=new Scanner(System.in);
	try {
	//LOAD THE DRIVER
	//Driver is again an interface helps in linking DB
	Driver driver=new com.mysql.jdbc.Driver();
	//DriverManager is a class,with static registerDriver method 
	DriverManager.registerDriver(driver);
	System.out.println("driver loaded");
	System.out.println("enter your user name and pasword");
	String dbuser=sc.nextLine();
	String dbpass=sc.nextLine();
	
	
	//GET DBCONECTION
	//sometimes ://127.0.0.1:3306/capgemini1.?user=root&password=74113480ak.....
	String dburl="jdbc:mysql://localhost:3306/capgemini1"+"";
	//REAL TIME EXAMPLE FOR METOD OVERLOADING
	//connection is interface,getConnection is static method in DriverManager
	//returns the connection type
	 con = DriverManager.getConnection(dburl,dbuser,dbpass);
	 System.out.println("connection established");
	
	//ISSUES THE QUERY
	 String query="SELECT * FROM student where usn=? AND psw=?";
	 pstmt=con.prepareStatement(query);

	 //createStatment method is abstract method in Connection interface 
	 //which returns Statement ref var
	 //stmt = con.createStatement();FOR STATIC QUERY
	 System.out.println("enter the valid usn");
	 pstmt.setString(1,sc.nextLine());
	 System.out.println("enter the valid password");
	 pstmt.setString(2,sc.nextLine());
	 //ececuteQuery is method in Statement Interface,which returns
	 //ResultSet reff variable
	 rs=pstmt.executeQuery();
	 //ResultSet is again interface that has next(),
	 System.out.println("The query is been issued and executed");
//WHEN ITS ABOUT TO PRINT SINGLE ROW THE USE if(rs.next()){....
	 while(rs.next()) {
		 System.out.println("usn: "+rs.getString("usn"));
		 System.out.println("place: "+rs.getString("adress"));
		 System.out.println("name: "+rs.getString("name"));
		 System.out.println("uname: "+rs.getString("uname"));
		 System.out.println("psw: "+rs.getString("psw"));
		 System.out.println("age: "+rs.getInt("age"));
 }
	//process the results
	//close all the JDBC objects
}catch(SQLException e) {
	e.printStackTrace();
}
	finally {
		try {
			if(con!=null)
				con.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
}
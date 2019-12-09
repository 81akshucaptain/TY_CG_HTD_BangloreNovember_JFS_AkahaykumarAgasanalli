package com.caps.jdbc;
import java.sql.*;

import com.mysql.jdbc.Connection;

public class MyFirstJDBC {
	
	
	public static void main(String[] args) {
		java.sql.Connection con=null;
		Statement stmnt = null;
		ResultSet rs = null;
		try {
			//LOAD DRIVER
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded");

			//GET ONNECTIONS
			String dburl="jdbc:mysql://localhost:3306/capgemini1"+"?user=root&password=74113480ak";
			con =DriverManager.getConnection(dburl);
			System.out.println("conection established");

			//ISSUE QUERIES
			String query="select * from student";
			 stmnt = con.createStatement();
			 rs = stmnt.executeQuery(query);
			System.out.println("query issued");

			//PROCESS THE RESULTS
			while(rs.next()) {
				System.out.println("usn: "+rs.getString("usn"));
				System.out.println("age: "+rs.getInt("age"));
				System.out.println("place: "+rs.getString("adress"));
				System.out.println("college: "+rs.getString("college"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("***********************");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//CLOSE CONNECTIONS
		finally {
             
			try {
				if(con!=null) 
					con.close();
				if(stmnt!=null) 
					stmnt.close();
				if(rs!=null) 
					rs.close();
				System.out.println("Connection is closed");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

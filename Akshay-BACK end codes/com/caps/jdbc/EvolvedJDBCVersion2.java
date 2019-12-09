package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class EvolvedJDBCVersion2 {
	public static void main(String[] args) {
		FileReader reader=null;
		Properties prop=null;
		try {
			 reader=new FileReader("C:\\Users\\Caption AK\\Desktop\\JAVAprogram\\JDBC\\db.properties"); 
			 //or you use (db.properties) rather than file
			 prop=new Properties();
			//to load the properties
			prop.load(reader);
			//these lines are optional buddy,JDBC-4 automatically LOADS THE driver claas
			//Class.forName(prop.getProperty("driverClass"));
			System.out.println("driver loaded..!");
		}catch(Exception e) {
			e.printStackTrace();

		}
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl") ,
				prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"));){
			while (rs.next()) {
				System.out.println("usn: "+rs.getString("usn"));
				System.out.println("age: "+rs.getInt("age"));
				System.out.println("place: "+rs.getString("adress"));
				System.out.println("college: "+rs.getString("college"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("***********************");
				
			}
	}catch (Exception e) {
	}
	}
}
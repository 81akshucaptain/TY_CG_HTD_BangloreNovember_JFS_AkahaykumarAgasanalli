package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUser {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			//LOAD THE DRIVER
			/*Driver is again an interface helps in linking DB
	Driver driver=new com.mysql.jdbc.Driver();
	//DriverManager is a class,with static registerDriver method 
	DriverManager.registerDriver(driver);
	System.out.println("driver loaded");*///OR
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver is loaded");
			System.out.println("user..! enter your uname and password");
			String user=sc.nextLine();
			String password=sc.nextLine();
			String dburl="jdbc:mysql://localhost:3306/capgemini1";
			con=DriverManager.getConnection(dburl, user, password);
			System.out.println("Connection Estabished..");

			String query="INSERT INTO student VALUES(?,?,?,?,?,?,?)"; 
			pstmt=con.prepareStatement(query);
			System.out.println("enter usn: ");
			pstmt.setString(1,sc.nextLine());
			System.out.println("enter age: ");
			pstmt.setInt(2,Integer.parseInt(sc.nextLine()));
			System.out.println("enter adress: ");
			pstmt.setString(3,sc.nextLine());
			System.out.println("enter college: ");
			pstmt.setString(4,sc.nextLine());
			System.out.println("enter name: ");
			pstmt.setString(5,sc.nextLine());
			System.out.println("enter uname: ");
			pstmt.setString(6,sc.nextLine());
			System.out.println("enter password: ");
			pstmt.setString(7,sc.nextLine());
			int count=pstmt.executeUpdate();
if(count>0) {
	System.out.println("student successfully added..!");
}else {
	System.err.println("there is problem..please check");
}
		}catch (Exception e) {
e.printStackTrace();
}
	}

}

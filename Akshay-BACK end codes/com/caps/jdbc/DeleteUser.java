package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DeleteUser {
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

			String query="DELETE from student where usn=? AND psw=?"; 
			pstmt=con.prepareStatement(query);
			System.out.println("enter the valid usn");
			pstmt.setString(1,sc.nextLine());
			System.out.println("enter the valid password");
			pstmt.setString(2,sc.nextLine());

			int count=pstmt.executeUpdate();
			//this method will execute the query other than select queries
			if(count>0) {
				System.out.println("user deleted successfully..!");
			}else {
				System.err.println("please check your password or uname...");
			}
			//NOT SQLEXCEPTION BCZ WE HAVE Class.forName() method
		}catch (Exception e) {
			try {
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				System.err.println("all connection are been CLOOSED");
			}catch (Exception e1) {
				e1.printStackTrace();			}
		}
	}
}

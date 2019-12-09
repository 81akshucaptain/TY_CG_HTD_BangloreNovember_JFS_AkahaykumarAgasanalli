package com.caps.jdbc;
import java.sql.*;
import java.util.Scanner;

public class UserEmailUpdate {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		//LOAD THE DRIVER
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver has been loaded..!");

			//GET CONNECTION
			String dburl="jdbc:mysql://localhost:3306/capgemini1";
			System.out.println("enter the db user name and password..!");
			String uname1=sc.nextLine();
			String password=sc.nextLine();

			con = DriverManager.getConnection(dburl,uname1,password);
			System.out.println("connection established..!");

			//ISSUE THE QUERY
			String query="update Student set uname=? where usn=? and psw=?";
			pstmt = con.prepareStatement(query);
			System.out.println("enter user name to upadate");
			pstmt.setString(1,sc.nextLine());
			System.out.println("enter usn and password to upadate");
			pstmt.setString(2,sc.nextLine());
			pstmt.setString(3, sc.nextLine());

			int count=pstmt.executeUpdate();
			System.out.println("query exe");
			if(count>0) {
				System.out.println("query updted and hence results..!");
			}else {
				System.err.println("something went wrong");
			}
			//PROCESS QUERY AND RESULT
			//CLOSE ALL THE JDBC
		}catch(Exception e) {

		}

	}
}

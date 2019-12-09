package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EvolutionJDBC {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String dburl="jdbc:mysql://localhost:3306/capgemini1";
		System.out.println("eneter the db user and password");
		String user=sc.nextLine();
		String password=sc.nextLine();
		String query="select * from student";
		//RESOURCE BLOCK
		try(Connection con=DriverManager.getConnection(dburl,user,password);
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query)){
			while (rs.next()) {
				System.out.println("usn: "+rs.getString(1));
				System.out.println("age: "+rs.getInt(2));
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


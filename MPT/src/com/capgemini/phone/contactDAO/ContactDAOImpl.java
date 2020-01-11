package com.capgemini.phone.contactDAO;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.phone.contact_bean.ContactBean;

public class ContactDAOImpl implements ContactDAO{
	Properties prop=null;
	int result;
	FileReader reader;
	Scanner sc=new Scanner(System.in);



	public ContactDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("phone.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void getAllContacts() {

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser")
				,prop.getProperty("dbpassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("Query"));
				){
			System.out.println(":::::::::::::::::::::::::ALL CONTACT DETAILS::::::::::::::::::::::::\n");

			while(rs.next()) {
				System.out.println("NAME: "+rs.getString(1));
				System.out.println("NUMBER: "+rs.getString(2));
				System.out.println("GROUP: "+rs.getString(3));
				System.out.println("===================================================================");

			}
			System.out.println("\n");
		}catch (Exception e) {
			System.err.println("THERE IS PROBLEM IN DIPLAYING ALL CONTACTS \n");
			e.printStackTrace();

		}
	}

	@Override
	public void searchContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser")
				,prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("sQuery"));	
				){
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			if(rs!=null) {
			while(rs.next()) {
				
				System.out.println("****************THE RESPECTIVE CONTACT DETAILS ARE*******************");
				System.out.println("NAME: "+rs.getString(1));
				System.out.println("PHONE: "+rs.getString(2));
				System.out.println("GROUP: "+rs.getString(3));
				System.out.println("\n");
			}
			}else {
				System.err.println("The Requested Contact Name Is Not Present..!\n");
			}
				

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteContact(String name) {

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser")
				,prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("dQuery"));	
				){
			pstmt.setString(1, name);
			int rs=pstmt.executeUpdate();
			if(rs>0) {
				System.out.println("Contact with name: "+name+" DELETED successfully..! \n");
			}else {
				System.err.println("There is problem in DELETING the Given Contact details, try again \n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateContact(ContactBean cb2,String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser")
				,prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("uQuery"));	
				){
			pstmt.setString(1, cb2.getNumber());
			//pstmt.setString(2, cb2.getGroup());
			pstmt.setString(2, name);

			int rs=pstmt.executeUpdate();
			if(rs>0) {
				System.out.println("Contact with name: "+cb2.getName()+" UPDATED successfully..! \n");
			}else {
				System.err.println("There is problem in UPDATING the Contact details, try again \n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addContact(ContactBean cb) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbuser")
				,prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("iQuery"));	
				){
			pstmt.setString(1, cb.getName());
			pstmt.setString(2,cb.getNumber());
			pstmt.setString(3, cb.getGroup());
			int rs=pstmt.executeUpdate();
			if(rs>0) {
				System.out.println("Contact with name: "+cb.getName()+" ADDED successfully..! \n");
			}else {
				System.err.println("There is problem in addding the Contact details, try again \n");
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

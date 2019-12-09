package com.capgemini.jdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.jdbc.bean.UserBean;
//DAO class will help us to deal with DB...DataAccessObject
public class UserDAOImpl implements UserDAO {
	FileReader reader;
	Properties prop;
	UserBean user;

	//constructor
	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserBean> getAllUser() {
		List<UserBean> list=new ArrayList<UserBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))
				){
			while (rs.next()) {
				user=new UserBean();
				user.setUsn(rs.getString(1));
				user.setAge(rs.getInt(2));
				user.setAdress(rs.getString(3));
				user.setCollege(rs.getString(4));
				user.setName(rs.getString(5));
				user.setUname(rs.getString(6));
				user.setPsw(rs.getString(7));
				list.add(user);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	@Override
	public UserBean userlogin(String uame, String psw) {

		return null;
	}

	@Override
	public boolean updateUser(String uname, String usn, String password) {

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("updateQuery"));	
				){
			pstmt.setString(1, uname);
			pstmt.setString(2,usn);
			pstmt.setString(3, password);

			int rs=pstmt.executeUpdate();
			System.out.println("UPDATING....user");
		}catch (Exception e) {
			e.printStackTrace();	
		}
		System.out.println("UPDATED.....");
		return true;	
	}

	@Override
	public boolean deleteUser(String usn, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("deleteQuery"));	
				){
			pstmt.setString(1, usn);
			pstmt.setString(2,password);
			int rs=pstmt.executeUpdate();
			System.out.println("deleting....user");
		}catch (Exception e) {
			e.printStackTrace();	
		}
		System.out.println("deleted.....");
		return true;
	}

	@Override
	public boolean insertUser(UserBean user) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("dbuser"),prop.getProperty("dbpassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("insertQuery"));	
				){
			pstmt.setString(1, user.getUsn());
			pstmt.setInt(2,user.getAge());
			pstmt.setString(3,user.getAdress());
			pstmt.setString(4, user.getCollege());
			pstmt.setString(5, user.getName());
			pstmt.setString(6,user.getUname());
			pstmt.setString(7,user.getPsw());

			int rs=pstmt.executeUpdate();
			System.out.println("system insertUser query is been executed");

		}catch (Exception e) {
			e.printStackTrace();		}
		return true;
	}
}

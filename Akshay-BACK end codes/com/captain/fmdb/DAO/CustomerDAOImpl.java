package com.captain.fmdb.DAO;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capatin.fmdb.bean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	Properties prop=null;
	int result;
	FileReader reader;


	public CustomerDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("fmdb.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public CustomerBean Customerlogin(String cid, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean CustomerToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("insertQuery"));
				) {
			
			pstmt.setInt(1,customer.getCid());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getTown());
			pstmt.setInt(4, customer.getPostal());
			pstmt.setString(5, customer.getEmail());
			pstmt.setInt(6, (int) customer.getPhone());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("WELCOME "+customer.getName()+" YOUR ID IS: "+customer.getCid()+" (please Remember This)" );
				System.out.println("Costumer added successfully");
				return true;

			}else {
				System.err.println("something went wrong please try again later..!");
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);
			return false;
		}

	}


	@Override
	public List<CustomerBean> searchCustomer(int cidforSearch) {
		List<CustomerBean> list=new ArrayList<CustomerBean>();
		String searchQuery="Select * from customer where CID='cidforSearch'";
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(searchQuery)
				){
			
			while (rs.next()) {
				
				CustomerBean customer = new CustomerBean();
				customer.setCid(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setTown(rs.getString(3));
				customer.setPostal(rs.getInt(4));
				customer.setEmail(rs.getString(5));
				customer.setPhone(rs.getLong (6));
				list.add(customer);
			}
		}catch (Exception e) {
			e.printStackTrace();		
		}
		return list;
	}


}

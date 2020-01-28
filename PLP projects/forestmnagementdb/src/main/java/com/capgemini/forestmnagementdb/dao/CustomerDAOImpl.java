package com.capgemini.forestmnagementdb.dao;

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

import com.capgemini.forestmnagementdb.bean.CustomerBean;
import com.capgemini.forestmnagementdb.exception.CustomerAppException;

public class CustomerDAOImpl implements CustomerDAO {
	Properties prop=null;
	int result;
	FileReader reader;

	public CustomerDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("customer.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			List<CustomerBean> list=new ArrayList<CustomerBean>();
			if(rs!=null) {
				while(rs.next()) {
					CustomerBean customerBean=new CustomerBean();
					customerBean.setCustomerId(rs.getInt(1));
					customerBean.setName(rs.getString(2));
					customerBean.setTown(rs.getString(3));
					customerBean.setPostal(rs.getInt(4));
					customerBean.setEmail(rs.getString(5));
					customerBean.setPhone(rs.getString(6));
					list.add(customerBean);
				}
				return list;
			}else {
				throw new CustomerAppException("Data Not Found, Currently No Customers");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println(":"+msg);
			return null;
		}
	}

	@Override
	public boolean updateCustomer(CustomerBean customerToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(7,customerToUpdate.getCustomerId());
			pstmt.setString(1, customerToUpdate.getName());
			pstmt.setString(2, customerToUpdate.getTown());
			pstmt.setInt(3, customerToUpdate.getPostal());
			pstmt.setString(4, customerToUpdate.getEmail());
			pstmt.setString(5, customerToUpdate.getPhone());
			pstmt.setString(6, customerToUpdate.getPassword());
			result=pstmt.executeUpdate();
			if(result>0) {
				return true;

			}else {
				throw new CustomerAppException("Failed To Update Data, Try Again");

			}

		} catch (Exception e) {
			String msg=e.getMessage();
			System.err.println(":"+ msg);
			return false;
		}	
	}

	@Override
	public boolean deleteCustomer(int customerToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, customerToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				throw new CustomerAppException("Customer Not Found, Try Again");
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println(":"+msg);
			return false;
		}

	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt.setInt(1,customer.getCustomerId());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getTown());
			pstmt.setInt(4, customer.getPostal());
			pstmt.setString(5, customer.getEmail());
			pstmt.setString(6, customer.getPhone());
			pstmt.setString(7, customer.getPassword());
			result=pstmt.executeUpdate();
			if(result>0) {
				return true;
			}else {
				throw new CustomerAppException("Customer Exist Already, Try Again");
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println(":"+msg);
			return false;
		}

	}

	@Override
	public CustomerBean searchCustomer(int customerforSearch) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, customerforSearch);

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()==true)  {
				CustomerBean customerBean=new CustomerBean();
				customerBean.setCustomerId(rs.getInt(1));
				customerBean.setName(rs.getString(2));
				customerBean.setTown(rs.getString(3));
				customerBean.setPostal(rs.getInt(4));
				customerBean.setEmail(rs.getString(5));
				customerBean.setPhone(rs.getString(6));
				customerBean.setPassword(rs.getString(7));
				return customerBean;
			}
			else {
//				throw new CustomerAppException("No Data Found, try Again");
				return null;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println(":"+msg);
			return null;
		}
	}


	public boolean customerlogin(int customerIdToLogin, String emailToLogin) {

		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, customerIdToLogin);

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()==true)  {
				int cid=rs.getInt(1);
				String password=rs.getString(7);
				if((cid==customerIdToLogin)&&(password.equals(emailToLogin))) {
					return true;
				}else {
					return false;
				}
			}
			else {
				System.err.println("The entered CustomerID is not present..!\n");
				return false;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println(":"+msg);	
			return false;
		}

	}

}


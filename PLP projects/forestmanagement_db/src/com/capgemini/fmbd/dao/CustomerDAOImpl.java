package com.capgemini.fmbd.dao;

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
import com.capgemini.fmdb.bean.CustomerBean;

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
	public void getAllCustomer() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============CUSTOMER DEATAILS============\n");

			if(rs.next()==true) {
				while(rs.next()) {
					System.out.println("CUSTOMER-ID: "+rs.getInt(1));
					System.out.println("CUSTOMER-NAME: "+rs.getString(2));
					System.out.println("CUSTOMER-TOWN: "+rs.getString(3));
					System.out.println("CUSTOMER-POSTAL: "+rs.getInt(4));
					System.out.println("CUSTOMER-EMAIL: "+rs.getString(5));
					System.out.println("CUSTOMER-PHONE: "+rs.getString(6));
					System.out.println(".......................................\n");

				}
			}else {
				System.err.println("There is no customers to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);
		}
	}

	@Override
	public boolean updateCustomer(CustomerBean CustomerToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(6,CustomerToUpdate.getCid());
			pstmt.setString(1, CustomerToUpdate.getName());
			pstmt.setString(2, CustomerToUpdate.getTown());
			pstmt.setInt(3, CustomerToUpdate.getPostal());
			pstmt.setString(4, CustomerToUpdate.getEmail());
			pstmt.setString(5, CustomerToUpdate.getPhone());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("UPDATED.. "+CustomerToUpdate.getName()+" YOUR DETAILS ARE UPDATED SUCCESFULLY..!" );
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
	public boolean deleteCustomer(int cidToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, cidToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Customer with CID "+cidToDeleet+" DELETED successfully\n");
				return true;
			}else {
				System.err.println("There is problem in Dleleting the Customer..!\n");
				return false;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("admin problem in: "+msg);
			return false;
		}

	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt.setInt(1,customer.getCid());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getTown());
			pstmt.setInt(4, customer.getPostal());
			pstmt.setString(5, customer.getEmail());
			pstmt.setString(6, customer.getPhone());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("WELCOME "+customer.getName()+" YOUR ID IS: "+customer.getCid()+" (please Remember This) \n" );
				System.out.println("Costumer added successfully \n");
				return true;

			}else {
				System.err.println("something went wrong please try again later..!\n");
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);
			return false;
		}

	}


	@Override
	public void searchCustomer(int cidforSearch) {
		/*String searchQuery="Select * from customer where CID='cidforSearch'";
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(searcQuery)*/
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, cidforSearch);

			ResultSet rs=pstmt.executeQuery();

			System.out.println("============CUSTOMER DEATAILS============\n");
			if(rs.next()==true)  {
				System.out.println("CUSTOMER-ID: "+rs.getInt(1));
				System.out.println("CUSTOMER-NAME: "+rs.getString(2));
				System.out.println("CUSTOMER-TOWN: "+rs.getString(3));
				System.out.println("CUSTOMER-POSTAL: "+rs.getInt(4));
				System.out.println("CUSTOMER-EMAIL: "+rs.getString(5));
				System.out.println("CUSTOMER-PHONE: "+rs.getString(6));
			}
			else {
				System.err.println("The entered CustomerID is not present..!\n");
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);			
		}
	}

	public boolean customerlogin(int cidToLogin, String emailToLogin) {
	
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, cidToLogin);

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()==true)  {
				int cid=rs.getInt(1);
				String email=rs.getString(5);
				if((cid==cidToLogin)&&(email.equals(emailToLogin))) {
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
			System.err.println("hello admin: "+msg);	
			return false;
		}
	
	}
//	@Override
//	public boolean customerlogin(int cidToLogin, String emailToLogin) {
//		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
//				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
//				Statement stmt=con.createStatement();
//				) {
//			String loginQuery="select * from customer where CID=cidToLogin and email='emailToLogin'";
//			ResultSet rs=stmt.executeQuery(loginQuery);
//			if(rs!=null) {
//				if((cidToLogin==rs.getInt(1))&&(emailToLogin.equals(rs.getString(5)))) {
//					return true;
//				}else {
//					return false;
//				}
//			}else {
//				return false;
//			}
//		}catch (Exception e) {
//			String msg=e.getMessage();
//			System.out.println("hello user there is problem in accessing: "+msg);
//			return false;
//		}
//	}

}


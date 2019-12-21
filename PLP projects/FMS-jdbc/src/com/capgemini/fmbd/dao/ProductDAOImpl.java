package com.capgemini.fmbd.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.fmdb.bean.ProductBean;

public class ProductDAOImpl implements ProductDAO {
	
	Properties prop=null;
	int result;
	FileReader reader;


	public ProductDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("product.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void getAllProduct() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============PRODUCT DEATAILS============\n");

			if(rs.next()==true) {
				while(rs.next()) {
					System.out.println("PRODUCT-ID: "+rs.getInt(1));
					System.out.println("PRODUCT-NAME: "+rs.getString(2));
					System.out.println("PRODUCT-QUANTITY: "+rs.getInt(3));
					System.out.println("PRODUCT-CLASS: "+rs.getString(4));
					System.out.println("CUSTOMER-COST: "+rs.getInt(5));
					System.out.println(".......................................\n");

				}
			}else {
				System.err.println("There is no product to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);
		}
	}
	
	

	@Override
	public void Productlogin(String cid, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(6,ProductToUpdate.getPID());
			pstmt.setString(1, ProductToUpdate.getName());
			pstmt.setInt(2, ProductToUpdate.getQantity());
			pstmt.setString(3, ProductToUpdate.getProductClass());
			pstmt.setInt(4, ProductToUpdate.getCost());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("UPDATED.. "+ProductToUpdate.getName()+" YOUR DETAILS ARE UPDATED SUCCESFULLY..!" );
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
	public boolean deleteProduct(int pidToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, pidToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Customer with PID "+pidToDeleet+" DELETED successfully\n");
				return true;
			}else {
				System.err.println("There is problem in Dleleting the product..!\n");
				return false;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("admin problem in: "+msg);
			return false;
		}

	}

	@Override
	public boolean addProduct(ProductBean Product) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt.setInt(1,Product.getPID());
			pstmt.setString(2, Product.getName());
			pstmt.setInt(3, Product.getQantity());
			pstmt.setString(4, Product.getProductClass());
			pstmt.setInt(5, Product.getCost());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("WELCOME "+Product.getName()+" YOUR PID IS: "+Product.getPID()+" (please Remember This) \n" );
				System.out.println("Product added successfully \n");
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
	public void searchProduct(int pidforSearch) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, pidforSearch);

			ResultSet rs=pstmt.executeQuery();

			System.out.println("============PRODUCT DEATAILS============\n");
			if(rs.next()==true)  {
				System.out.println("PRODUCT-ID: "+rs.getInt(1));
				System.out.println("PRODUCT-NAME: "+rs.getString(2));
				System.out.println("PRODUCT-QUANTITY: "+rs.getInt(3));
				System.out.println("PRODUCT-CLASS: "+rs.getString(4));
				System.out.println("PRODUCT-COST: "+rs.getInt(5));
			}
			else {
				System.err.println("The entered ProdctID is not present..!\n");
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("hello admin: "+msg);			
		}
	}
}

package com.capgemini.fmbd.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.fmdb.bean.LandsBean;
import com.capgemini.fmdb.bean.ProductBean;

public class LandsDAOImpl implements LandsDAO {

	Properties prop=null;
	int result;
	FileReader reader;


	public  LandsDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("lands.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getAllLands() {

		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============PRODUCT DEATAILS============\n");

			if(rs!=null) {
				while(rs.next()) {
					System.out.println("LAND-ID: "+rs.getInt(1));
					System.out.println("LAND-SIZE: "+rs.getString(2));
					System.out.println("LAND-RESOURCES: "+rs.getString(3));
					System.out.println(".......................................\n");

				}
			}else {
				System.err.println("There is no lands to display..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("problem in Displaying lands : "+msg);
		}
	}


	@Override
	public boolean updateLands(int cid, LandsBean landToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(3,landToUpdate.getLandId());
			pstmt.setString(1, landToUpdate.getLandSize());
			pstmt.setString(2, landToUpdate.getLandResources());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("Land with LAND-ID: "+landToUpdate.getLandId()+" details  updated succesfully..!" );
				return true;

			}else {
				System.err.println("something went wrong please try again later..!");
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("problem in updating the destails: "+msg);
			return false;
		}	
	}

	@Override
	public boolean deleteLands(int pidToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, pidToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Lands with LID "+pidToDeleet+" DELETED successfully\n");
				return true;
			}else {
				System.err.println("There is problem in Dleleting the Lands..!\n");
				return false;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("problem in deleting the lands: "+msg);
			return false;
		}
	}

	@Override
	public boolean addLands(LandsBean Land) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt.setInt(1,Land.getLandId());
			pstmt.setString(2, Land.getLandSize());
			pstmt.setString(3, Land.getLandResources());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("Land with LAND_ID: "+Land.getLandId()+" added succesfully. (please Remember This) \n" );
				return true;

			}else {
				System.err.println("something went wrong please try again later..!\n");
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("There is problem in adding the land detiails: "+msg);
			return false;
		}
	}


	@Override
	public LandsBean searchLands(int lidforSearch) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, lidforSearch);

			ResultSet rs=pstmt.executeQuery();

			if(rs.next()==true)  {
				LandsBean prBean=new LandsBean();
				prBean.setLandId(rs.getInt(1));
				prBean.setLandSize(rs.getString(2));
				prBean.setLandResources(rs.getString(3));
				return prBean;
//				System.out.println("PRODUCT-ID: "+rs.getInt(1));
//				System.out.println("PRODUCT-NAME: "+rs.getString(2));
//				System.out.println("PRODUCT-QUANTITY: "+rs.getInt(3));
//				System.out.println("PRODUCT-CLASS: "+rs.getString(4));
//				System.out.println("PRODUCT-COST: "+rs.getInt(5));
			}
			else {
				System.err.println("The entered LandID is not present..!\n");
				return null;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("There is problem in searching the land : "+msg);		
			return null;
		}
	}

}

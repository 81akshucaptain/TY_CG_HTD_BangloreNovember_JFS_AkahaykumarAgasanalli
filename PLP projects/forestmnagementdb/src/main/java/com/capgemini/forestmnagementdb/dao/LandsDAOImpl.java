package com.capgemini.forestmnagementdb.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestmnagementdb.bean.LandsBean;
import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.exception.LandsAppException;

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
	public List<LandsBean> getAllLands() {

		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			List<LandsBean> list=new ArrayList<LandsBean>();
			if(rs!=null) {
				while(rs.next()) {
					LandsBean land=new LandsBean();
					land.setLandId(rs.getInt(1));
					land.setLandSize(rs.getString(2));
					land.setLandResources(rs.getString(3));
					list.add(land);
				}
				return list;
			}else {
				throw new LandsAppException("No Data Found..!");
			}

		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("problem in Displaying land details : "+msg);
			return null;
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
				return true;

			}else {
				throw new LandsAppException("Failed To Update..!");
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("problem in updating the details: "+msg);
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
				return true;
			}else {
				throw new LandsAppException("LandId Not Exist..!");
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
				return true;

			}else {
				throw new LandsAppException("This Land ID may Exist..!");
			}

		} catch (Exception e) {
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
				
			}
			else {
				throw new LandsAppException("No Data Found, Inavlid LID..!");
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("There is problem in searching the land : "+msg);		
			return null;
		}
	}

}

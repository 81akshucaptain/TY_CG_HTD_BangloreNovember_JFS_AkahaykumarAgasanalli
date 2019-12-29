package com.capgemini.forestmnagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.forestmnagement.bean.ContractorBean;

public class ContractorDAOImpl implements ContractorDAO {
	Properties prop=null;
	int result;
	FileReader reader;
	//CONSTRUCTOR
	public ContractorDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("contractor.properties");
			prop=new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void getAllContarctor() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			System.out.println("============CONTRACT DEATAILS============\n");

			if(rs!=null) {
				while(rs.next()) {
					System.out.println("CONTRACT-ID: "+rs.getInt(1));
					System.out.println("CUSTOMER-ID: "+rs.getInt(2));
					System.out.println("PRODUCT-ID: "+rs.getInt(3));
					System.out.println("HAULIER-ID: "+rs.getString(4));
					System.out.println("DELIVERY-DATE: "+rs.getString(5));
					System.out.println("DEMANDED-QUNATITY: "+rs.getInt(6));
					System.out.println(".......................................\n");
				}
			}else {
				System.err.println("There are no CONTRACTs to display..!");
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("oops..!There is problem in getting all the contracts: "+msg);
		}
	}


	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(6,cid);
			pstmt.setInt(1, contarctorToUpdate.getCustomerId());
			pstmt.setInt(2, contarctorToUpdate.getProductId());
			pstmt.setString(3, contarctorToUpdate.getHaulierId());
			pstmt.setString(4, contarctorToUpdate.getDeliveryDate());
			pstmt.setInt(5, contarctorToUpdate.getQunatity());
			result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("CONTRACT-ID: "+contarctorToUpdate+" UPDATED SUCCESFULLY..!" );
				return true;

			}else {
				System.err.println("something went wrong check data and please try again..!");
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("Problem in updating..: "+msg);
			return false;
		}	
	}

	@Override
	public boolean deletecontarctor(int cidToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, cidToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Contract with ID "+cidToDeleet+" DELETED successfully\n");
				return true;
			}else {
				System.err.println("something went wrong check data and please try again..!");
				return false;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("There is problem in Deleting: "+msg);
			return false;
		}

	}


	@Override
	public boolean addContarctor(ContractorBean contract) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt1=con.prepareStatement(prop.getProperty("iQuery"));
				) {

			pstmt1.setInt(1,contract.getContractId());
			pstmt1.setInt(2, contract.getCustomerId());
			pstmt1.setInt(3, contract.getProductId());
			pstmt1.setString(4, contract.getHaulierId());
			pstmt1.setString(5, contract.getDeliveryDate());
			pstmt1.setInt(6, contract.getQunatity());			
			int result2=pstmt1.executeUpdate();

			if(result2>0) {
				System.out.println("Contract with CID: "+contract.getContractId()+" added successfuly. (please Remember This) \n" );
				return true;

			}else {
				System.err.println("something went wrong please try again later..!\n");
				return false;
			}
		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("Problem in adding Contract: "+msg);
			return false;
		}

	}


	@Override
	public ContractorBean searchContarctor(int cidforSearch) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, cidforSearch);

			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==true)  {
				ContractorBean coBean=new ContractorBean();
				coBean.setContractId(rs.getInt(1));
				coBean.setCustomerId(rs.getInt(2));
				coBean.setProductId(rs.getInt(3));
				coBean.setHaulierId(rs.getString(4));
				coBean.setDeliveryDate(rs.getString(5));
				coBean.setQunatity(rs.getInt(6));
				return coBean;	
			}
			else {
				System.err.println("The entered Contract-ID is not EXIST..!\n");
				return null;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("There is problem in Searching..: "+msg);
			return null;
		}
	}
}

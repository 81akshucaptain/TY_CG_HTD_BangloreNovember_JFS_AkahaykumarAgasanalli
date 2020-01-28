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

import com.capgemini.forestmnagementdb.bean.ContractorBean;

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
	public List<ContractorBean> getAllContarctor() {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("getQuery"));
				) {
			ResultSet rs=pstmt.executeQuery();
			List<ContractorBean> list=new ArrayList<ContractorBean>();
			if(rs!=null) {
				while(rs.next()) {
					ContractorBean cBean=new ContractorBean();
					cBean.setContractId(rs.getInt(1));
					cBean.setCustomerId(rs.getInt(2));
					cBean.setProductId(rs.getInt(3));
					cBean.setHaulierId(rs.getString(4));
					cBean.setDeliveryDate(rs.getString(5));
					cBean.setQunatity(rs.getInt(6));
					list.add(cBean);
				}
				return list;
			}else {
				return null;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("oops..!There is problem in getting all the contracts: "+msg);
			return null;
			
		}
	}


	@Override
	public boolean updateContarctor(int customerId, ContractorBean contarctorToUpdate) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("uQuery"));
				) {

			pstmt.setInt(6,customerId);
			pstmt.setInt(1, contarctorToUpdate.getCustomerId());
			pstmt.setInt(2, contarctorToUpdate.getProductId());
			pstmt.setString(3, contarctorToUpdate.getHaulierId());
			pstmt.setString(4, contarctorToUpdate.getDeliveryDate());
			pstmt.setInt(5, contarctorToUpdate.getQunatity());
			result=pstmt.executeUpdate();
			if(result>0) {
				return true;

			}else {
				return false;
			}

		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("Problem in updating..: "+msg);
			return false;
		}	
	}

	@Override
	public boolean deletecontarctor(int customerIdToDeleet) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("dQuery"));
				) {
			pstmt.setInt(1, customerIdToDeleet);
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
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
				return true;

			}else {
				return false;
			}
		} catch (SQLException e) {
			String msg=e.getMessage();
			System.err.println("Problem in adding Contract: "+msg);
			return false;
		}

	}


	@Override
	public ContractorBean searchContarctor(int customerforSearch) {
		try(Connection con=DriverManager.getConnection(prop.getProperty("dburl"), 
				prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
				PreparedStatement pstmt=con.prepareStatement(prop.getProperty("sQuery"));
				) {
			pstmt.setInt(1, customerforSearch);

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
				return null;
			}
		}catch (Exception e) {
			String msg=e.getMessage();
			System.err.println("There is problem in Searching..: "+msg);
			return null;
		}
	}
}

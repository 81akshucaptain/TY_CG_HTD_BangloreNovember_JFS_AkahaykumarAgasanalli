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

import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.exception.ProductAppException;

public class ProductDAOImpl implements ProductDAO {

	Properties prop = null;
	int result;
	FileReader reader;

	public ProductDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("product.properties");
			prop = new Properties();
			prop.load(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductBean> getAllProduct() {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("getQuery"));) {
			ResultSet rs = pstmt.executeQuery();
			List<ProductBean> list = new ArrayList<ProductBean>();
			if (rs != null) {
				while (rs.next()) {
					ProductBean pBean = new ProductBean();
					pBean.setProductId(rs.getInt("productId"));
					pBean.setName(rs.getString("name"));
					pBean.setQuantity(rs.getInt("quantity"));
					pBean.setProductClass(rs.getString("productClass"));
					pBean.setCost(rs.getInt("cost"));
					list.add(pBean);
				}
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println("No Data Found For Products" + msg);
			return null;
		}
	}

	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("uQuery"));) {

			pstmt.setString(1, ProductToUpdate.getName());
			pstmt.setInt(2, ProductToUpdate.getQuantity());
			pstmt.setString(3, ProductToUpdate.getProductClass());
			pstmt.setInt(4, ProductToUpdate.getCost());
			pstmt.setInt(5, ProductToUpdate.getProductId());
			result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			String msg = e.getMessage();
			System.err.println("Problem in updating,try again: " + msg);
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int pidToDeleet) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("dQuery"));) {
			pstmt.setInt(1, pidToDeleet);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				throw new ProductAppException("Product Not Found..!");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println("problem in deleting: " + msg);
			return false;
		}

	}

	@Override
	public boolean addProduct(ProductBean Product) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("iQuery"));) {

			pstmt.setInt(1, Product.getProductId());
			pstmt.setString(2, Product.getName());
			pstmt.setInt(3, Product.getQuantity());
			pstmt.setString(4, Product.getProductClass());
			pstmt.setInt(5, Product.getCost());
			result = pstmt.executeUpdate();
			if (result > 0) {
				return true;

			} else {
				throw new ProductAppException("Product may Exist..!");
			}

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println("problem in adding product: " + msg);
			return false;
		}
	}

	@Override
	public ProductBean searchProduct(int pidforSearch) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("sQuery"));) {
			pstmt.setInt(1, pidforSearch);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next() == true) {
				ProductBean prBean = new ProductBean();
				prBean.setProductId(rs.getInt(1));
				prBean.setName(rs.getString(2));
				prBean.setQuantity(rs.getInt(3));
				prBean.setProductClass(rs.getString(4));
				prBean.setCost(rs.getInt(5));
				return prBean;
			} else {
				throw new ProductAppException("Product Not Found..!");
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println("There is problem in searching the product : " + msg);
			return null;
		}
	}

	@Override
	public boolean checkIsTherePID(int productIdForCheck) {
		try (Connection con = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"),
				prop.getProperty("dbpassword"));
				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("sQuery"));) {
			pstmt.setInt(1, productIdForCheck);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				int pid = rs.getInt(1);
				if (pid == productIdForCheck) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println("There is problem in finding the productID : " + msg);
			return false;
		}
	}

}

package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmnagementdb.bean.CustomerBean;
import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.dao.CustomerDAOImpl;
import com.capgemini.forestmnagementdb.dao.ProductDAO;
import com.capgemini.forestmnagementdb.dao.ProductDAOImpl;
import com.capgemini.forestmnagementdb.exception.CustomerAppException;

public class ProductDAOImplTest {
	ProductDAO productDao = null;
	ProductBean proBean = null;

	@BeforeEach
	void testProductDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("product.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("DriverClass"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productDao = new ProductDAOImpl();
	}

//	@Test
//	void addProduct() {
//		proBean = new ProductBean();
//		proBean.setProductId(25889);
//		proBean.setCost(25889);
//		proBean.setName("QQQQQ");
//		proBean.setProductClass("A");
//		proBean.setQuantity(6254);
//		try {
//			boolean flag = productDao.addProduct(proBean);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				productDao.addProduct(proBean);
//			});
//		}
//	}

//	@Test
//	void testDeleteProduct() {
//		try {
//			boolean flag = productDao.deleteProduct(25889);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				productDao.addProduct(proBean);
//			});
//		}
//	}

	@Test
	void testSearchForTrue() {
		int productId = 25889;
		try {
			ProductBean bean = productDao.searchProduct(productId);
			assertEquals(bean != null, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.searchProduct(productId);
			});
		}
	}

	@Test
	void testSearchForFalse() {
		int productId = 5544;
		try {
			ProductBean bean = productDao.searchProduct(productId);
			assertEquals(bean != null, false);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.searchProduct(productId);
			});
		}

	}

	@Test
	void testUpdateProduct() {
		ProductBean product = new ProductBean();
		product.setProductId(25889);
		product.setName("TIMBERBIG");
		product.setQuantity(8888);
		product.setCost(9999);
		product.setProductClass("W");
		try {
			boolean flag = productDao.updateProduct(product);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.updateProduct(product);
			});
		}
	}

	@Test
	void testGetAllProduct() {
		List<ProductBean> list = productDao.getAllProduct();
		assertNotNull(list);
	}

}

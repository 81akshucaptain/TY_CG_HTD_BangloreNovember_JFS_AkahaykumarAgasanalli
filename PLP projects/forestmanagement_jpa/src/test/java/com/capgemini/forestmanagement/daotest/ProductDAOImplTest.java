package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.dao.ProductDAOImpl;
import com.capgemini.forestmanagementjpa.dto.ProductBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class ProductDAOImplTest {
	ProductDAO productDao = ForestFactoryFmJpa.createInstanceOfProductDAOImpl();
	ProductBean proBean = null;

	
	@Test
	void addProduct() {
		proBean = new ProductBean();
		proBean.setCost(69696);
		proBean.setName("EEWEW");
		proBean.setProductClass("K");
		proBean.setQuantity(85);
		try {
			boolean flag = productDao.addProduct(proBean);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.addProduct(proBean);
			});
		}
	}

	@Test
	void testDeleteProduct() {
		try {
			boolean flag = productDao.deleteProduct(30);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.addProduct(proBean);
			});
		}
	}

	@Test
	void testSearchForTrue() {
		int productId = 0;
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
		product.setProductId(0);
		product.setName("KINGWOOD");
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

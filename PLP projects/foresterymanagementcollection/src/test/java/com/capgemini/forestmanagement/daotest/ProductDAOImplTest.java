package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.ProductDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class ProductDAOImplTest {
	ProductDAO productDao = ForestFactory.insatnceOfProductDAOImpl();
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
			boolean flag = productDao.deleteProduct(proBean.getProductId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.addProduct(proBean);
			});
		}
	}

	/*@Test
	void testSearchForTrue() {
		int productId = this.proBean.getProductId();
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
	void testGetAllProduct() {
		HashMap<Integer, ProductBean> list = productDao.getAllProduct();
		assertNotNull(list);
	}
	*/
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
		product.setProductId(product.getProductId());
		product.setName("KINGWOOD");
		product.setQuantity(8888);
		product.setCost(9999);
		product.setProductClass("W");
		try {
			boolean flag = productDao.updateProduct(product.getProductId(), product);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				productDao.updateProduct(product.getProductId(), product);
			});
		}
	}

	

}

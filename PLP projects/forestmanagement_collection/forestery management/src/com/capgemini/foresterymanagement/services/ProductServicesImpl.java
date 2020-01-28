package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;
import com.capgemini.foresterymanagement.dao.ProductDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class ProductServicesImpl implements ProductServices {

	ProductDAO productDao=ForestFactory.insatnceOfProductDAOImpl();

	@Override
	public boolean isThereProductId(int pid) {
		return productDao.isThereProductId(pid);
	}

	@Override
	public void getAllProduct() {
		productDao.getAllProduct();
	}

	@Override
	public boolean updateProduct(int pid, ProductBean ProductToUpdate) {
		return productDao.updateProduct(pid, ProductToUpdate);
	}

	@Override
	public boolean deleteProduct(int pid) {
		return productDao.deleteProduct(pid);
	}

	@Override
	public boolean addProduct(ProductBean product) {
		return productDao.addProduct(product);
	}

	@Override
	public ProductBean searchProduct(int pid) {
		return productDao.searchProduct(pid);
	}

}

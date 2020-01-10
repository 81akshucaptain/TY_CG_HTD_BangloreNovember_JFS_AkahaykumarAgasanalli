package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class ProductServicesImpl implements ProductServices {

	ProductDAO productDao=ForestFactoryFmJpa.createInstanceOfProductDAOImpl();

	@Override
	public void getAllProduct() {
		// TODO Auto-generated method stub
		productDao.getAllProduct();
	}

	@Override
	public boolean updateProduct(com.capgemini.forestmanagementjpa.dto.ProductBean ProductToUpdate) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(ProductToUpdate);
	}

	@Override
	public boolean deleteProduct(int cid) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(cid);
	}

	@Override
	public boolean addProduct(com.capgemini.forestmanagementjpa.dto.ProductBean Product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(Product);
	}

	@Override
	public com.capgemini.forestmanagementjpa.dto.ProductBean searchProduct(int cid) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(cid);
	}

	@Override
	public boolean checkIsTherePID(int pid) {
		// TODO Auto-generated method stub
		return productDao.checkIsTherePID(pid);
	}

}
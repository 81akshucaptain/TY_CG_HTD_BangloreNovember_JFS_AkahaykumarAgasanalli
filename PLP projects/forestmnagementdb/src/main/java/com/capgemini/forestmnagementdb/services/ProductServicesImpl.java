package com.capgemini.forestmnagementdb.services;

import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.dao.ProductDAO;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;

public class ProductServicesImpl implements ProductServices {

	ProductDAO productDao=ForestFactoryJdbc.createInstanceOfProductDAOImpl();

	@Override
	public void getAllProduct() {
		// TODO Auto-generated method stub
		productDao.getAllProduct();
	}

	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(ProductToUpdate);
	}

	@Override
	public boolean deleteProduct(int cid) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(cid);
	}

	@Override
	public boolean addProduct(ProductBean Product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(Product);
	}

	@Override
	public ProductBean searchProduct(int cid) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(cid);
	}

	@Override
	public boolean checkIsTherePID(int pid) {
		// TODO Auto-generated method stub
		return productDao.checkIsTherePID(pid);
	}

	
}

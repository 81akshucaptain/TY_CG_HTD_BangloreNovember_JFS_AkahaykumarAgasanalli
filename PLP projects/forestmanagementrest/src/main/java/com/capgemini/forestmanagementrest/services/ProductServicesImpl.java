package com.capgemini.forestmanagementrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.dao.ProductDAO;
import com.capgemini.forestmanagementrest.dto.ProductBean;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	ProductDAO productDao;

	@Override
	public List<ProductBean> getAllProduct() {
		return productDao.getAllProduct();
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
	public boolean checkIsTherePID(int pid) {
		// TODO Auto-generated method stub
		return productDao.checkIsTherePID(pid);
	}

	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(ProductToUpdate);
	}

	@Override
	public ProductBean searchProduct(int cid) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(cid);
	}

}
package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import com.capgemini.forestmanagementrest.dto.ProductBean;

public interface ProductDAO {
	public List<ProductBean> getAllProduct();
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int cid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public ProductBean searchProduct(int cid);
	public boolean checkIsTherePID(int pid);
}

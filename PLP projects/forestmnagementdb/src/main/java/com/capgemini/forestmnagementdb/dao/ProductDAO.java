package com.capgemini.forestmnagementdb.dao;

import java.util.List;

import com.capgemini.forestmnagementdb.bean.ProductBean;

public interface ProductDAO {
	public List<ProductBean> getAllProduct();
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int productId);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public ProductBean searchProduct(int productId);
	public boolean checkIsTherePID(int productId);
}

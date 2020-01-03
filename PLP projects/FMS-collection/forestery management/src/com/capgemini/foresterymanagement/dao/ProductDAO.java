package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;

import com.capgemini.foresterymanagement.bean.ProductBean;

public interface ProductDAO {
	public boolean isThereProductId(int pid);
	public HashMap<Integer, ProductBean> getAllProduct();
	public boolean updateProduct(int pid,ProductBean ProductToUpdate);
	public boolean deleteProduct(int pid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean product);
	public ProductBean searchProduct(int pid);
}

package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ProductBean;

public interface ProductServices {
	public boolean isThereProductId(int pid);
	public void getAllProduct();
	public boolean updateProduct(int pid,ProductBean ProductToUpdate);
	public boolean deleteProduct(int pid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean product);
	public ProductBean searchProduct(int pid);
}

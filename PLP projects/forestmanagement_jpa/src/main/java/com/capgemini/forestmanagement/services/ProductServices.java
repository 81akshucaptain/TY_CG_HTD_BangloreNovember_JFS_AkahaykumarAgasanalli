package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dto.ProductBean;

public interface ProductServices {
	public void getAllProduct();
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int cid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public ProductBean searchProduct(int cid);
	public boolean checkIsTherePID(int pid);
}

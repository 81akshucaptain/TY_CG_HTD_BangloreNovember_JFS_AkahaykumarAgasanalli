package com.capgemini.forestmanagementboot.services;

import java.util.List;

import com.capgemini.forestmanagementboot.dto.ProductBean;

public interface ProductServices {
	public List<ProductBean> getAllProduct();
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int cid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public ProductBean searchProduct(int cid);
	public boolean checkIsTherePID(int pid);
}

package com.capgemini.forestmnagement.dao;

import com.capgemini.forestmnagement.bean.ProductBean;

public interface ProductDAO {
	public void getAllProduct();
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int cid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public ProductBean searchProduct(int cid);
	public boolean checkIsTherePID(int pid);
}

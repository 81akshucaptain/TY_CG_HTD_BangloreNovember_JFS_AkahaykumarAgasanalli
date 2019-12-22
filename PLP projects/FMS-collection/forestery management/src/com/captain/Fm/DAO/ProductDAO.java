package com.captain.Fm.DAO;

import com.captain.Fm.bean.ProductBean;

public interface ProductDAO {
	public void getAllProduct();
	public boolean updateProduct(int pid,ProductBean ProductToUpdate);
	public boolean deleteProduct(int pid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean product);
	public ProductBean searchProduct(int pid);
}

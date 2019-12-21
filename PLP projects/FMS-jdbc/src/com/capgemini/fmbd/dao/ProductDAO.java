package com.capgemini.fmbd.dao;

import com.capgemini.fmdb.bean.ProductBean;

public interface ProductDAO {
	public void getAllProduct();
	public void Productlogin(String cid,String name);
	public boolean updateProduct(ProductBean ProductToUpdate);
	public boolean deleteProduct(int cid);
	//create ProductBean obje and pass to insert all values
	public boolean addProduct(ProductBean Product);
	public void searchProduct(int cid);

}

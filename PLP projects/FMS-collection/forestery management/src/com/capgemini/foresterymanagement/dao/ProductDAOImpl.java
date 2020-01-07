package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.*;
import com.capgemini.foresterymanagement.exception.ProductAppException;

public class ProductDAOImpl implements ProductDAO {
	private static HashMap<Integer, ProductBean> h1 = new HashMap<Integer, ProductBean>();
	int pid = 0;
	ProductBean toContractPage = null;

	@Override
	public HashMap<Integer, ProductBean> getAllProduct() {
		if (h1.isEmpty() == false) {
			return h1;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateProduct(int pidToUpdate, ProductBean ProductToUpdate) {
		if (h1.containsKey(pidToUpdate)) {
			h1.replace(pidToUpdate, ProductToUpdate);
			return true;
		} else {
		}
		throw new ProductAppException("Product Not Found, Please Try Again..!");
	}

	@Override
	public boolean deleteProduct(int pidToDelete) {
		if (h1.containsKey(pidToDelete)) {
			h1.remove(pidToDelete);
			return true;
		} else {
			throw new ProductAppException("Product Not Found, Please Try Again..!");
		}

	}

	@Override
	public boolean addProduct(ProductBean product) {
		// used in below isThereProducts() method
		toContractPage = product;
		while (true) {
			if (product != null) {
				++pid;
				product.setPid(pid);
				h1.put(pid, product);
				return true;
			} else {
				throw new ProductAppException("ProductId May Exist..! Try Again");
			}
		}
	}

	@Override
	public ProductBean searchProduct(int pid) {
		if (h1.containsKey(pid) == true) {
			return h1.get(pid);
		} else {
			throw new ProductAppException("ProductId Not Found..! Try Again");
		}
	}

	@Override
	public boolean isThereProductId(int pid) {
		if (h1.containsKey(pid)) {
			return true;
		} else {
			return false;
		}
	}

}

package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.*;
import com.capgemini.foresterymanagement.exception.ProductAppException;

public class ProductDAOImpl implements ProductDAO {
	private static HashMap<Integer, ProductBean> h1 = new HashMap<Integer, ProductBean>();
	int productId = 0;
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
	public boolean updateProduct(int productIdToUpdate, ProductBean ProductToUpdate) {
		if (h1.containsKey(productIdToUpdate)) {
			h1.replace(productIdToUpdate, ProductToUpdate);
			return true;
		} else {
		}
		throw new ProductAppException("Product Not Found, Please Try Again..!");
	}

	@Override
	public boolean deleteProduct(int productIdToDelete) {
		if (h1.containsKey(productIdToDelete)) {
			h1.remove(productIdToDelete);
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
				++productId;
				product.setProductId(productId);
				h1.put(productId, product);
				return true;
			} else {
				throw new ProductAppException("ProductId May Exist..! Try Again");
			}
		}
	}

	@Override
	public ProductBean searchProduct(int productId) {
		if (h1.containsKey(productId) == true) {
			return h1.get(productId);
		} else {
			throw new ProductAppException("ProductId Not Found..! Try Again");
		}
	}

	@Override
	public boolean isThereProductId(int productId) {
		if (h1.containsKey(productId)) {
			return true;
		} else {
			return false;
		}
	}

}

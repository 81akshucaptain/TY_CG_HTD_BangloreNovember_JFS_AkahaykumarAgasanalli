package com.capgemini.foresterymanagement.dao;


import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.*;
public class ProductDAOImpl implements ProductDAO {
	private static HashMap<Integer,ProductBean> h1=new HashMap<Integer,ProductBean>();
	int pid=0;
	ProductBean toContractPage=null;
	@Override
	public void getAllProduct() {
		try{
			System.out.println("                            ::::ALL PRODUCTS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				System.out.println("PRODUCT-ID: "+key);
				ProductBean cb=h1.get(key);
				System.out.println(cb);
			}
		}catch (Exception e) {
			System.err.println("There is problem in displaying all the products");
		}
	}

	@Override
	public boolean updateProduct(int pidToUpdate, ProductBean ProductToUpdate) {
		try{
			if(h1.containsKey(pidToUpdate)) {
				h1.replace(pidToUpdate,ProductToUpdate );
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.err.println("There is problem in Updation..!");
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int pidToDelete) {
		try {
			if(h1.containsKey(pidToDelete)) {
				System.out.println("The specified product got deleted");
				h1.remove(pidToDelete);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.err.println("There is problem in Deletion..!");
			return false;
		}
	}

	@Override
	public boolean addProduct(ProductBean product) {
		//used in below isThereProducts() method
		toContractPage=product;
		while(true) {
			try {
				if(product!=null) {
					++pid;
					product.setPid(pid);
					h1.put(pid,product);
					System.out.println("Product with  PRODUCT-ID: "+pid+"  added successfully (remember this)");
					return true;
				}else {
					return false;
				}
			}catch (Exception e) {
				System.err.println("There is problem in Adding..!");
			}	
		}
	}
	@Override
	public ProductBean searchProduct(int pid) {
		try {
			if(h1.containsKey(pid)==true) {
				return h1.get(pid);
			}else {
				return null;
			}
		}catch (Exception e) {
			System.err.println("There is problem in Searching..!");
			return null;
		}
	}

	@Override
	public boolean isThereProductId(int pid) {
		if(h1.containsKey(pid)) {
			return true;
		}else {
			return false;
		}
	}

}

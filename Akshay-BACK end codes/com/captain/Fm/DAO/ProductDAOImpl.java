package com.captain.Fm.DAO;


import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.ProductBean;

import java.util.HashMap;

import com.captain.Fm.bean.*;
public class ProductDAOImpl implements ProductDAO {
	HashMap<Integer,ProductBean> h1=new HashMap<Integer,ProductBean>();
	int pid=0;

	@Override
	public void getAllProduct() {
		System.out.println(h1);
		
	}

	@Override
	public ProductBean Productlogin(String cid, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProduct(int pidToUpdate, ProductBean ProductToUpdate) {
		h1.replace(pidToUpdate,ProductToUpdate );
		return true;	
		}

	@Override
	public boolean deleteProduct(int pidToDelete) {
		System.out.println("The specified Contrcator got delated");
		h1.remove(pidToDelete);
		return true;	}

	@Override
	public boolean addProduct(ProductBean product) {
		while(true) {
			++pid;
			h1.put(pid,product);
			System.out.println("hello contractor your ID is : "+pid+" please remember..! Else GOVINDA..!");
			return true;
		}		}

	@Override
	public ProductBean searchProduct(int pid) {
		if(h1.containsKey(pid)==true) {
			return h1.get(pid);
		}else {
			return null;
		}
	}

}

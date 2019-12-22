package com.captain.Fm.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	private static HashMap<Integer,CustomerBean> h1=new HashMap<Integer,CustomerBean>();
	static int cid=0;
	CustomerBean cbToLogin=null;
	@Override
	public void getAllCustomer() {
		System.out.println("                            ::::ALL CUSTOMER::::");
		Set<Integer> s=h1.keySet();
		for (Integer key : s) {
			CustomerBean cb=h1.get(key);
			System.out.println("CONTRACT-ID: "+key);
			System.out.println(cb);
		}
	}

	@Override
	public boolean customerlogin(int cid, String name ) {
		Set<Integer> s=h1.keySet();
		for (Integer key : s) {
			if(key==cid) {
				CustomerBean cbToLogin=h1.get(key);
				if(cbToLogin.getName().equals(name)) {
					return true;
				}
				else {
					System.err.println("Invalid user name..!please enter valid name");
					return false;
				}
			}
		}
		System.err.println("HELLO CUSTOMER YOU ARE NOT PART OF THIS BUSINESS(not added to system)..!");
		return false;
	}

	@Override
	public boolean updateCustomer(int cidToUpdate,CustomerBean cutomerToUpdate) {
		h1.replace(cidToUpdate,cutomerToUpdate );
		return true;
	}

	@Override
	public boolean deleteCustomer(int cidToDelete) {
		System.out.println("The specified Customer got delated");
		h1.remove(cidToDelete);
		return true;
	}

	@Override

	public boolean addCustomer(CustomerBean customer) {
		while(true) {
			//TO VALLIDATE THE CUSTOMER-name and EMAIL 
			//I NEED REFRENCE HENCE
			cbToLogin=customer;
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++cid;
			customer.setCid(cid);
			h1.put(cid,customer);
			System.out.println("Customer with Customer-ID is : "+cid+" added successfully. (please remember)");
			return true;
		}
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		if(h1.containsKey(cid)==true) {
			return h1.get(cid);
		}else {
			return null;
		}

	}

}

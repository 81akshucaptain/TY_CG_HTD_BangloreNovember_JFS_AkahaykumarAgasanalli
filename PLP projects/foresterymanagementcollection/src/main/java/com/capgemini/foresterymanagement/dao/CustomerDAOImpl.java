package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.exception.CustomerAppException;

public class CustomerDAOImpl implements CustomerDAO {
	private static HashMap<Integer,CustomerBean> h1=new HashMap<Integer,CustomerBean>();
	static int customerId=0;
	CustomerBean cbToLogin=null;

	@Override
	public HashMap<Integer, CustomerBean> getAllCustomer() {
		if(h1.isEmpty()==false) {
			return h1;
		}
		else {
			throw new CustomerAppException("No Data Found for Customers..!");
		}
	}
	@Override
	public boolean customerLogin(int customerId, String email ) {
		Set<Integer> s=h1.keySet();
		for (Integer key : s) {
			if(key==customerId) {
				CustomerBean cbToLogin=h1.get(key);
				if((cbToLogin.getPassword().equals(email))) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		throw new CustomerAppException("HELLO CUSTOMER YOU ARE NOT PART OF THIS BUSINESS(not added to system)..!");

	}

	@Override
	public boolean updateCustomer(int cidToUpdate,CustomerBean cutomerToUpdate) {
		if(h1.replace(cidToUpdate,cutomerToUpdate )!=null) {
			return true;
		}else{
			throw new CustomerAppException("Customer Not Found, Problem in updating try again..!");
		}
	}

	@Override
	public boolean deleteCustomer(int cidToDelete) {
		if(h1.remove(cidToDelete)!=null) {
			return true;
		}
		else {
			throw new CustomerAppException("Customer Not Found..!");
		}
	}

	@Override

	public boolean addCustomer(CustomerBean customer) {
		while(true) {
			//TO VALLIDATE THE CUSTOMER-name and EMAIL 
			//I NEED REFRENCE HENCE
			cbToLogin=customer;
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++customerId;
			customer.setCustomerId(customerId);;
			try
			{
				h1.put(customerId,customer);
				return true;
			}catch (Exception e) {
				throw new CustomerAppException("Dumplicate CustomerID, please try again..!");
			}
		}
	}

	@Override
	public CustomerBean searchCustomer(int customerId) {
		if(h1.containsKey(customerId)==true) {
			return h1.get(customerId);
		}else {
			return null;
		}

	}
	@Override
	public CustomerBean searchPassword(int customerId) {
		if(h1.containsKey(customerId)==true) {
			return h1.get(customerId);
		}else {
			return null;
		}	
	}
	
}

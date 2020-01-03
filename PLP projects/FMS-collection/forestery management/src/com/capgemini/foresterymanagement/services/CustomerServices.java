package com.capgemini.foresterymanagement.services;

import java.util.Map;

import com.capgemini.foresterymanagement.bean.CustomerBean;


public interface CustomerServices {
	public void getAllCustomer();
	public boolean customerLogin(int id,String email);
	public boolean updateCustomer(int cid,CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);

}

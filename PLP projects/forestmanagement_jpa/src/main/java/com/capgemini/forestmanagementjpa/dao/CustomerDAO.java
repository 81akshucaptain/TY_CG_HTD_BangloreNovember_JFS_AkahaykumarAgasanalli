package com.capgemini.forestmanagementjpa.dao;

import com.capgemini.forestmanagementjpa.dto.CustomerBean;
public interface CustomerDAO {
	public void getAllCustomer();
	public boolean updateCustomer(CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public void addCustomer(CustomerBean customer);
	public void searchCustomer(int cid);
	public boolean customerlogin(int cid, String email);
}

package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import com.capgemini.forestmanagementrest.dto.CustomerBean;
public interface CustomerDAO {
	public List<CustomerBean> getAllCustomer();
	public boolean updateCustomer(CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);
	public boolean customerlogin(int cid, String password);
}

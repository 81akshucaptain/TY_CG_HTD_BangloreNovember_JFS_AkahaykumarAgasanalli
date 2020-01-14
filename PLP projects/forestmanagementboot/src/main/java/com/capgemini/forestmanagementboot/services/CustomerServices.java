package com.capgemini.forestmanagementboot.services;

import java.util.List;

import com.capgemini.forestmanagementboot.dto.CustomerBean;


public interface CustomerServices {
	public List<CustomerBean> getAllCustomer();
	public boolean customerLogin(int id,String password);
	public boolean updateCustomer(int cid,CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);

}

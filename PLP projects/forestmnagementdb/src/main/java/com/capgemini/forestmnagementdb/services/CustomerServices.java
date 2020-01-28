package com.capgemini.forestmnagementdb.services;

import com.capgemini.forestmnagementdb.bean.CustomerBean;


public interface CustomerServices {
	public void getAllCustomer();
	public boolean customerLogin(int id,String email);
	public boolean updateCustomer(int cid,CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);

}

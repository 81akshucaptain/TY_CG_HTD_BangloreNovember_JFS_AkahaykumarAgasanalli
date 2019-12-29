package com.capgemini.forestmnagement.dao;
import java.util.List;

import com.capgemini.forestmnagement.bean.CustomerBean;

public interface CustomerDAO {
	public void getAllCustomer();
	public boolean updateCustomer(CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public void searchCustomer(int cid);
	public boolean customerlogin(int cid, String email);

}

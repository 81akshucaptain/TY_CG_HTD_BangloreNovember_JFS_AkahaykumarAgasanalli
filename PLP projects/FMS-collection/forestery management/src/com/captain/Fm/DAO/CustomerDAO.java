package com.captain.Fm.DAO;

import java.util.Map;

import com.captain.Fm.bean.CustomerBean;


public interface CustomerDAO {
	public void getAllCustomer();
	public boolean customerlogin(int id,String name);
	public boolean updateCustomer(int cid,CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);

}

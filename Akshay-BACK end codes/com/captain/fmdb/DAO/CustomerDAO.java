package com.captain.fmdb.DAO;

import java.util.List;

import com.capatin.fmdb.bean.CustomerBean;

public interface CustomerDAO {
	public void getAllCustomer();
	public CustomerBean Customerlogin(String cid,String name);
	public boolean updateCustomer(int cid,CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public List<CustomerBean> searchCustomer(int cid);

}

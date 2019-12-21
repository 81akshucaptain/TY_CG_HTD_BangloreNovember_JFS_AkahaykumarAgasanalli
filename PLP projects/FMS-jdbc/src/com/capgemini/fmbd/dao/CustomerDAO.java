package com.capgemini.fmbd.dao;
import java.util.List;
import com.capgemini.fmdb.bean.CustomerBean;

public interface CustomerDAO {
	public void getAllCustomer();
	public void Customerlogin(String cid,String name);
	public boolean updateCustomer(CustomerBean CustomerToUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean obje and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public void searchCustomer(int cid);

}

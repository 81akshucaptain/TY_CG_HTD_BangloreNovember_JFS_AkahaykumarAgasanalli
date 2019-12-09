package com.captain.Fm.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.captain.Fm.bean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	HashMap<Integer,CustomerBean> h1=new HashMap<Integer,CustomerBean>();
	int cid=0;
	@Override
	public void getAllCustomer() {
		System.out.println(h1);
	}

	@Override
	public CustomerBean Customerlogin(String cid, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(int cidToUpdate,CustomerBean cutomerToUpdate) {
		h1.replace(cidToUpdate,cutomerToUpdate );
		return true;
	}

	@Override
	public boolean deleteCustomer(int cidToDelete) {
		System.out.println("The specified Customer got delated");
		h1.remove(cidToDelete);
		return true;
	}

	@Override

	public boolean addCustomer(CustomerBean customer) {
		while(true) {
			++cid;
			h1.put(cid,customer);
			System.out.println("hello Customer your ID is : "+cid+" : please remember..! Else GOVINDA..!");
			return true;
		}
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		if(h1.containsKey(cid)==true) {
			return h1.get(cid);
		}else {
			return null;
		}

	}

}

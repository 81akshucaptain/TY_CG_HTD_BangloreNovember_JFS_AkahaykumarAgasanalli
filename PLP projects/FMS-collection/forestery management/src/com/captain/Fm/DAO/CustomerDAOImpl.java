package com.captain.Fm.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.captain.Fm.bean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	private static HashMap<Integer,CustomerBean> h1=new HashMap<Integer,CustomerBean>();
	static int cid=0;
	static CustomerBean cbToLogin=null;
	@Override
	public void getAllCustomer() {
		System.out.println(h1);
	}

	@Override
	public boolean customerlogin(String cname, String email) {
		try{
			if((cbToLogin.getName().equals(cname)) &&(cbToLogin.getEmail().equals(email))) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			String msg=e.getMessage();
			System.out.println("hello customer:"+msg);
			System.err.println("HELLO CUSTOMER YOUR NOT PART OF THIS BUSINESS(not added to system)..!");
			return false;

		}
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
			cbToLogin=customer;
			++cid;
			h1.put(cid,customer);
			System.out.println("hello Customer your ID is : "+cid+"  (please remember)");
			return true;
		}
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		if(h1.containsKey(cid)==true) {
			System.out.println("Customer With PID: "+cid);
			return h1.get(cid);
		}else {
			return null;
		}

	}

}

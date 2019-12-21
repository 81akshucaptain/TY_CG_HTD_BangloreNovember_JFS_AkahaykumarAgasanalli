package com.captain.Fm.DAO;

import com.captain.Fm.bean.AdminBean;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean adminLogin(String uname, String password,AdminBean admin) {
		try{

			if((admin.getName().equals(uname)) &&(admin.getPassword1().equals(password))) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			System.err.println("Please Register First..!");
			return false;

		}
	}
}
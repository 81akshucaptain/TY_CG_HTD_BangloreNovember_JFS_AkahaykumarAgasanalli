package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.SchedularBean;

public class SchedularDAOImpl implements SchedularDAO{

	@Override
	public boolean schedularLogin(String name, String password, SchedularBean scbean) {
		try{

			if((scbean.getUserName().equals(name)) &&(scbean.getPassword().equals(password))) {
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



package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.SchedularBean;
import com.capgemini.foresterymanagement.dao.SchedularDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class SchedularServicesImpl implements SchedularServices{
	SchedularDAO schedularDao= ForestFactory.InstanceOfSchedularDAOImpl();
	
	@Override
	public boolean schedularLogin(String name, String password, SchedularBean scbean) {
		return schedularDao.schedularLogin(name, password, scbean);
	}

}

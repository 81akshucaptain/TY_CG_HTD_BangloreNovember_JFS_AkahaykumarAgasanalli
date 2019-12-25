package com.capgemini.foresterymanagement.factory;

import com.capgemini.foresterymanagement.dao.AdminDAO;
import com.capgemini.foresterymanagement.dao.AdminDAOImpl;
import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.dao.ContractorDAOImpl;
import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.dao.CustomerDAOImpl;
import com.capgemini.foresterymanagement.dao.LandsDAO;
import com.capgemini.foresterymanagement.dao.LandsDAOImpl;
import com.capgemini.foresterymanagement.dao.ProductDAO;
import com.capgemini.foresterymanagement.dao.ProductDAOImpl;

public class ForestFactory {
public static CustomerDAO instanceOfCustomerDAOImpl() {
	return new CustomerDAOImpl();
}
public static ContractorDAO instanceOfContractorDAOImpl() {
	return new ContractorDAOImpl();
}
public static ProductDAO insatnceOfProductDAOImpl() {
	return new ProductDAOImpl();
}
public static AdminDAO insatnceOfAdminDAOImpl() {
	return new AdminDAOImpl();	
}
public static LandsDAO InstanceOfLandDAOImpl() {
	return new LandsDAOImpl();
}
}

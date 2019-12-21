package com.captain.Fm.Factory;

import com.captain.Fm.DAO.AdminDAO;
import com.captain.Fm.DAO.AdminDAOImpl;
import com.captain.Fm.DAO.ContractorDAO;
import com.captain.Fm.DAO.ContractorDAOImpl;
import com.captain.Fm.DAO.CustomerDAO;
import com.captain.Fm.DAO.CustomerDAOImpl;
import com.captain.Fm.DAO.ProductDAO;
import com.captain.Fm.DAO.ProductDAOImpl;

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

}

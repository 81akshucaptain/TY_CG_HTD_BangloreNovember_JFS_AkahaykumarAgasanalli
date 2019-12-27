package com.capgemini.fmdb.factory;

import com.capgemini.fmbd.dao.ContractorDAO;
import com.capgemini.fmbd.dao.ContractorDAOImpl;
import com.capgemini.fmbd.dao.CustomerDAO;
import com.capgemini.fmbd.dao.CustomerDAOImpl;
import com.capgemini.fmbd.dao.LandsDAO;
import com.capgemini.fmbd.dao.LandsDAOImpl;
import com.capgemini.fmbd.dao.ProductDAO;
import com.capgemini.fmbd.dao.ProductDAOImpl;

public class ForestFactoryFmDb {
public static CustomerDAO createInstanceOfCustomerDAOImpl() {
	return new CustomerDAOImpl();
}
public static ProductDAO createInstanceOfProductDAOImpl() {
	return new ProductDAOImpl();
}
public static ContractorDAO createInstanceOfContractorDAOImpl() {
	return new ContractorDAOImpl();
}
public static LandsDAO createInstanceOfLandsDAOImpl() {
	return new LandsDAOImpl();
}

}

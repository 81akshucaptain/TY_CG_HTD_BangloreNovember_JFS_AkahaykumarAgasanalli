package com.capgemini.fmdb.factory;

import com.capgemini.fmbd.dao.CustomerDAO;
import com.capgemini.fmbd.dao.CustomerDAOImpl;
import com.capgemini.fmbd.dao.ProductDAO;
import com.capgemini.fmbd.dao.ProductDAOImpl;

public class ForestFactoryFmDb {
public static CustomerDAO createInstanceOfCustomerDAOImpl() {
	return new CustomerDAOImpl();
}
public static ProductDAO createInstanceOfProductDAOImpl() {
	return new ProductDAOImpl();
}
}

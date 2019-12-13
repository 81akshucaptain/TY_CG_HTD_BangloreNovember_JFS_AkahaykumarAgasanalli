package com.capgemini.phone.contactFactory;

import com.capgemini.phone.contactDAO.ContactDAO;
import com.capgemini.phone.contactDAO.ContactDAOImpl;

public class ContactFactory {
	public static ContactDAO createInstanceOfContactDAOImpl() {
		ContactDAOImpl cdao=new ContactDAOImpl();
		return cdao;
	}
}

package com.capgemini.phone.contactDAO;

import com.capgemini.phone.contact_bean.ContactBean;

public interface ContactDAO {
void getAllContacts();
void searchContact(String name);
void deleteContact(String name);
void updateContact(ContactBean cb2,String name);
void addContact(ContactBean cb);
}

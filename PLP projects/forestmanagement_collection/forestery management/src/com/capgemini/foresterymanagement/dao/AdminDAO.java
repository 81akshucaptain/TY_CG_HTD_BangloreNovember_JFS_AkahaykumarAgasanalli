package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.AdminBean;

public interface AdminDAO {
public boolean adminLogin(String uname,String password, AdminBean ad);
}

package com.captain.Fm.DAO;

import com.captain.Fm.bean.AdminBean;

public interface AdminDAO {
public boolean adminLogin(String uname,String password, AdminBean ad);
}

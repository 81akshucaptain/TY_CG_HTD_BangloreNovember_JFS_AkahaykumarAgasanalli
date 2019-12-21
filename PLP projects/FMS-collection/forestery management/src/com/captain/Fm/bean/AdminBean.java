package com.captain.Fm.bean;

import java.io.Serializable;

public class AdminBean implements Serializable {
	static String name;
	static String password1;

	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		AdminBean.name = name;
	}
	public  String getPassword1() {
		return password1;
	}
	public  void setPassword1(String password1) {
		AdminBean.password1 = password1;
	}
	
}

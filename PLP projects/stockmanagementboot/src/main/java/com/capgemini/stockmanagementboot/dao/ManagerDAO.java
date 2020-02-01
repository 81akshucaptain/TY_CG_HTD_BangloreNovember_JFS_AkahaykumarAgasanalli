package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;

public interface ManagerDAO {
	public List<ManagerBean> getAllManager();

	public boolean updateManager(int managerId, ManagerBean managerToUpdate);

	public boolean deleteManager(int managerId);

	public boolean addManager(ManagerBean manager);

	public ManagerBean searchManager(int managerId);

	public ManagerBean searchManagerByMail(String email);

}

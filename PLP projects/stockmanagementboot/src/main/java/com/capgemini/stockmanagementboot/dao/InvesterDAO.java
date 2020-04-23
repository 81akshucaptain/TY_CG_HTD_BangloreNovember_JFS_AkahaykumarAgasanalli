package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.InvesterBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;

public interface InvesterDAO {
	
	public List<InvesterBean> getAllInvesters();

	public boolean updateInvesters(int investerId, InvesterBean investerToUpdate);

	public boolean deleteInvester(int investerId);

	public boolean addInvester(InvesterBean invester);

	public InvesterBean searchInvester(int investerId);

	public InvesterBean searchInvesterByEmail(String investerEmail);

}
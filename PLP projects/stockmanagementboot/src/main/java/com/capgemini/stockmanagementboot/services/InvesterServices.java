package com.capgemini.stockmanagementboot.services;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.InvesterBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;

public interface InvesterServices {
	public List<InvesterBean> getAllInvesters();

	public boolean updateInvesters(int investerId, InvesterBean investerToUpdate);

	public boolean deleteInvester(int investerId);

	public boolean addInvester(InvesterBean invester);

	public InvesterBean searchInvester(int investerId);

	public InvesterBean searchInvesterByEmail(String investerEmail);

}

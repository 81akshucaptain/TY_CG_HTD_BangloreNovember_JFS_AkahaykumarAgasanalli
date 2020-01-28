package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.List;

import com.capgemini.foresterymanagement.bean.ContractorBean;

public interface ContractorDAO {
	public HashMap<Integer, ContractorBean> getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	//create contarctorBean object and pass to insert all values
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);

}

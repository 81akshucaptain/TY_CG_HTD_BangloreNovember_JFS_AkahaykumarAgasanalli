package com.capgemini.forestmnagementdb.dao;
import java.util.List;

import com.capgemini.forestmnagementdb.bean.ContractorBean;

public interface ContractorDAO {
	public List<ContractorBean> getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);
}

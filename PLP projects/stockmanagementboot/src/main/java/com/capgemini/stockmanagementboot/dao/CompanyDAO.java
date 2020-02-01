package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.CompanyBean;

public interface CompanyDAO {
	public List<CompanyBean> getAllCompany();

	public boolean updateCompany(int companyId, CompanyBean companyToUpdate);

	public boolean deleteCompany(int companyId);

	public boolean addCompany(CompanyBean company);

	public CompanyBean searchCompany(int companyId);

	public CompanyBean searchCompanyByMail(String email);

}

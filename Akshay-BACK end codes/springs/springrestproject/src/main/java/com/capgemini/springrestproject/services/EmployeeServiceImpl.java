package com.capgemini.springrestproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springrestproject.dao.EmployeeDAO;
import com.capgemini.springrestproject.dto.EmployeeAddressBean;
import com.capgemini.springrestproject.dto.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeServices  {
	//it will search for the type of employeeDAO type and 
	//it will come and sit here i.e, EmployeeDAOImpl
	@Autowired
	EmployeeDAO edao;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

	@Override
	public EmployeeBean auth(String email, String password) {
		return edao.auth(email, password);
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {

		String encodedpassword=encoder.encode(bean.getPassword());
		bean.setPassword(encodedpassword);

		List<EmployeeAddressBean> edAddressBeans =bean.getAddressbean();
		for (EmployeeAddressBean employeeAddressBean : edAddressBeans) {
			employeeAddressBean.setBean(bean);
		}
		return edao.addEmployee(bean);
	}


	@Override
	public List<EmployeeBean> getEmployees(String key) {
		return edao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		return edao.changePassword(id, encoder.encode(password));
	}

	@Override
	public boolean deleteEmployee(int id) {

		return edao.deleteEmployee(id);
	}

}

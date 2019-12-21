package com.capgemini.mywebapp.servlet.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;

public class UpdateEmployeeServletJsp extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		session.setMaxInactiveInterval(60);
		if(session !=null) {
			//Vallid Session
			int empid=Integer.parseInt(req.getParameter("empId"));
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			String salary=req.getParameter("salary");
			String designation=req.getParameter("designation");
			String password=req.getParameter("password");

			EmployeeBean empbean=new EmployeeBean();
			empbean.setAge(age);
			empbean.setDesignation(designation);
			empbean.setEmpid(empid);
			empbean.setName(name);
			empbean.setPassword(password);
			empbean.setSalary(salary);

			boolean isAdded=service.updateEmployee(empbean);
			if(isAdded) {
				req.setAttribute("msg", "Employee updted sucesfully..!");	
			}else {
				req.setAttribute("msg", "Failed to update the Employee details..!");
			}
			req.getRequestDispatcher("./updateEmpJsp.jsp").forward(req, resp);

		} else {
			//invalids sesion
			req.setAttribute("msg", "Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	//end of session validation
	}//end of dopost
}//end of class

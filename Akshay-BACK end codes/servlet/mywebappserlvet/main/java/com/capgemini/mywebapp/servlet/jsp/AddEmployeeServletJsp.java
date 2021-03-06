package com.capgemini.mywebapp.servlet.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;
@WebServlet("/addEmployee2")
public class AddEmployeeServletJsp extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session!=null) {
			//valid session
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

			boolean isAdded=service.addEmployee(empbean);
			if(isAdded) {
				req.setAttribute("msg", "Employee added sucesfully..!");	
			}else {
				req.setAttribute("msg", "Failed to Add the Employee..!");
			}
			
		    req.getRequestDispatcher("./addEmpJsp.jsp").forward(req, resp);
		}else {
			//invalids sesion
			req.setAttribute("msg", "Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}//end of session validation
	}//end of dopst
}//end of class

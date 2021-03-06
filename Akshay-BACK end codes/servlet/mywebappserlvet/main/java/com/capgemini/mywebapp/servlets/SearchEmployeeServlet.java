package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;
@WebServlet("/searchEmployee")

public class SearchEmployeeServlet  extends HttpServlet{
	
	private EmployeeService employeeService=new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get the form data
		String empIdval=req.getParameter("empId");
		int empid=Integer.parseInt(empIdval);
		
		
		EmployeeBean employeeInfoBean=employeeService.searchEmployee(empid);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(employeeInfoBean!=null) {
			out.println("<h3>Employee Id "+empid +" Found-</h3>");
			out.println("<h3>Name "+employeeInfoBean.getName() +" Found-</h3>");
			out.println("<h3>Age "+employeeInfoBean.getAge() +" Found-</h3>");
			out.println("<h3>Salary "+employeeInfoBean.getSalary() +" Found-</h3>");
			out.println("<h3>Designation "+employeeInfoBean.getDesignation() +" Found-</h3>");
			
			
			
		}
		
		else
		{
			System.out.println("<h3 style=color:red>EmployeeID"+empid+"Not Found");
		}
		
		
		
		
	}//End of Get

}//End of Class

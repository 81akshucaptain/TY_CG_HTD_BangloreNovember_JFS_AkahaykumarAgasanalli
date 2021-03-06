package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;
@WebServlet("/searchEmployee2")

public class SearchEmployeeServlet2 extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VALIDATING THE SESSIONS 
		//VALIDATING THE SESSIONS 
		//VALIDATING THE SESSIONS 
		//why false why not true,means we have already created the session,so to 
		//get that previous session itself
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		HttpSession session=req.getSession(false);
		if(session!=null) {
			//valid sessions
			String empIdval=req.getParameter("empId");
			Integer empId= Integer.parseInt(empIdval);
			EmployeeBean empbean=service.searchEmployee(empId);

			if(empbean!=null) {
				out.println("<h3>Employee Id "+empId +" </h3>");
				out.println("<h3>Name "+empbean.getName() +" </h3>");
				out.println("<h3>Age "+empbean.getAge() +" </h3>");
				out.println("<h3>Salary "+empbean.getSalary() +"</h3>");
				out.println("<h3>Designation "+empbean.getDesignation() +"</h3>");
			}

			else
			{
				System.out.println("<h3 style=color:red>EmployeeID"+empId+"Not Found");
			}

		}else {
			//invalid sessions
			out.println("Please login first");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}
	}
}

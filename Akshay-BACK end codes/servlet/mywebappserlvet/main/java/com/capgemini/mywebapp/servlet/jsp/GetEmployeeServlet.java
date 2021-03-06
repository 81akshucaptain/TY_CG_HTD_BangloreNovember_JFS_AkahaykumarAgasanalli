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
@WebServlet("/searchEmployee3")
public class GetEmployeeServlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//VALID SESSION
			//get the form data
			Integer empId=Integer.parseInt(req.getParameter("empid"));
			EmployeeBean empbean=service.searchEmployee(empId);
			req.setAttribute("empbean", empbean);
			req.getRequestDispatcher("./searchEmpFormJsp.jsp").forward(req, resp);
		}else {
			//INVALIID SESSIONS
			req.setAttribute("msg", "Please Login First..!");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}//end of doget
}//end of class

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
@WebServlet("/login2")
public class LoginServlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("empId"));
		String password=req.getParameter("password");
		EmployeeBean empbean=service.authenticate(empId, password);
		if(empbean!=null) {
			//VALIID CREDENTIALS
			HttpSession session=req.getSession(true);
			session.setMaxInactiveInterval(60);
			session.setAttribute("empbean", empbean);
			req.getRequestDispatcher("./homePageJsp.jsp").forward(req, resp);

		}else {
		//INVALIID CREDENTIALS
		req.setAttribute("msg", "Invalid Credentials..!");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}//end of doPOST
}//end of class














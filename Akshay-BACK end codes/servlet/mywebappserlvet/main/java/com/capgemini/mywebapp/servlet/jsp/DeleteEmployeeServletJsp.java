package com.capgemini.mywebapp.servlet.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;
@WebServlet("/deleteEmployee2")
public class DeleteEmployeeServletJsp extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//VALLID SESSION
			int empId=Integer.parseInt(req.getParameter("empId"));
			boolean isDeleted=service.deleteEmployee(empId);
			if(isDeleted) {
				req.setAttribute("msg","REcord got deleted Successfully with empId: "+empId+" DELETED..!");
			}else {
				req.setAttribute("msg", "EmployeeID not found i.e,="+empId);
			}
			req.getRequestDispatcher("./deleteEmpJsp.jsp").forward(req, resp);


		}else {
			//INVALIID SESSIONS
			req.setAttribute("msg", "Please Login First..!");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}

}

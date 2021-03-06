package com.capgemini.mywebapp.servlet.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;

@WebServlet("/seeAllEmoloyees")
public class SeeAllEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//VALLID session
			List<EmployeeBean> emplist=service.getAllEmployees();
			if(emplist!=null && !emplist.isEmpty()) {
				req.setAttribute("emplist", emplist);
			}else {
				req.setAttribute("msg", "there is no emplyee to display..!");
			}
			req.getRequestDispatcher("./seeAllEmoloyeesJsp.jsp").forward(req, resp);

		}else {
			req.setAttribute("msg", "please Login First..!");
			req.getRequestDispatcher("./loginForm").include(req, resp);

		}

	}

}//end of class

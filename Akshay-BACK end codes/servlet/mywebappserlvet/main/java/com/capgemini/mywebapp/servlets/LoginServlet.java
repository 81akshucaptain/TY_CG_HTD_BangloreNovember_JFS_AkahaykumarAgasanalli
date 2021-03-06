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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private EmployeeService empservice=new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal=req.getParameter("empId");
		String passwpord=req.getParameter("password");
		int emp_id=Integer.parseInt(empIdVal);
		//int emp_id=Integer.parseInt(empIdVal);
		EmployeeBean empbean=empservice.authenticate(emp_id, passwpord);

		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<body>");

		if(empbean!=null) {
			//valid credentials
			HttpSession session=req.getSession(true);
			//to add user details to the sessions
			session.setAttribute("EmployeeBean", empbean);
			out.print("<h2 style='color:blue'> welcome"+empbean.getName()+"!</h2>");
			out.print("<br> <a href='./addEmp.html'> Add employee</a>");
			out.print("<br> <a href='#'> update employee</a>");
			out.print("<br> <a href='./deleteEmp.html'> delete employee</a>");
			out.print("<br> <a href='./searchEmpfile.html'> search employee</a>");
			out.print("<br> <a href='#'> see all employees</a>");
			out.print("<br> <a href='./Logout'> Logout</a>");
		}else {
			//invalid sessions
			out.print("<h3 style='color:red'>invalid Credentials</h3>");
			req.getRequestDispatcher("./loginPage.html").include(req,resp);

		}
		out.print("</body>");
		out.print("</html>");



	}//end of do post
}//end of class

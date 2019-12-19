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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl(); 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session!=null) {
			//VALID SESSION
			//GET THE FORM DATA
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
			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if(isAdded) {
				out.println("<h3 style='color:blue'> Employeee ADDED succesfully</h3>");
			}else {
				out.println("<h3 style='color:blue'>UNABLE to adad EMpoyee </h3>");
			}
			out.println("</html>");
			out.println("</body>");

			req.getRequestDispatcher("./addEmp.html").include(req, resp);
		}else {
			//INVALLID SESSIONS
			PrintWriter out=resp.getWriter();

			out.println("<html>");
			out.println("<body>");
			out.println("<h3 style='color:red'> Pleaase Login Fiirst</h3>");
			out.println("</html>");
			out.println("</body>");

			req.getRequestDispatcher("./loginPage.html").include(req, resp);			
		}
	}//END OF DOPOST

}//END OF CLASS

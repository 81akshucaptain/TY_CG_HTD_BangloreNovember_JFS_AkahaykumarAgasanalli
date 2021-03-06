package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImpl;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	//IN ORDER TO DELETE FIRST VALIDATE HIM,SOO
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		out.println(" <html>");
		out.println(" <body>");

		if(session!=null) {
			//valid session
			//so get the data first
			int empId=Integer.parseInt(req.getParameter("empId"));
			
			if(service.deleteEmployee(empId)) {
				
				out.println(" <h3 style='color:blue'>Employee succesfully deleted, with employeeID:"+empId);
			}else {
				out.println(" <h3 style='color:red'>Employee with employeeID:"+empId+" is NOT found</h3>");

			}
		}
		//SO DONE WITH DELETION OPERATION AND HENCE REDIRECT TO REQUIRED PAGES
		else {
			out.println(" <h3 style='color:red'>YOU ARE LOGGED OUT </h3>");
		}
		out.println(" </body>");
		out.println(" </html>");
		req.getRequestDispatcher("./deleteEmp.html").include(req, resp);

	}//end of doget
}//end of class

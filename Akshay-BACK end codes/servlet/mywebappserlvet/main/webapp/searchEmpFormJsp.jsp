<%@page import="com.capgemini.mywebapp.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%
	EmployeeBean empbean = (EmployeeBean) request.getAttribute("empbean");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Search Employee</legend>
		<form action="./searchEmployee3" method="get">
			Employee ID:<input type="number" name="empid" required> <br>
			<input type="submit" value="search">
		</form>
	</fieldset>
	<%
		if (empbean == null) {
	%>
	<h3 style='color: blue'>employee ID not found..!</h3>
	<%
		} else {
	%>
	<h3 style='color: green'>
		Details of Employee with ID
		<%=empbean.getEmpid()%></h3>
	<br> Employee name:
	<%=empbean.getName()%><br> Employee age:<%=empbean.getAge()%><br>
	Employee salary:<%=empbean.getSalary()%><br> Employee Designation:<%=empbean.getDesignation()%>
	<%
		}
	%>
</body>
</html>
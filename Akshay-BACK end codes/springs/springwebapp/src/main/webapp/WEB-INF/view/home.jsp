<%@page import="com.capgemini.springwebapp.beans.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="eBean"
	class="com.capgemini.springwebapp.beans.EmployeeBean" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword"> change password </a>
	<a href="./logout" style="float: right;">logout</a>
	<h1>
		welcome
		<%=eBean.getName()%></h1>
	<form action="./search" >
		<!-- by default method name will be get if we don't have sensitive  -->
		<!-- data and we wont prepare to choose post -->
		<table>
			<tr>
				<td>Enter key:</td>
				<td><input type="text" name="key"></td>
				<td><input type="submit" value="search"></td>
			</tr>
		</table>
	</form>
	<%
		List<EmployeeBean> list = (List<EmployeeBean>) request.getAttribute("emplist");
	%>
	<%
		if (list != null) {
			if (list.isEmpty()) {
	%>
	<h3>No DATA found</h3>
	<%
		} else {
	%>
	<!-- 	To do task -->
	<table>
		<tr>
			<th>Id:</th>
			<th>Name:</th>
			<th>Email:</th>
		</tr>
		<%
			for (EmployeeBean emp : list) {
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getEmail()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	}
	%>
</body>
</html>


















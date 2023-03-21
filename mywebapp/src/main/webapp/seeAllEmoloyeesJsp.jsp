<%@page import="com.capgemini.mywebapp.bean.EmployeeBean"%>
<%@page import="java.util.List"%>

<% /*PLEASE IMPORT THE PACKGES STARTING ITSELF*/%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%
	List<EmployeeBean> emplist = (List<EmployeeBean>) request.getAttribute("emplist");
%>
<%String msg=(String )request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>
		<a href="./home"> Home</a>
	</h4>
	<%
		if (emplist != null && !emplist.isEmpty()) {
	%>
	<table>
		<tr>
			<th>EMpi ID</th>
			<th>Name</th>
			<th>age</th>
			<th>Salary</th>
			<th>Designation</th>
		</tr>
		<%
			for (EmployeeBean empbean : emplist) {
		%>
		<tr>
			<td><%=empbean.getEmpid()%></td>
			<td><%=empbean.getName()%></td>
			<td><%=empbean.getAge()%></td>
			<td><%=empbean.getSalary()%></td>
			<td><%=empbean.getDesignation()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} 
		%>
		<% if(msg!=null && !msg.isEmpty()) {%>
			<h3 style='color: blue'><%=msg %></h3>
		
		<% }%>
</body>
</html>